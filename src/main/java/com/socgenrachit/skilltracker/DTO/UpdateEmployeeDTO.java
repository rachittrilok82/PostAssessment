package com.socgenrachit.skilltracker.DTO;

import java.util.List;

import com.socgenrachit.skilltracker.Entity.Skills;

public class UpdateEmployeeDTO {
	
	
	private List<Skills> skillsList;
	
	public UpdateEmployeeDTO() {
		
	}

	public List<Skills> getSkillsList() {
		return skillsList;
	}

	public void setSkillsList(List<Skills> skillsList) {
		this.skillsList = skillsList;
	}

	public UpdateEmployeeDTO(List<Skills> skillsList) {
		super();
		this.skillsList = skillsList;
	}

	@Override
	public String toString() {
		return "UpdateEmployeeDTO [skillsList=" + skillsList + "]";
	}

	
	
	
	

}
