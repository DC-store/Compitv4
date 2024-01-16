package com.CompitApplication.dtos;

public class SupprtDto {

	private Long supprtIds;

	private Long supportingIds;

	private Long supporterIds;

	public Long getSupprtIds() {
		return supprtIds;
	}

	public void setSupprtIds(Long supprtIds) {
		this.supprtIds = supprtIds;
	}

	public Long getSupportingIds() {
		return supportingIds;
	}

	public void setSupportingIds(Long supportingIds) {
		this.supportingIds = supportingIds;
	}

	public Long getSupporterIds() {
		return supporterIds;
	}

	public void setSupporterIds(Long supporterIds) {
		this.supporterIds = supporterIds;
	}

	@Override
	public String toString() {
		return "SupprtDto [supprtIds=" + supprtIds + ", supportingIds=" + supportingIds + ", supporterIds="
				+ supporterIds + "]";
	}

	public SupprtDto(Long supprtIds, Long supportingIds, Long supporterIds) {
		super();
		this.supprtIds = supprtIds;
		this.supportingIds = supportingIds;
		this.supporterIds = supporterIds;
	}

	public SupprtDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
