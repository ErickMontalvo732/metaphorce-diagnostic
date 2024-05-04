package com.metaphorce.user.controller;

import com.metaphorce.databaseLib.entity.Usuario;
import com.metaphorce.user.dto.Message;
import com.metaphorce.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {


    @Autowired
    private UserService userService;


    @GetMapping("/getUsers")
    public ResponseEntity getUsers() {

        return ResponseEntity.ok("ok getUsers");
        //return ResponseEntity.ok(userService.findById(3L));
    }

    @PostMapping("/createUser")
    public ResponseEntity<Message> createUser(@RequestBody Message message) {
        return ResponseEntity.ok(message);
    }

    @GetMapping("/authorized")
    public Map<String, String> authorize(@RequestParam String code) {
        return Collections.singletonMap("code", code);
    }

}
