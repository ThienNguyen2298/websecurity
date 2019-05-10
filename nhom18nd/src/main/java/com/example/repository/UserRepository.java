package com.example.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	@Query("SELECT u FROM User u where u.gmail = :gmail AND u.pwd = :pwd")
	public User login(@Param("gmail") String gmail, @Param("pwd") String pwd);
}
