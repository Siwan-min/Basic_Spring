package com.example.springform;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    public Member(String name, int age, String email){
        this.name = name;
        this.age = age;
        this.email = email;
    }

    private String userId;

    @NotNull
    private String name;

    @NotNull
    @Min(value = 10, message = "최소값은 10")
    private int age;

    @NotNull
    @Email(message = "잘못된 email 형식입니다.")
    private String email;

    private boolean gender;
}
