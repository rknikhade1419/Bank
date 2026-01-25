package com.reljicd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

/**
 * Controller to handle Banking Portal authentication requests.
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Principal principal) {
        // If the user is already authenticated (session is active),
        // redirect them directly to the Banking Dashboard.
        if (principal != null) {
            return "redirect:/home";
        }
        
        // Otherwise, show the secure login page.
        return "/login";
    }

}
