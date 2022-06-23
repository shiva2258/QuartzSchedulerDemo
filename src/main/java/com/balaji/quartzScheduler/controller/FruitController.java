package com.balaji.quartzScheduler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.balaji.quartzScheduler.entities.Fruit;
import com.balaji.quartzScheduler.entities.ScheduledInfo;
import com.balaji.quartzScheduler.scheduler.JobData;
import com.balaji.quartzScheduler.service.FruitService;

@RestController
public class FruitController {
	
	@Autowired
	FruitService service;
	
	@PostMapping("/saveFruit")
	public ResponseEntity<Fruit> saveFruit(@RequestBody Fruit fruit) {
		Fruit savedFruit = service.saveFruit(fruit);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedFruit);
	}
	
	@GetMapping("getAllFruits")
	public ResponseEntity<List<Fruit>> findAllFruits() {
		List<Fruit> allFruits = service.findAllFruits();
		return ResponseEntity.status(HttpStatus.OK).body(allFruits);
	}
	
	@GetMapping("getCount/name/{name}")
	public ResponseEntity<Long> countByFruitName(@PathVariable String name) {
		long count = service.countByFruitName(name);
		return ResponseEntity.status(HttpStatus.OK).body(count);
	}
	
	@DeleteMapping("deleteFruit/{id}")
	public ResponseEntity<Void> deleteByFruitId(@PathVariable Long id){
		service.deleteFruit(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
	@PostMapping("/schedule")
	public ResponseEntity<Void> schedule(@RequestBody JobData data) {
		service.schedule(data);
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}
	
	@GetMapping("/schedule")
	public ResponseEntity<List<ScheduledInfo>> findAllJobs() {
		List<ScheduledInfo> allJobs = service.findAllJobs();
		return ResponseEntity.status(HttpStatus.OK).body(allJobs);
	}
	
	@DeleteMapping("/schedule/{jobName}/{jobGroup}")
	public ResponseEntity<Void> deleteJob(@PathVariable String jobName, @PathVariable String jobGroup) {
		service.deleteJob(jobName, jobGroup);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		
	}

}
