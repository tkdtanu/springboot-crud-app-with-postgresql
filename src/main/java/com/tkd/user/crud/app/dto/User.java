package com.tkd.user.crud.app.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class User {
	private Long userId;
	private String name;
	private LocalDate dob;
	private long age;
	private String address;

	public static User entityToDto(com.tkd.user.crud.app.entity.User userEntity) {
		User user = new User();
		user.setUserId(userEntity.getUserId());
		user.setName(userEntity.getName());
		user.setDob(userEntity.getDob());
		user.setAge(userEntity.getAge());
		user.setAddress(userEntity.getAddress());
		return user;
	}

	public com.tkd.user.crud.app.entity.User toEntity() {
		com.tkd.user.crud.app.entity.User user = new com.tkd.user.crud.app.entity.User();
		user.setUserId(this.getUserId());
		user.setName(this.getName());
		user.setDob(this.getDob());
		user.setAge(this.getAge());
		user.setAddress(this.getAddress());
		return user;
	}
}
