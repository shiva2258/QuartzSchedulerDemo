package com.balaji.quartzScheduler.scheduler;

import java.util.List;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import com.balaji.quartzScheduler.repositories.FruitRepo;

@Component
public class ScheduledJob extends QuartzJobBean {

	@Autowired
	FruitRepo repo;
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		JobDataMap mergedJobDataMap = context.getMergedJobDataMap();
		for (String key : mergedJobDataMap.getKeys()) {
			System.out.println("\nFrom Scheduled Job: " + mergedJobDataMap.get(key));
		}
		
		 List<String> fruitName = repo.findUniqueFruitName();
		 for(String fruit : fruitName) {
			 System.out.println("\tFruit: " + fruit + " and Count: " + repo.countByFruitName(fruit));
		 }
	}

}
