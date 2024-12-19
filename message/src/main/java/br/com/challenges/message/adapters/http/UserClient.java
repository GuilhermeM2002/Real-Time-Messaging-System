package br.com.challenges.message.adapters.http;

import br.com.challenges.message.application.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user", url = "http://localhost:8093/user")
public interface UserClient {
    @RequestMapping(method = RequestMethod.GET)
    UserDto getUser(@RequestParam String userName);
}
