package com.balaji.quartzScheduler.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.balaji.quartzScheduler.entities.Fruit;

public interface FruitRepo extends JpaRepository<Fruit, Long> {
	
	public Long countByFruitName(String fruitName);
	
	@Query("select distinct fruitName from Fruit")
	public List<String> findUniqueFruitName();

}