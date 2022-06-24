package com.codej.AOP.controller;

import com.codej.AOP.domain.JoinReqDTO;
import com.codej.AOP.domain.UpdateReqDTO;
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
    public ResponseEntity<String> save(@RequestBody JoinReqDTO dto){
        log.info("save");
        System.out.println("dto = " + dto);
        userRepository.save(dto);
        return new ResponseEntity<>("ok",HttpStatus.OK);
    }
    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable Long id){
        log.info("delete");
        return "ok";
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<UpdateReqDTO> modify(@PathVariable Long id,@RequestBody UpdateReqDTO dto){
        log.info("modify");
        userRepository.modify(id,dto);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
