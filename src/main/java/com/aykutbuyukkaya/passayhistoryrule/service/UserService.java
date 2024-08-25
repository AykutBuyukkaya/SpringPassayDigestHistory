package com.aykutbuyukkaya.passayhistoryrule.service;

import com.aykutbuyukkaya.passayhistoryrule.model.request.CreateUserRequest;
import com.aykutbuyukkaya.passayhistoryrule.model.request.PasswordChangeRequest;
import com.aykutbuyukkaya.passayhistoryrule.model.response.BaseResponse;

public interface UserService {

    BaseResponse createUser(CreateUserRequest createUserRequest);

    BaseResponse changePassword(PasswordChangeRequest passwordChangeRequest);

}
