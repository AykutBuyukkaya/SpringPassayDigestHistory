package com.aykutbuyukkaya.passayhistoryrule.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link UserPasswords}
 */
@Data
public class UserPasswordsDto implements Serializable {
    private String password;
    private Date createdDate;
}