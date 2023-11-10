package com.lcsoft.ChefsHubApp.web;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.lcsoft.ChefsHubApp.model.dto.UserDto;
import jakarta.validation.Valid;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserLoginController {
    private final AuthenticationManager authenticationManager;
    public UserLoginController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("/login")
    public String login() {
        return "auth-login";
    }

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute("loginForm") @Valid UserDto loginForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "auth-login";
        }

        // Perform authentication
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                loginForm.getEmail(),
                loginForm.getPassword()
        );

        Authentication authentication = authenticationManager.authenticate(authRequest);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "redirect:/";
    }


    @PostMapping("/login-error")
    public String ofFailure(
            @ModelAttribute("email") String email,
            Model model) {
        model.addAttribute("email", email);
        model.addAttribute("bad_credentials", "true");
        return "auth-login";
    }

    @GetMapping("/user")
    public String getUser(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        ObjectMapper objectMapper = new ObjectMapper();
        UserDto userDto = objectMapper.convertValue(authentication, UserDto.class);

        model.addAttribute("userDto", userDto);

        return "profile";
    }
}