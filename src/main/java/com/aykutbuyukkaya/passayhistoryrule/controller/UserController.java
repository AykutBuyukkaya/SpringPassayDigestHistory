package com.aykutbuyukkaya.passayhistoryrule.controller;

import com.aykutbuyukkaya.passayhistoryrule.model.request.CreateUserRequest;
import com.aykutbuyukkaya.passayhistoryrule.model.request.PasswordChangeRequest;
import com.aykutbuyukkaya.passayhistoryrule.model.response.BaseResponse;
import com.aykutbuyukkaya.passayhistoryrule.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<BaseResponse> createUser(@RequestBody CreateUserRequest request) {
        return ResponseEntity.ok(userService.createUser(request));
    }

    @PostMapping("/change-password")
    public ResponseEntity<BaseResponse> changePassword(@RequestBody @Valid PasswordChangeRequest request) {
        return ResponseEntity.ok(userService.changePassword(request));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponse> handle(MethodArgumentNotValidException e) {

        final String validationErrorMessages = Arrays.stream(Objects.requireNonNull(e.getDetailMessageArguments()))
                .map(Objects::toString)
                .collect(Collectors.joining());

        return ResponseEntity.badRequest()
                .body(BaseResponse.builder()
                        .timestamp(Instant.now())
                        .message(validationErrorMessages)
                        .build());


    }

}
