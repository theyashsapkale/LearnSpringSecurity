
package com.example.securityLearn.Servisec;

import com.example.securityLearn.Dto.UserRegisterRequestDto;
import com.example.securityLearn.Dto.UserRegisterResponseDto;
import com.example.securityLearn.entity.User;
import com.example.securityLearn.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServices {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServices(UserRepository userRepository,
                        PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserRegisterResponseDto register(
            UserRegisterRequestDto userRegisterRequestDto) {

        User user = new User();

        user.setUsername(userRegisterRequestDto.getUsername());

        String encodedPassword =
                passwordEncoder.encode(userRegisterRequestDto.getPassword());

        user.setPassword(encodedPassword);
        user.setEnabled(true);

        userRepository.save(user);

        UserRegisterResponseDto response =
                new UserRegisterResponseDto();

        response.setUsername(user.getUsername());
        response.setMessege("user saved successfully");

        return response;
    }
}
