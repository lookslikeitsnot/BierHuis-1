package be.vdab.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created on 23/12/2015 at 00:57.
 */
@ControllerAdvice
class ErrorController {
    private static final String ERROR_REDIRECT = "redirect:/error";

    @ExceptionHandler(Exception.class)
    String redirectToErrorView() {
        return ERROR_REDIRECT;
    }
}
