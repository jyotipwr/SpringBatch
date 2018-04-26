package com.poc.batch.SpringBootBatchPoc.model;

public class ProjectData {
	private String projectNumber;
	private String projectDescription;
	private String projectType;
	private String projectCategory;
	private String platform;
	private String projectGate;
	private String status;
	private String projectStartDate;
	private String projectEndDate;
	private String projectCreationDate;
	private String projectModificationDate;
	private String newProject;
	private String batchId;

	public ProjectData(String projectNumber, String projectDescription, String projectType, String projectCategory,
			String platform, String projectGate, String status, String projectStartDate, String projectEndDate,
			String projectCreationDate, String projectModificationDate, String newProject, String batchId) {
		super();
		this.projectNumber = projectNumber;
		this.projectDescription = projectDescription;
		this.projectType = projectType;
		this.projectCategory = projectCategory;
		this.platform = platform;
		this.projectGate = projectGate;
		this.status = status;
		this.projectStartDate = projectStartDate;
		this.projectEndDate = projectEndDate;
		this.projectCreationDate = projectCreationDate;
		this.projectModificationDate = projectModificationDate;
		this.newProject = newProject;
		this.batchId = batchId;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getProjectNumber() {
		return projectNumber;
	}

	public void setProjectNumber(String projectNumber) {
		this.projectNumber = projectNumber;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProjectStartDate() {
		return projectStartDate;
	}

	public void setProjectStartDate(String projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	public String getProjectEndDate() {
		return projectEndDate;
	}

	public void setProjectEndDate(String projectEndDate) {
		this.projectEndDate = projectEndDate;
	}

	public String getProjectCreationDate() {
		return projectCreationDate;
	}

	public void setProjectCreationDate(String projectCreationDate) {
		this.projectCreationDate = projectCreationDate;
	}

	public String getProjectModificationDate() {
		return projectModificationDate;
	}

	public void setProjectModificationDate(String projectModificationDate) {
		this.projectModificationDate = projectModificationDate;
	}

	public String getNewProject() {
		return newProject;
	}

	public void setNewProject(String newProject) {
		this.newProject = newProject;
	}

}
