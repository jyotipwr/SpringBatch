package com.poc.batch.SpringBootBatchPoc.step;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;

import com.poc.batch.SpringBootBatchPoc.model.ProjectData;

public class Reader {
	public static FlatFileItemReader<ProjectData> reader(String path) {
		FlatFileItemReader<ProjectData> reader = new FlatFileItemReader<ProjectData>();

		reader.setResource(new ClassPathResource(path));

		reader.setLineMapper(new DefaultLineMapper<ProjectData>() {
			{
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames(new String[] { "projectNumber","projectDescription","projectType","projectCategory","platform",
								"projectGate","status","projectStartDate","projectEndDate","projectCreationDate","projectModificationDate","newProject"  });
					}
				});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<ProjectData>() {
					{
						setTargetType(ProjectData.class);
					}
				});
			}
		});
		return reader;
	}
}
