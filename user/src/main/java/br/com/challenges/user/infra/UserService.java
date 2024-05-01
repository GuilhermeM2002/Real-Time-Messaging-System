package br.com.challenges.user.infra;

import br.com.challenges.user.core.domain.User;
import br.com.challenges.user.application.dto.UserDto;
import br.com.challenges.user.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{
    @Autowired
    private UserRepository repository;
    @Autowired
    private ModelMapper mapper;
    public UserDto saveUser(UserDto dto){
        var user = mapper.map(dto, User.class);
        repository.save(user);

        return  mapper.map(user, UserDto.class);
    }
}
