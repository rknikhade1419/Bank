package com.reljicd.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * Global exception handler for the Banking System
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView exception(final Throwable throwable, final Model model) {
        // Log the full error to the console/files for the developer to see
        logger.error("Banking System Error: ", throwable);

        ModelAndView modelAndView = new ModelAndView("/error");
        
        // UPDATED: In a bank app, we want to be careful not to show internal code errors
        // to the customer. We show a polite message instead.
        String friendlyMessage = "We are currently experiencing technical difficulties. " +
                                 "Rest assured, your funds are safe. Please try again later.";
        
        modelAndView.addObject("errorMessage", friendlyMessage);
        return modelAndView;
    }
}
