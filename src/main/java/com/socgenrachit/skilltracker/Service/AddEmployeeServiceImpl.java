package com.socgenrachit.skilltracker.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socgenrachit.skilltracker.DTO.EmployeeDTO;
import com.socgenrachit.skilltracker.DTO.UpdateEmployeeDTO;
import com.socgenrachit.skilltracker.Entity.FullStackEngineer;
import com.socgenrachit.skilltracker.Entity.Skills;
import com.socgenrachit.skilltracker.Entity.skill;
import com.socgenrachit.skilltracker.Repository.FullStackEngineerRepository;
import com.socgenrachit.skilltracker.Repository.SkillsRepository;

@Service
public class AddEmployeeServiceImpl{
	
	@Autowired
	FullStackEngineerRepository fm;
	
	@Autowired
	SkillsRepository smRepository;
	
	@Autowired
	ConversionClass conversionClass;
	
	public String addEmployee(EmployeeDTO employeeDTO) {
		
		System.out.println(employeeDTO);
		FullStackEngineer fullStackEngineer=new FullStackEngineer();
		fullStackEngineer.setAssociateid(employeeDTO.getId());
		fullStackEngineer.setEmail(employeeDTO.getEmail());
		fullStackEngineer.setMobile_no(employeeDTO.getMobile_no());
		fullStackEngineer.setName(employeeDTO.getName());
		fullStackEngineer.setCreatedDateTime(LocalDateTime.now());
		fullStackEngineer.setUpdatedDateTime(LocalDateTime.now());
		
		
		fm.save(fullStackEngineer);
		for(Skills skills:employeeDTO.getSkillsList()) {
			
			Skills sk=new Skills();
			sk.setFasid(fullStackEngineer.getAsid());
			sk.setSkillname(skills.getSkillname());
			sk.setExpertiselevel(skills.getExpertiselevel());
			
			smRepository.save(sk);
			
		}
		
		
//		FullStackEngineer f1=new FullStackEngineer();
//		
//		f1.setAsid(employeeDTO.getId());
//		f1.setEmail(employeeDTO.getEmail());
//		f1.setMobile_no(employeeDTO.getMobile_no());
//		f1.setName(employeeDTO.getName());
//		
//		
//		f1.setSkillStore(employeeDTO.getSkillsList());
//		List<Skills> skillStore = f1.getSkillStore();
//		for(int i=0; i<skillStore.size();i++) {
//			skillStore.get(i).setFasid(f1);
//		}
//		f1.setSkillStore(skillStore);
//		fm.save(f1);
		
		System.out.println();
		
		
		return "User added succesfully to database";
		
			
	}
	
	public String updateEmployee(UpdateEmployeeDTO updateEmployeeDTO, String userid) {
		
//		List<Skills> skillsListFetched = smRepository.findAllByFasid(userid);
		FullStackEngineer fullstackengineer= fm.findByAssociateid(userid);
		
		Period period = Period.between(fullstackengineer.getUpdatedDateTime().toLocalDate(), LocalDateTime.now().toLocalDate());
		if(period.getDays()<=10) {
			
			List<Skills> skillsListToUpdate = updateEmployeeDTO.getSkillsList();
			
			for(int i=0;i<skillsListToUpdate.size();i++) {
				
				Skills sk1=skillsListToUpdate.get(i);
				
				skill skillname = sk1.getSkillname();
				//FullStackEngineer fullstackengineer = fm.findByAssociateid(userid);
				Skills sk2=smRepository.findBySkillnameAndFasid(skillname,fullstackengineer.getAsid());
			
				
				sk2.setExpertiselevel(sk1.getExpertiselevel());
				
				smRepository.save(sk2);
			
				
			}
			
			fullstackengineer.setUpdatedDateTime(LocalDateTime.now());
			fm.save(fullstackengineer);
		
			return "Update Successfull";
			
		}
		else {
			return "Skills cannot be Updated";
		}
		
	}
	
	public List<EmployeeDTO> searchEmployee(String criteria, String criteriaValue) {
		
		List<EmployeeDTO> sendEmployeeDetailsDto=new ArrayList<>();
		
		
		FullStackEngineer fullStackEngineer;
		List<Skills> skillsList;
		if(criteria.equalsIgnoreCase("Name")) {
			fullStackEngineer=fm.findByName(criteriaValue);
			skillsList=smRepository.findAllByFasid(fullStackEngineer.getAsid());
			
			sendEmployeeDetailsDto=conversionClass.convert(fullStackEngineer, skillsList, sendEmployeeDetailsDto);
			
		}
		else if(criteria.equalsIgnoreCase("AssociateId")) {
			fullStackEngineer=fm.findByAssociateid(criteriaValue);
			skillsList=smRepository.findAllByFasid(fullStackEngineer.getAsid());
			sendEmployeeDetailsDto=conversionClass.convert(fullStackEngineer, skillsList, sendEmployeeDetailsDto);
	
		}
		else if(criteria.equalsIgnoreCase("Skill")) {
			skillsList=smRepository.findAllBySkillname(skill.valueOf(criteriaValue));
			List<FullStackEngineer> engineers=new ArrayList<>();
			
			for(Skills skills:skillsList) {
				FullStackEngineer fEngineer=fm.findById(skills.getFasid()).get();
				
				List<Skills> passList=new ArrayList<>();
				passList.add(skills);
				sendEmployeeDetailsDto=conversionClass.convert(fEngineer, passList, sendEmployeeDetailsDto);
				
			}
		}
		else {
			return sendEmployeeDetailsDto;
		}
		
		
		
		
		return sendEmployeeDetailsDto;
	}
	
}
