package com.altimetrik.payment.mongodbrelationship.repository;

import com.altimetrik.payment.mongodbrelationship.model.Address;
import com.altimetrik.payment.mongodbrelationship.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlipcartRepostory extends MongoRepository<User,Integer> {

    List<User> findByName(String name);

    @Query("{'Address.city':?0}")
    List<User> findByCity(String city);
}
