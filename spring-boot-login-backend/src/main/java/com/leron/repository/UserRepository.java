package com.leron.repository;

import org.springframework.data.repository.CrudRepository;

import com.leron.models.User;

public interface UserRepository extends CrudRepository<User , Long> {
	
	public User findByEmail(String email);
}
