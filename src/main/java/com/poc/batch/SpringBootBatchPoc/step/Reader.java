package com.poc.batch.SpringBootBatchPoc.step;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;

import com.poc.batch.SpringBootBatchPoc.dao.BatchTransInfoDao;
import com.poc.batch.SpringBootBatchPoc.model.BatchTransInfo;
import com.poc.batch.SpringBootBatchPoc.model.ProjectData;

public class Reader {

	public static FlatFileItemReader<ProjectData> reader(String path, BatchTransInfoDao batchTransInfoDao) {
		FlatFileItemReader<ProjectData> reader = new FlatFileItemReader<ProjectData>();
		BatchTransInfo batchInfo = new BatchTransInfo();
		try {
			batchInfo.setFileName(path);
			batchInfo.setStatus("In Progress");
			batchInfo = batchTransInfoDao.insert(batchInfo);
			String batchId = batchInfo.getBatchId().toString();
			reader.setResource(new ClassPathResource(path));

			reader.setLineMapper(new DefaultLineMapper<ProjectData>() {
				{
					setLineTokenizer(new DelimitedLineTokenizer() {
						{
							setNames(new String[] { "projectNumber", "projectDescription", "projectType",
									"projectCategory", "platform", "projectGate", "status", "projectStartDate",
									"projectEndDate", "projectCreationDate", "projectModificationDate", "newProject",
									batchId });
						}
					});
					setFieldSetMapper(new BeanWrapperFieldSetMapper<ProjectData>() {
						{
							setTargetType(ProjectData.class);
						}
					});
				}
			});

		} catch (Exception e) {
			batchInfo.setStatus("Failed");
			batchInfo.setErrorMessage(e.getMessage());
			batchTransInfoDao.update(batchInfo);
		}
		return reader;
	}
}
