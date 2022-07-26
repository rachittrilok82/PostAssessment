package com.socgenrachit.skilltracker.Entity;




import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Skills {
	
	@Id
	@GeneratedValue
	private Long skid;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private skill skillname;
	
	@NotNull
	@Min(value=0L)
	@Max(value=20L)
	private Long expertiselevel;
	
//	@ManyToOne
//	@JoinColumn(name="fasid")
	
	@NotNull
	private Long fasid;

	 public Skills(){
		
	}

	public Long getSkid() {
		return skid;
	}

	public void setSkid(Long skid) {
		this.skid = skid;
	}

	public skill getSkillname() {
		return skillname;
	}

	public void setSkillname(skill skillname) {
		this.skillname = skillname;
	}

	public Long getExpertiselevel() {
		return expertiselevel;
	}

	public void setExpertiselevel(Long expertiselevel) {
		this.expertiselevel = expertiselevel;
	}

	public Long getFasid() {
		return fasid;
	}

	public void setFasid(Long fasid) {
		this.fasid = fasid;
	}

	public Skills(skill skillname, Long expertiselevel, Long fasid) {
		super();
		
		this.skillname = skillname;
		this.expertiselevel = expertiselevel;
		this.fasid = fasid;
	}

	@Override
	public String toString() {
		return "Skills [skid=" + skid + ", skillname=" + skillname + ", expertiselevel=" + expertiselevel + ", fasid="
				+ fasid + "]";
	}

	
	 
	



}
