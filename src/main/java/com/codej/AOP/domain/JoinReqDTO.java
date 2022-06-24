package com.codej.AOP.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class JoinReqDTO {

    @NotNull(message = "username 키값이 없습니다.")
    @NotBlank(message = "username을 입력하세요")
    @Size(max = 20,message = "username의 길이를 초과하였습니다.")
    private String username;

    @NotNull(message = "비밀번호가 없습니다.")
    private String password;
    @NotNull(message = "휴대번호 입력값은 필수 값입니다.")
    private String phone;

}
