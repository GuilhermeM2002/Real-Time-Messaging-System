package br.com.challenges.user.controller;

import br.com.challenges.user.application.dto.UserDto;
import br.com.challenges.user.infra.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;
    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody UserDto dto, UriComponentsBuilder uriComponentsBuilder){
        var user = service.saveUser(dto);
        var uri = uriComponentsBuilder.path("user/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).body(user);
    }
    @GetMapping("/{userName}")
    public ResponseEntity<UserDto> findUser(@PathVariable String userName){
        var user = service.findUserByUserName(userName);

        return ResponseEntity.ok(user);
    }
}
