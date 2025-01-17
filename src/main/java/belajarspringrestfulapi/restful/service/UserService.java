package belajarspringrestfulapi.restful.service;

import belajarspringrestfulapi.restful.entity.User;
import belajarspringrestfulapi.restful.model.RegisterUserRequest;
import belajarspringrestfulapi.restful.repository.UserRepository;
import belajarspringrestfulapi.restful.security.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidateService validateService;

    public void register(RegisterUserRequest request) {
        validateService.validate(request);

       if (userRepository.existsById(request.getUsername())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already registered");
       }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        user.setName(request.getName());

        userRepository.save(user);
    }
}
