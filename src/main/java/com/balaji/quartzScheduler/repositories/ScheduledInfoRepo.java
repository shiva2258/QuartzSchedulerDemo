package com.balaji.quartzScheduler.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.balaji.quartzScheduler.entities.ScheduledInfo;

public interface ScheduledInfoRepo extends JpaRepository<ScheduledInfo, Long> {
	
	public ScheduledInfo findByJobName(String jobName);

}
