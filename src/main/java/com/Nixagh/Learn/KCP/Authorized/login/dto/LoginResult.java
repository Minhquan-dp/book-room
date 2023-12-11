package com.Nixagh.Learn.KCP.Authorized.login.dto;

import com.Nixagh.Learn.common.dto.AbsDto;

import javax.validation.constraints.NotEmpty;

public class LoginResult extends AbsDto {
  public String token;
  @NotEmpty(message = "Please enter a username")
  public String username;
  public String id;
  @NotEmpty(message = "Please enter a password")
  public String password;
  public String timestamp;
}
