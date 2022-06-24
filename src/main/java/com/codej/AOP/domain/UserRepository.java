package com.codej.AOP.domain;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        users.add(new User(1L,"codej","1234","010-4623-2891"));
        users.add(new User(2L,"codek","1234","010-4623-2891"));
        users.add(new User(3L,"codel","1234","010-4623-2891"));

        return users;

    }
    public User findById(Long id){

        return new User(1L,"codej","1234","01046232891");
    }

    public void save(User user){
        System.out.println("DB에 Insert 하기");
    }
}
