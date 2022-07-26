package com.socgenrachit.skilltracker.Entity;





import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;






@Entity
public class FullStackEngineer {
	
	@Id
	@GeneratedValue
	private Long asid;
	
	@NotNull
	@Size(min = 5,max = 30)
	@Pattern(regexp = "^CTS[a-zA-Z0-9]{2,27}$")
	private String associateid;
	
	@NotNull
	@Size(min = 5,max = 30)
	private String name;
	
	@NotNull
	@Pattern(regexp = "^[0-9]{10}$")
	@Size(min = 10,max = 10)
	private Long mobile_no;
	
	@Email
	private String email;
	
	//@OneToMany(mappedBy = "fasid",cascade = CascadeType.ALL)
//	private List<Skills> skillStore=new ArrayList<>();
	
	@NotNull
	private LocalDateTime createdDateTime;
	
	@NotNull
	private LocalDateTime updatedDateTime;
	
	public FullStackEngineer(){
		
	}

	public Long getAsid() {
		return asid;
	}

	public void setAsid(Long asid) {
		this.asid = asid;
	}

	public String getAssociateid() {
		return associateid;
	}

	public void setAssociateid(String associateid) {
		this.associateid = associateid;
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

	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public LocalDateTime getUpdatedDateTime() {
		return updatedDateTime;
	}

	public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}

	public FullStackEngineer(Long asid,
			@NotNull @Size(min = 5, max = 30) @Pattern(regexp = "^CTS[a-zA-Z0-9]{2,27}$") String associateid,
			@NotNull @Size(min = 5, max = 30) String name,
			@NotNull @Pattern(regexp = "^[0-9]{10}$") @Size(min = 10, max = 10) Long mobile_no, @Email String email,
			@NotNull LocalDateTime createdDateTime, @NotNull LocalDateTime updatedDateTime) {
		super();
		this.asid = asid;
		this.associateid = associateid;
		this.name = name;
		this.mobile_no = mobile_no;
		this.email = email;
		this.createdDateTime = createdDateTime;
		this.updatedDateTime = updatedDateTime;
	}

	@Override
	public String toString() {
		return "FullStackEngineer [asid=" + asid + ", associateid=" + associateid + ", name=" + name + ", mobile_no="
				+ mobile_no + ", email=" + email + ", createdDateTime=" + createdDateTime + ", updatedDateTime="
				+ updatedDateTime + "]";
	}

	

	
	


	

}
