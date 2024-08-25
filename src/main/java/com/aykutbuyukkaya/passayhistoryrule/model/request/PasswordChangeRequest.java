package com.aykutbuyukkaya.passayhistoryrule.model.request;

import com.aykutbuyukkaya.passayhistoryrule.util.ValidPasswordChange;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ValidPasswordChange
public class PasswordChangeRequest {

    private Integer id;
    private String username;
    private String newPassword;

}
