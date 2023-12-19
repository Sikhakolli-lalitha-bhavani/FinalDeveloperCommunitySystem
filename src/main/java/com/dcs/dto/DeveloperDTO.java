package com.dcs.dto;


import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

//import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class DeveloperDTO extends UserDTO {
	@NotNull
	private String devName;
	private String devSkill;
	private LocalDate memberSince;
	// If no. of Upvote on Post is 5, then reputation value is 1
	// If no. of Upvote on Post is 10, then reputation value is 2 and so on
	private Integer reputation;
	// Block or Unblock
	private String status;
	
	public String getDevName() {
		return devName;
	}
	public void setDevName(String devName) {
		this.devName = devName;
	}
	public String getDevSkill() {
		return devSkill;
	}
	public void setDevSkill(String devSkill) {
		this.devSkill = devSkill;
	}
	public LocalDate getMemberSince() {
		return memberSince;
	}
	public void setMemberSince(LocalDate memberSince) {
		this.memberSince = memberSince;
	}
	public Integer getReputation() {
		return reputation;
	}
	public void setReputation(Integer reputation) {
		this.reputation = reputation;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "DeveloperDTO [devName=" + devName + ", devSkill=" + devSkill + ", memberSince=" + memberSince
				+ ", reputation=" + reputation + ", status=" + status + "]";
	}
	
	

}