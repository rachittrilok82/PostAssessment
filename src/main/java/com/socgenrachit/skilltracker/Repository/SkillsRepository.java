package com.socgenrachit.skilltracker.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socgenrachit.skilltracker.Entity.FullStackEngineer;
import com.socgenrachit.skilltracker.Entity.Skills;
import com.socgenrachit.skilltracker.Entity.skill;

@Repository
public interface SkillsRepository extends JpaRepository<Skills, Long>{
	
	List<Skills> findAllByFasid(Long fasid);
	
	Skills findBySkillnameAndFasid(skill skillname,Long fasid);
	
	List<Skills> findAllBySkillname(skill skillname);
}
