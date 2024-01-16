package com.CompitApplication.Model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "report_model_table")
public class ReportModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long reportId;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties("videoReportid")
	private VideoModel rVideoId;
	
	
	private String reportMessage;
	
	
	private int priority;


	public ReportModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ReportModel(long reportId, VideoModel rVideoId, String reportMessage, int priority) {
		super();
		this.reportId = reportId;
		this.rVideoId = rVideoId;
		this.reportMessage = reportMessage;
		this.priority = priority;
	}


	@Override
	public String toString() {
		return "ReportModel [reportId=" + reportId + ", rVideoId=" + rVideoId + ", reportMessage=" + reportMessage
				+ ", priority=" + priority + "]";
	}


	public long getReportId() {
		return reportId;
	}


	public void setReportId(long reportId) {
		this.reportId = reportId;
	}


	public VideoModel getrVideoId() {
		return rVideoId;
	}


	public void setrVideoId(VideoModel rVideoId) {
		this.rVideoId = rVideoId;
	}


	public String getReportMessage() {
		return reportMessage;
	}


	public void setReportMessage(String reportMessage) {
		this.reportMessage = reportMessage;
	}


	public int getPriority() {
		return priority;
	}


	public void setPriority(int priority) {
		this.priority = priority;
	}
}
