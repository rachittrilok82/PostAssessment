package com.socgenrachit.skilltracker.Controller;




import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.socgenrachit.skilltracker.DTO.EmployeeDTO;
import com.socgenrachit.skilltracker.DTO.UpdateEmployeeDTO;
import com.socgenrachit.skilltracker.Entity.FullStackEngineer;
import com.socgenrachit.skilltracker.Entity.Skills;
import com.socgenrachit.skilltracker.Repository.FullStackEngineerRepository;
import com.socgenrachit.skilltracker.Service.AddEmployeeServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/skill-tracker/api/v1/engineer")
public class Controller1 {
	
	@Autowired
	AddEmployeeServiceImpl es;
		
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		
		
//		FullStackEngineer f1=new FullStackEngineer(10001L, "Rachit", 12365L, "rachit@gmail.com");
//		fm.save(f1);
		return String.format("Hello %s!", name);
	}
	
	@PostMapping(value = "/add-profile", headers = "Accept=application/json"  )
	public ResponseEntity<?> createuser(@RequestBody EmployeeDTO employeeDTO) {
		
		try {
			return new ResponseEntity<String>(es.addEmployee(employeeDTO),HttpStatus.CREATED);
			
		}
		catch (Exception e) {
			return new ResponseEntity<Exception>(e,HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping(value="/update-profile/{userid}")
	public ResponseEntity<?> updateEmpl(@PathVariable("userid") String userid,@RequestBody UpdateEmployeeDTO updateEmployeeDTO) {
		
		try {
			return new ResponseEntity<String>(es.updateEmployee(updateEmployeeDTO,userid),HttpStatus.OK);
			
		}
		catch(Exception e) {
			return new ResponseEntity<Exception>(e,HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	@GetMapping(value="/admin/{criteria}/{criteriaValue}")
	public ResponseEntity<?> searchEmpl(@PathVariable("criteria") String criteria,@PathVariable("criteriaValue") String criteriaValue){
		try {
			return new ResponseEntity<List<EmployeeDTO>>(es.searchEmployee(criteria,criteriaValue),HttpStatus.OK);
			
		}
		catch(Exception e) {
			return new ResponseEntity<Exception>(e,HttpStatus.BAD_REQUEST);
		}
	}
	
	
	

}

