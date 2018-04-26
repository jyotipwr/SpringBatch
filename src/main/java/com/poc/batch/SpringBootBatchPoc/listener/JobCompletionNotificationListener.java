package com.poc.batch.SpringBootBatchPoc.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

import com.poc.batch.SpringBootBatchPoc.dao.WpdProjectDao;


public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

	private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

/*	private final WpdProjectDao wpdProjectDao;

	public JobCompletionNotificationListener(WpdProjectDao wpdProjectDao) {
		this.wpdProjectDao = wpdProjectDao;
	}*/

	@Override
	public void afterJob(JobExecution jobExecution) {
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			log.info("Finish Job! Check the results");

			/*List<Person> persons = personDao.loadAllPersons();

			for (Person person : persons) {
				log.info("Found <" + person + "> in the database.");
			}*/
		}
	}
}