package com.balaji.quartzScheduler.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class ScheduledInfo {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(unique = true)
	private String jobName;
	
	private String jobGroup;
	
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime startTime;
	
	private int counter;
	private int gapDuration;

}
