package com.poc.batch.SpringBootBatchPoc.model;

import java.util.Date;

public class PpmProjectInfo {
	private Integer id;
	private Integer batchId;
	private String status;
	private String errorMessage;
	private String projectType;
	private Integer projectNumber;
	private Integer projectTitle;
	private String projectDescription;
	private String projectCategory;
	private String platform;
	private String projectGate;
	private Date projectStartDate;
	private Date projectEndDate;

	public PpmProjectInfo(Integer batchId, String status, String errorMessage, String projectType,
			Integer projectNumber, Integer projectTitle, String projectDescription, String projectCategory,
			String platform, String projectGate, Date projectStartDate, Date projectEndDate) {
		super();
		this.batchId = batchId;
		this.status = status;
		this.errorMessage = errorMessage;
		this.projectType = projectType;
		this.projectNumber = projectNumber;
		this.projectTitle = projectTitle;
		this.projectDescription = projectDescription;
		this.projectCategory = projectCategory;
		this.platform = platform;
		this.projectGate = projectGate;
		this.projectStartDate = projectStartDate;
		this.projectEndDate = projectEndDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBatchId() {
		return batchId;
	}

	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public Integer getProjectNumber() {
		return projectNumber;
	}

	public void setProjectNumber(Integer projectNumber) {
		this.projectNumber = projectNumber;
	}

	public Integer getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(Integer projectTitle) {
		this.projectTitle = projectTitle;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public String getProjectCategory() {
		return projectCategory;
	}

	public void setProjectCategory(String projectCategory) {
		this.projectCategory = projectCategory;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getProjectGate() {
		return projectGate;
	}

	public void setProjectGate(String projectGate) {
		this.projectGate = projectGate;
	}

	public Date getProjectStartDate() {
		return projectStartDate;
	}

	public void setProjectStartDate(Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	public Date getProjectEndDate() {
		return projectEndDate;
	}

	public void setProjectEndDate(Date projectEndDate) {
		this.projectEndDate = projectEndDate;
	}

}
