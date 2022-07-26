package com.socgenrachit.skilltracker.DTO;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.socgenrachit.skilltracker.Entity.Skills;

public class EmployeeDTO {
	
	
	private String id;
	
	private String name;
	
	private Long mobile_no;
	
	private String email;
	
	private List<Skills> skillsList;
	
	private LocalDateTime localDateTime;
	
	private LocalDateTime updatedDateTime;
	
	public EmployeeDTO() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(Long mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Skills> getSkillsList() {
		return skillsList;
	}

	public void setSkillsList(List<Skills> skillsList) {
		this.skillsList = skillsList;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public LocalDateTime getUpdatedDateTime() {
		return updatedDateTime;
	}

	public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}

	public EmployeeDTO(String id, String name, Long mobile_no, String email, List<Skills> skillsList,
			LocalDateTime localDateTime, LocalDateTime updatedDateTime) {
		super();
		this.id = id;
		this.name = name;
		this.mobile_no = mobile_no;
		this.email = email;
		this.skillsList = skillsList;
		this.localDateTime = localDateTime;
		this.updatedDateTime = updatedDateTime;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [id=" + id + ", name=" + name + ", mobile_no=" + mobile_no + ", email=" + email
				+ ", skillsList=" + skillsList + ", localDateTime=" + localDateTime + ", updatedDateTime="
				+ updatedDateTime + "]";
	}


}
