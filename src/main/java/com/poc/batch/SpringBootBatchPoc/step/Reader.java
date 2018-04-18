package com.poc.batch.SpringBootBatchPoc.step;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;

import com.poc.batch.SpringBootBatchPoc.model.Person;

public class Reader {
	public static FlatFileItemReader<Person> reader(String path) {
		FlatFileItemReader<Person> reader = new FlatFileItemReader<Person>();
 
		reader.setResource(new ClassPathResource(path));
		reader.setLineMapper(new DefaultLineMapper<Person>() {
			{
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames(new String[] { "firstName", "lastName", "email", "age", "insertFlag" });
					}
				});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<Person>() {
					{
						setTargetType(Person.class);
					}
				});
			}
		});
		return reader;
	}
}
