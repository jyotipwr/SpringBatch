package com.poc.batch.SpringBootBatchPoc.dao;

import java.util.List;

import com.poc.batch.SpringBootBatchPoc.model.Person;

public interface PersonDao {
	public void insert(List<? extends Person> persons);
	public void insert(Person persons);
	List<Person> loadAllPersons();
	public void update(Person person);
}
