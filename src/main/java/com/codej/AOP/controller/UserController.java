package com.codej.AOP.controller;

import com.codej.AOP.domain.User;
import com.codej.AOP.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;


    @GetMapping("/user")
    public ResponseEntity<List<User>> findAll(){
        List<User> users = userRepository.findAll();
        log.info("findAll");
       return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id){
        log.info("findById : "+id);
        return userRepository.findById(id);
    }

    @PostMapping("/user")
    //x-www-form-urlencoded = (request.getParameter())
    public ResponseEntity<String> save(@RequestBody User user){
        log.info("save");
        System.out.println("username = " + user.getUsername());
        System.out.println("password = " + user.getPassword());
        System.out.println("phone = " + user.getPhone());
        userRepository.save(user);
        return new ResponseEntity<>("ok",HttpStatus.OK);
    }
    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable Long id){
        log.info("delete");
        return "ok";
    }

    @PutMapping("/user/{id}")
    public void modify(@PathVariable Long id,String password,String phone){
        log.info("modify");
    }
}
