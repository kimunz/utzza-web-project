package com.oiji.springweb.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

@Component
public class CustomAuthFailureHandler implements AuthenticationFailureHandler {

    @Autowired
    private MessageSource messageSource;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String errorMessage = exception.getMessage();
        String username = request.getParameter("username");
        String defaultFailureUrl = "/login";

        if(exception instanceof BadCredentialsException) {
            errorMessage = messageSource.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", null , Locale.KOREA);
        } else if(exception instanceof InternalAuthenticationServiceException) {
            errorMessage = messageSource.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", null , Locale.KOREA);
        } else if(exception instanceof DisabledException) {
            errorMessage = messageSource.getMessage("AccountStatusUserDetailsChecker.disabled", null, Locale.KOREA);
        } else if(exception instanceof CredentialsExpiredException) {
            errorMessage = messageSource.getMessage("AccountStatusUserDetailsChecker.expired", null, Locale.KOREA);
        }

        request.setAttribute("username", username);
        request.setAttribute("errorMessage", errorMessage);

        request.getRequestDispatcher(defaultFailureUrl).forward(request, response);
    }
}
