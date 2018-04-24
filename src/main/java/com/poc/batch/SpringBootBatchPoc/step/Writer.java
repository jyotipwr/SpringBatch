package com.poc.batch.SpringBootBatchPoc.step;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.poc.batch.SpringBootBatchPoc.dao.PersonDao;
import com.poc.batch.SpringBootBatchPoc.model.Person;

public class Writer implements ItemWriter<Person> {

	private final PersonDao personDao;

	public Writer(PersonDao personDao) {
		this.personDao = personDao;
	}

	@Override
	public void write(List<? extends Person> persons) throws Exception {
		for (Person person : persons) {
			if (person.getInsertFlag() == 1) {
				personDao.insert(person);
			} else {
				personDao.update(person);
			}
		}
	}

}
