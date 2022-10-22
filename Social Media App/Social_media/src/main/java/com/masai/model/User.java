package com.masai.model;


import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	public static final String HttpStatus = null;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userid;
	
	@NotNull
	private String name;
	
	@Size(max = 10,min = 10 )
	private String mobileNo;
	
	@NotNull
	private String password;
	
	
	@NotNull
	private String email;
	
	@JsonIgnore
	@OneToMany
	List<Post> posts;

     @Embedded
     List<Followers> followers;
	
	
}