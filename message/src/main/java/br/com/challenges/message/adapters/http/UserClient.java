package br.com.challenges.message.adapters.http;

import br.com.challenges.message.application.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("user")
public interface UserClient {
    @RequestMapping(method = RequestMethod.GET, value = "user/{userName}")
    UserDto getUser(@PathVariable String userName);
}
