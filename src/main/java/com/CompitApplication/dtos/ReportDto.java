package com.CompitApplication.dtos;

public class ReportDto {

	private Long reportId;

	private String reportReason;

	private Long comedyVideoReportId;

	private Long creativeVideoReportId;

	private Long reelsVideoReportId;

	private Long inspireVideoReportId;

	private Long singingVideoReportId;

	private Long musicVideoreportId;

	private Long danceVidoeReportId;

	public ReportDto() {
		super();

	}

	public ReportDto(Long reportId, String reportReason, Long comedyVideoReportId, Long creativeVideoReportId,
			Long reelsVideoReportId, Long inspireVideoReportId, Long singingVideoReportId, Long musicVideoreportId,
			Long danceVidoeReportId) {
		super();
		this.reportId = reportId;
		this.reportReason = reportReason;
		this.comedyVideoReportId = comedyVideoReportId;
		this.creativeVideoReportId = creativeVideoReportId;
		this.reelsVideoReportId = reelsVideoReportId;
		this.inspireVideoReportId = inspireVideoReportId;
		this.singingVideoReportId = singingVideoReportId;
		this.musicVideoreportId = musicVideoreportId;
		this.danceVidoeReportId = danceVidoeReportId;
	}

	@Override
	public String toString() {
		return "ReportDto [reportId=" + reportId + ", reportReason=" + reportReason + ", comedyVideoReportId="
				+ comedyVideoReportId + ", creativeVideoReportId=" + creativeVideoReportId + ", reelsVideoReportId="
				+ reelsVideoReportId + ", inspireVideoReportId=" + inspireVideoReportId + ", singingVideoReportId="
				+ singingVideoReportId + ", musicVideoreportId=" + musicVideoreportId + ", danceVidoeReportId="
				+ danceVidoeReportId + "]";
	}

	public Long getReportId() {
		return reportId;
	}

	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}

	public String getReportReason() {
		return reportReason;
	}

	public void setReportReason(String reportReason) {
		this.reportReason = reportReason;
	}

	public Long getComedyVideoReportId() {
		return comedyVideoReportId;
	}

	public void setComedyVideoReportId(Long comedyVideoReportId) {
		this.comedyVideoReportId = comedyVideoReportId;
	}

	public Long getCreativeVideoReportId() {
		return creativeVideoReportId;
	}

	public void setCreativeVideoReportId(Long creativeVideoReportId) {
		this.creativeVideoReportId = creativeVideoReportId;
	}

	public Long getReelsVideoReportId() {
		return reelsVideoReportId;
	}

	public void setReelsVideoReportId(Long reelsVideoReportId) {
		this.reelsVideoReportId = reelsVideoReportId;
	}

	public Long getInspireVideoReportId() {
		return inspireVideoReportId;
	}

	public void setInspireVideoReportId(Long inspireVideoReportId) {
		this.inspireVideoReportId = inspireVideoReportId;
	}

	public Long getSingingVideoReportId() {
		return singingVideoReportId;
	}

	public void setSingingVideoReportId(Long singingVideoReportId) {
		this.singingVideoReportId = singingVideoReportId;
	}

	public Long getMusicVideoreportId() {
		return musicVideoreportId;
	}

	public void setMusicVideoreportId(Long musicVideoreportId) {
		this.musicVideoreportId = musicVideoreportId;
	}

	public Long getDanceVidoeReportId() {
		return danceVidoeReportId;
	}

	public void setDanceVidoeReportId(Long danceVidoeReportId) {
		this.danceVidoeReportId = danceVidoeReportId;
	}

}
