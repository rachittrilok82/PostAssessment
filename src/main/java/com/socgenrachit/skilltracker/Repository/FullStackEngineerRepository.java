package com.socgenrachit.skilltracker.Repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socgenrachit.skilltracker.Entity.FullStackEngineer;
import com.socgenrachit.skilltracker.Entity.Skills;


@Repository
public interface FullStackEngineerRepository  extends JpaRepository<FullStackEngineer, Long> {
		
	
	FullStackEngineer findByName(String name);

	FullStackEngineer findByAssociateid(String associateid);
}
