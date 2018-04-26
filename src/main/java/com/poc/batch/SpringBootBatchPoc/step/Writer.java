package com.poc.batch.SpringBootBatchPoc.step;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.poc.batch.SpringBootBatchPoc.dao.WpdProjectDao;
import com.poc.batch.SpringBootBatchPoc.model.WpdProject;

public class Writer implements ItemWriter<WpdProject> {

	private final WpdProjectDao wpdProjectDao;

	public Writer(WpdProjectDao wpdProjectDao) {
		this.wpdProjectDao = wpdProjectDao;
	}

	@Override
	public void write(List<? extends WpdProject> projects) throws Exception {
		for (WpdProject project : projects) {
			/*if (person.getInsertFlag() == 1) {
				personDao.insert(person);
			} else {
				personDao.update(person);
			}*/
		}
	}

}
