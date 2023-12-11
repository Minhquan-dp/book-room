package com.Nixagh.Learn.KCP.Authorized.login.dto;

import com.Nixagh.Learn.common.dto.AbsDto;

import javax.validation.constraints.NotEmpty;

public class LoginInfo extends AbsDto {
  @NotEmpty(message = "Please enter a username")
  public String username;

  @NotEmpty(message = "Please enter a password")
  public String password;
}
