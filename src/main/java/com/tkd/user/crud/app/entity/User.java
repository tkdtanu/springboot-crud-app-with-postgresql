package com.tkd.user.crud.app.entity;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tarun.das
 *
 */
@Entity(name = "Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", columnDefinition = "serial")
	private Long userId;
	@Column(name = "Name")
	private String name;
	@Column(name = "DOB", columnDefinition = "DATE")
	private LocalDate dob;
	@Transient
	private long age;
	@Column(name = "Address")
	private String address;

	public long getAge() {
		return ChronoUnit.YEARS.between(dob, LocalDate.now());
	}

}
