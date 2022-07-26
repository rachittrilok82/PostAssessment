package com.socgenrachit.skilltracker.Service;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.socgenrachit.skilltracker.DTO.EmployeeDTO;
import com.socgenrachit.skilltracker.Entity.FullStackEngineer;
import com.socgenrachit.skilltracker.Entity.Skills;

@Repository
public class ConversionClass {
	
	public List<EmployeeDTO> convert(FullStackEngineer fullStackEngineer,List<Skills> skills,List<EmployeeDTO> employeeDTOs){
		EmployeeDTO employeeDTO=new EmployeeDTO();
		
		employeeDTO.setId(fullStackEngineer.getAssociateid());
		employeeDTO.setEmail(fullStackEngineer.getEmail());
		employeeDTO.setMobile_no(fullStackEngineer.getMobile_no());
		employeeDTO.setName(fullStackEngineer.getName());
		employeeDTO.setSkillsList(skills);
		employeeDTO.setLocalDateTime(fullStackEngineer.getCreatedDateTime());
		employeeDTO.setUpdatedDateTime(fullStackEngineer.getUpdatedDateTime());
		employeeDTOs.add(employeeDTO);
		
		
		return employeeDTOs;
	}
}
