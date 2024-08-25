package com.aykutbuyukkaya.passayhistoryrule.mapper;

import com.aykutbuyukkaya.passayhistoryrule.model.entity.UserPasswords;
import com.aykutbuyukkaya.passayhistoryrule.model.entity.UserPasswordsDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserPasswordsMapper {

    UserPasswordsMapper MAPPER = Mappers.getMapper(UserPasswordsMapper.class);

    List<UserPasswordsDto> toUserPasswordsDto(List<UserPasswords> userPasswords);


}
