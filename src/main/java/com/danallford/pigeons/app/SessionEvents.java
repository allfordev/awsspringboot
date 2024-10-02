package com.danallford.pigeons.app;

import com.danallford.pigeons.app.kafka.MessageProducer;
import com.danallford.pigeons.app.login.LoginEvent;
import com.danallford.pigeons.app.login.SessionRepository;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.authentication.event.LogoutSuccessEvent;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SessionEvents {

    final MessageProducer producer;

    final SessionRepository sessionRepository;

    public SessionEvents(MessageProducer producer, SessionRepository sessionRepository) {
        this.producer = producer;
        this.sessionRepository = sessionRepository;
    }

    @EventListener
    public void onLogin(AuthenticationSuccessEvent event) {
        // ...
        System.out.println("Logged in");
        //producer.send("Login for " + event.getAuthentication().getDetails() + " at " + new Date());

        LoginEvent loginEvent = new LoginEvent();
        loginEvent.setUsername(event.getAuthentication().getName());
        loginEvent.setEventTime(new Date(event.getTimestamp()));
        loginEvent.setEventType(LoginEvent.EventType.LOGGED_IN);
        sessionRepository.save(loginEvent);
    }

    @EventListener
    public void onFailedLogin(AbstractAuthenticationFailureEvent event) {
        // ...
        System.out.println("Failure to login");

        LoginEvent loginEvent = new LoginEvent();
        loginEvent.setUsername(event.getAuthentication().getName());
        loginEvent.setEventTime(new Date(event.getTimestamp()));
        loginEvent.setEventType(LoginEvent.EventType.FAILED_LOGIN);
        sessionRepository.save(loginEvent);
    }

    @EventListener
    public void onLogout(LogoutSuccessEvent event) {
        // ...
        System.out.println("Logged out");

        LoginEvent loginEvent = new LoginEvent();
        loginEvent.setUsername(event.getAuthentication().getName());
        loginEvent.setEventTime(new Date(event.getTimestamp()));
        loginEvent.setEventType(LoginEvent.EventType.LOGGED_OUT);
        sessionRepository.save(loginEvent);
    }
}