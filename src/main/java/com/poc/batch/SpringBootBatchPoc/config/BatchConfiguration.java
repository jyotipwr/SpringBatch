package com.poc.batch.SpringBootBatchPoc.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.poc.batch.SpringBootBatchPoc.dao.PersonDao;
import com.poc.batch.SpringBootBatchPoc.listener.JobCompletionNotificationListener;
import com.poc.batch.SpringBootBatchPoc.model.Person;
import com.poc.batch.SpringBootBatchPoc.step.Processor;
import com.poc.batch.SpringBootBatchPoc.step.Reader;
import com.poc.batch.SpringBootBatchPoc.step.Writer;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	public PersonDao personDao;

	@Bean
	public Job job() {
		return jobBuilderFactory.get("job").incrementer(new RunIdIncrementer()).listener(new JobCompletionNotificationListener(personDao))
				.flow(step1()).end().build();
	}
 
	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1").<Person, Person>chunk(500)
				.reader(Reader.reader("persons.csv"))
				.processor(new Processor()).writer(new Writer(personDao)).build();
	}


	/*@Bean
	public Job importUserJob(JobCompletionNotificationListener listener) {
		return jobBuilderFactory.get("importUserJob").incrementer(new RunIdIncrementer()).listener(listener)
				.flow(step1()).end().build();
	}

	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1").<Person, Person>chunk(1000).reader(reader()).processor(processor())
				.writer(writer()).build();
	}*/
}