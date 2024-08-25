package com.aykutbuyukkaya.passayhistoryrule.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseResponse {

    private String message;
    private Instant timestamp;

}
