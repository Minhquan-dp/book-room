package com.Nixagh.Learn.KCP.Authorized.login.webService;

import com.Nixagh.Learn.KCP.Authorized.login.dto.LoginRequest;
import com.Nixagh.Learn.KCP.Authorized.login.dto.LoginResponse;
import com.Nixagh.Learn.KCP.Authorized.login.process.LoginProcess;
import com.Nixagh.Learn.common.dto.errorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class LoginWebService {
  @Autowired
  LoginProcess loginProcess;

  @PostMapping("Login")
  public LoginResponse login(@Valid @RequestBody LoginRequest request, BindingResult bindingResult) {
    LoginResponse response = new LoginResponse();


    if (bindingResult.hasErrors()) {
      // Xử lý các lỗi validation
      bindingResult.getAllErrors().forEach(error -> {
        String fieldName = ((FieldError) error).getField();
        String errorMessage = error.getDefaultMessage();
        response.addError(new errorDto(fieldName + "_ERROR", errorMessage));
      });
      return response;
    }

    return loginProcess.login(request.loginInfo,bindingResult);
  }
}