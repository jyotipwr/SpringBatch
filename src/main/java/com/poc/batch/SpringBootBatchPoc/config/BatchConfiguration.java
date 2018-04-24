package com.poc.batch.SpringBootBatchPoc.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;

import com.poc.batch.SpringBootBatchPoc.dao.PersonDao;
import com.poc.batch.SpringBootBatchPoc.listener.JobCompletionNotificationListener;
import com.poc.batch.SpringBootBatchPoc.model.Person;
import com.poc.batch.SpringBootBatchPoc.model.ProjectData;
import com.poc.batch.SpringBootBatchPoc.step.Processor;
import com.poc.batch.SpringBootBatchPoc.step.Reader;
import com.poc.batch.SpringBootBatchPoc.step.Writer;

@Configuration
public class BatchConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	public PersonDao personDao;
	
	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job job;
	
	@Autowired
	private Environment env;
	
	@Scheduled(fixedRate = 600000)
	public void printMessage() {
		try {
			System.err.println("I have started schedular ");
			JobParameters jobParameters = new JobParametersBuilder().addLong(
					"time", System.currentTimeMillis()).toJobParameters();
			jobLauncher.run(job, jobParameters);
			System.err.println("I have been scheduled with Spring scheduler");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Bean
	public Job job() {
		return jobBuilderFactory.get("job").incrementer(new RunIdIncrementer()).listener(new JobCompletionNotificationListener(personDao))
				.flow(step1()).end().build();
	}
 
	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1").<ProjectData, ProjectData>chunk(500)
				.reader(Reader.reader(env.getProperty("file.name")))
				.processor(new Processor()).writer(new Writer(personDao)).build();
	}


}