package com.aykutbuyukkaya.passayhistoryrule.service.impl;

import com.aykutbuyukkaya.passayhistoryrule.mapper.UserPasswordsMapper;
import com.aykutbuyukkaya.passayhistoryrule.model.entity.UserPasswords;
import com.aykutbuyukkaya.passayhistoryrule.model.entity.UserPasswordsDto;
import com.aykutbuyukkaya.passayhistoryrule.repository.UserPasswordsRepository;
import com.aykutbuyukkaya.passayhistoryrule.service.UserPasswordsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPasswordsServiceImpl implements UserPasswordsService {

    private final UserPasswordsMapper userPasswordsMapper = UserPasswordsMapper.MAPPER;
    private final UserPasswordsRepository userPasswordsRepository;

    public UserPasswordsServiceImpl(UserPasswordsRepository userPasswordsRepository) {
        this.userPasswordsRepository = userPasswordsRepository;
    }

    @Override
    public List<String> getUserPasswords(Integer userId) {

        final List<UserPasswords> userPasswordsList = userPasswordsRepository.findTop3ByUserIdOrderByCreatedDateDesc(userId);
        final List<UserPasswordsDto> userPasswordsDtoList = userPasswordsMapper.toUserPasswordsDto(userPasswordsList);

        if(userPasswordsDtoList.isEmpty()){
            throw new RuntimeException("User has no password history");
        }

        return userPasswordsDtoList.stream().map(UserPasswordsDto::getPassword).toList();
    }

    @Override
    public void userPasswordChange(Integer userId, String password) {

        UserPasswords userPasswords = new UserPasswords();
        userPasswords.setUserId(userId);
        userPasswords.setPassword(password);

        userPasswordsRepository.save(userPasswords);

    }
}
