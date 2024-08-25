package com.aykutbuyukkaya.passayhistoryrule.util;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = PasswordChangeValidator.class)
public @interface ValidPasswordChange {

    String message() default "Invalid password!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}