package com.lcsoft.ChefsHubApp.web;


import com.lcsoft.ChefsHubApp.model.dto.UserRegistrationDto;
import com.lcsoft.ChefsHubApp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
@Controller
public class UserRegistrationController {

  private final UserService userService;

  public UserRegistrationController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/register")
  public String register(UserRegistrationDto userRegistrationDTO) {
    return "auth-register";
  }

  @PostMapping("/register")
  public String register(@Valid UserRegistrationDto registrationDto, BindingResult bindingResult) {
    if (bindingResult.hasErrors()){
      return "auth-register";
    }
      userService.registerUser(registrationDto);
      return "redirect:/users/login";
  }
}
