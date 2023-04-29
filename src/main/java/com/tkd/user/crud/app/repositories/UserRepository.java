package com.tkd.user.crud.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tkd.user.crud.app.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	public void deleteUserByUserId(Long id);

}
