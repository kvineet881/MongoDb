package com.altimetrik.payment.mongodbrelationship.controller;

import com.altimetrik.payment.mongodbrelationship.model.User;
import com.altimetrik.payment.mongodbrelationship.repository.FlipcartRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FlipcartController {
    @Autowired
    private FlipcartRepostory repostory;


    @PostMapping("/placeOrder")
    public String placeOrder(@RequestBody User user)
    {
        repostory.save(user);
        return "Order Placed Successfully... ";
    }

    @GetMapping("findUserById/{id}")
    public Optional<User> findUserById(@PathVariable int id)
    {
        return repostory.findById(id);
    }

    @GetMapping("/getUserByName/{name}")
    public List<User> getUserbyName(@PathVariable String name) {
        return repostory.findByName(name);
    }

    @GetMapping("/getUserByAddress/{city}")
    public List<User> getUserbyAddress(@PathVariable String city) {
        return repostory.findByCity(city);
    }
}
