package com.aykutbuyukkaya.passayhistoryrule.mapper;

import com.aykutbuyukkaya.passayhistoryrule.model.entity.User;
import com.aykutbuyukkaya.passayhistoryrule.model.request.CreateUserRequest;
import com.aykutbuyukkaya.passayhistoryrule.model.request.PasswordChangeRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);


    User fromCreateUserRequest(CreateUserRequest createUserRequest);



}
