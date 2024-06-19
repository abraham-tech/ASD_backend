package miu.edu.springsecuritydemo.controller;

import com.google.common.collect.ImmutableMap;
import miu.edu.springsecuritydemo.user.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Map;

import static miu.edu.springsecuritydemo.util.AppConstant.*;

public abstract class BaseController {
    public static final Instant TIMESTAMP = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant();

    protected User getUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    protected ResponseEntity<Map<String, Object>> getResponse(String statusType, String message, HttpStatus status) {
        Map<String, Object> body = statusType.equals(ERROR) ?
                ImmutableMap.of(statusType, ImmutableMap.of(STATUS, status, MESSAGE, message)) :
                ImmutableMap.of(STATUS, status, STATUS_TYPE, statusType, MESSAGE, message);
        return ResponseEntity.status(status).body(body);
    }

    protected ResponseEntity<Map<String, Object>> getResponse(String statusType, Object data, HttpStatus status) {
        Map<String, Object> body = statusType.equals(ERROR) ?
                ImmutableMap.of(statusType, ImmutableMap.of(STATUS, status, DATA, data)) :
                ImmutableMap.of(STATUS_TYPE, statusType, STATUS, status, DATA, data);
        return ResponseEntity.status(status).body(body);
    }
}
