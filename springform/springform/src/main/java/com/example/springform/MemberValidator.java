package com.example.springform;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class MemberValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        //return true; // 모든 DTO에 대해서 validation을 사용하겠다.
        return Member.class.equals(clazz); // Member 클래스에 대해서만 Validation
    }

    @Override
    public void validate(Object target, Errors errors) {

        ValidationUtils.rejectIfEmpty(errors, "name", "", "값이 없으면 안됨"); // validation이 Null인지 확인

        Member member = (Member) target;
        if(member.getAge() > 100) {
            errors.rejectValue("age", "", "100보다 크면 안됨~~");
        }

    }
}
