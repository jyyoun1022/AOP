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
    public void findById(@PathVariable Long id){
        log.info("findById");
    }

    @PostMapping("/user")
    //x-www-form-urlencoded = (request.getParameter())
    public void save(String username,String password,String phone){
        log.info("save");

    }
    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable Long id){
        log.info("delete");
    }

    @PutMapping("/user/{id}")
    public void modify(@PathVariable Long id,String password,String phone){
        log.info("modify");
    }
}
