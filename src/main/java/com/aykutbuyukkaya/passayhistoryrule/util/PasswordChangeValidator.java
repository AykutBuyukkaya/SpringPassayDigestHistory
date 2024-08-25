package com.aykutbuyukkaya.passayhistoryrule.util;

import com.aykutbuyukkaya.passayhistoryrule.model.request.PasswordChangeRequest;
import com.aykutbuyukkaya.passayhistoryrule.service.UserPasswordsService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.cryptacular.bean.BCryptHashBean;
import org.passay.DigestHistoryRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.RuleResult;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PasswordChangeValidator implements ConstraintValidator<ValidPasswordChange, PasswordChangeRequest> {

    private final BCryptHashBean bCryptHashBean;
    private final UserPasswordsService userPasswordsService;

    public PasswordChangeValidator(BCryptHashBean bCryptHashBean, UserPasswordsService userPasswordsService) {
        this.bCryptHashBean = bCryptHashBean;
        this.userPasswordsService = userPasswordsService;
    }

    @Override
    public void initialize(ValidPasswordChange constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(PasswordChangeRequest passwordChangeRequest, ConstraintValidatorContext constraintValidatorContext) {

        PasswordValidator passwordValidator = new PasswordValidator(
                List.of(
                        new DigestHistoryRule(bCryptHashBean)
                )
        );


        final List<PasswordData.Reference> oldPasswords = userPasswordsService
                .getUserPasswords(passwordChangeRequest.getId()).stream()
                .map(s -> (PasswordData.Reference) new PasswordData.HistoricalReference(s)).toList();

        final PasswordData passwordData = new PasswordData(passwordChangeRequest.getUsername(),
                passwordChangeRequest.getNewPassword(), oldPasswords);

        RuleResult result = passwordValidator.validate(passwordData);

        if (result.isValid()) {
            return true;
        }

        constraintValidatorContext.buildConstraintViolationWithTemplate(String.join("", passwordValidator.getMessages(result)))
                .addConstraintViolation()
                .disableDefaultConstraintViolation();


        return false;
    }
}