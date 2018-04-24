package com.poc.batch.SpringBootBatchPoc.model;

import java.util.Date;

public class BatchTransInfo {
	private Integer batchId;
	private String fileName;
	private String status;
	private Date startDate;
	private Date endDate;
	private String errorMessage;

	public BatchTransInfo(Integer batchId, String fileName, String status, Date startDate, Date endDate,
			String errorMessage) {
		super();
		this.batchId = batchId;
		this.fileName = fileName;
		this.status = status;
		this.startDate = startDate;
		this.endDate = endDate;
		this.errorMessage = errorMessage;
	}

	public Integer getBatchId() {
		return batchId;
	}

	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
