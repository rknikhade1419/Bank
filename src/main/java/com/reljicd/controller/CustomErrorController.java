package com.reljicd.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller to handle specialized HTTP error routing for the Banking Portal.
 */
@RestController
public class CustomErrorController implements ErrorController {

    private static final String PATH = "/error";

    /**
     * Handles general errors (404, 500, etc.) by routing to the custom error page.
     */
    @RequestMapping(PATH)
    public ModelAndView error() {
        // This returns the error.html template we updated earlier
        return new ModelAndView("/error");
    }

    /**
     * Specifically handles Access Denied (403) situations.
     * Triggered by MyAccessDeniedHandler redirect.
     */
    @GetMapping("/403")
    public ModelAndView error403() {
        // This returns the 403.html template we updated earlier
        return new ModelAndView("/403");
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
