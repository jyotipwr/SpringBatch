package com.poc.batch.SpringBootBatchPoc.dao;

import com.poc.batch.SpringBootBatchPoc.model.BatchTransInfo;

public interface BatchTransInfoDao {
	public BatchTransInfo insert(BatchTransInfo batchInfo);
	public void update(BatchTransInfo batchInfo);
}
