package com.aykutbuyukkaya.passayhistoryrule.service.impl;

import com.aykutbuyukkaya.passayhistoryrule.mapper.UserMapper;
import com.aykutbuyukkaya.passayhistoryrule.model.entity.User;
import com.aykutbuyukkaya.passayhistoryrule.model.request.CreateUserRequest;
import com.aykutbuyukkaya.passayhistoryrule.model.request.PasswordChangeRequest;
import com.aykutbuyukkaya.passayhistoryrule.model.response.BaseResponse;
import com.aykutbuyukkaya.passayhistoryrule.repository.UserRepository;
import com.aykutbuyukkaya.passayhistoryrule.service.UserPasswordsService;
import com.aykutbuyukkaya.passayhistoryrule.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper = UserMapper.MAPPER;
    private final PasswordEncoder passwordEncoder;
    private final UserPasswordsService userPasswordsService;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, UserPasswordsService userPasswordsService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userPasswordsService = userPasswordsService;
    }

    @Override
    public BaseResponse createUser(CreateUserRequest createUserRequest) {

        User user = userMapper.fromCreateUserRequest(createUserRequest);

        user.setPassword(passwordEncoder.encode(createUserRequest.getPassword()));

        final User savedUser = userRepository.save(user);

        userPasswordChange(savedUser);

        return BaseResponse.builder()
                .message("OK")
                .timestamp(Instant.now())
                .build();
    }

    @Override
    public BaseResponse changePassword(PasswordChangeRequest passwordChangeRequest) {

        User user = userRepository.findById(passwordChangeRequest.getId()).orElseThrow(() -> new RuntimeException("User not found"));

        user.setPassword(passwordEncoder.encode(passwordChangeRequest.getNewPassword()));

        final User savedUser = userRepository.save(user);

        userPasswordChange(savedUser);

        return BaseResponse.builder()
                .message("OK")
                .timestamp(Instant.now())
                .build();
    }

    private void userPasswordChange(User user) {
        userPasswordsService.userPasswordChange(user.getId(), user.getPassword());
    }
}
