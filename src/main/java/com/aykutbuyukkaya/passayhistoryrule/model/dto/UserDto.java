package com.aykutbuyukkaya.passayhistoryrule.model.dto;

import com.aykutbuyukkaya.passayhistoryrule.model.entity.User;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link User}
 */
@Data
public class UserDto implements Serializable {
    private String username;
    private String password;
}