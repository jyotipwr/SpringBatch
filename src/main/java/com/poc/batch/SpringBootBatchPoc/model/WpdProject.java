package com.poc.batch.SpringBootBatchPoc.model;

import java.util.Date;

public class WpdProject {
	private Integer projNbr;
	private String description;
	private String typeCode;
	private String prodGroup;
	private String prodCode;
	private String nextScheduledItem;
	private String statusCode;
	private Date goActualDate;
	private Date otsPlanDate;
	private Date createDate;
	private Date lastUpdtDate;

	public WpdProject(Integer projNbr, String description, String typeCode, String prodGroup, String prodCode,
			String nextScheduledItem, String statusCode, Date goActualDate, Date otsPlanDate, Date createDate,
			Date lastUpdtDate) {
		super();
		this.projNbr = projNbr;
		this.description = description;
		this.typeCode = typeCode;
		this.prodGroup = prodGroup;
		this.prodCode = prodCode;
		this.nextScheduledItem = nextScheduledItem;
		this.statusCode = statusCode;
		this.goActualDate = goActualDate;
		this.otsPlanDate = otsPlanDate;
		this.createDate = createDate;
		this.lastUpdtDate = lastUpdtDate;
	}

	public Integer getProjNbr() {
		return projNbr;
	}

	public void setProjNbr(Integer projNbr) {
		this.projNbr = projNbr;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getProdGroup() {
		return prodGroup;
	}

	public void setProdGroup(String prodGroup) {
		this.prodGroup = prodGroup;
	}

	public String getProdCode() {
		return prodCode;
	}

	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}

	public String getNextScheduledItem() {
		return nextScheduledItem;
	}

	public void setNextScheduledItem(String nextScheduledItem) {
		this.nextScheduledItem = nextScheduledItem;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public Date getGoActualDate() {
		return goActualDate;
	}

	public void setGoActualDate(Date goActualDate) {
		this.goActualDate = goActualDate;
	}

	public Date getOtsPlanDate() {
		return otsPlanDate;
	}

	public void setOtsPlanDate(Date otsPlanDate) {
		this.otsPlanDate = otsPlanDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastUpdtDate() {
		return lastUpdtDate;
	}

	public void setLastUpdtDate(Date lastUpdtDate) {
		this.lastUpdtDate = lastUpdtDate;
	}

}
