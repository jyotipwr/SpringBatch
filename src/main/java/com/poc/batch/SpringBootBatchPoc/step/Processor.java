package com.poc.batch.SpringBootBatchPoc.step;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.poc.batch.SpringBootBatchPoc.model.Person;

public class Processor implements ItemProcessor<Person, Person> {

	private static final Logger log = LoggerFactory.getLogger(Processor.class);

	@Override
	public Person process(final Person person) throws Exception {
		final String firstName = person.getFirstName().toUpperCase();
		final String lastName = person.getLastName().toUpperCase();

		final Person transformedPerson = new Person(firstName, lastName, person.getEmail(), person.getAge(), person.getInsertFlag());

		log.info("Converting (" + person + ") into (" + transformedPerson + ")");

		return transformedPerson;
	}

}