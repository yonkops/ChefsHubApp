package com.lcsoft.ChefsHubApp.web;


import com.lcsoft.ChefsHubApp.model.dto.UserRegistrationDTO;
import com.lcsoft.ChefsHubApp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
@Controller
public class UserRegistrationController {

  private final UserService userService;

  public UserRegistrationController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/register")
  public String register() {
    return "auth-register";
  }

  @PostMapping("/register")
  public String register(UserRegistrationDTO registrationDto) {
      userService.registerUser(registrationDto);
      return "redirect:/";
  }
}
