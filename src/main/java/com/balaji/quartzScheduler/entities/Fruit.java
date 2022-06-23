package com.balaji.quartzScheduler.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Fruit {
	
	@Id
	@GeneratedValue
	private Long fruitId;
	private String fruitName;

}
