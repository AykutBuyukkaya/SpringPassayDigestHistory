package com.aykutbuyukkaya.passayhistoryrule.service;

import java.util.List;

public interface UserPasswordsService {

    List<String> getUserPasswords(Integer userId);

    void userPasswordChange(Integer userId, String password);

}
