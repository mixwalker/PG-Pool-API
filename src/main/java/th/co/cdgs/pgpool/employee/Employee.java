package th.co.cdgs.pgpool.employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {
	@Id
	@Column(unique = true, name = "EMP_NO")
	private String empNo;
	@Column(length = 50, unique = false, name = "FIRST_NAME")
	private String firstName;
	@Column(length = 50, unique = false, name = "LAST_NAME")
	private String lastName;
	@Column(length = 50, unique = false, name = "POSITION")
	private String position;
	@Column(unique = false, name = "DEPARTMENT")
	private String department;
	@Column(unique = false, name = "EMAIL")
	private String email;
	@Column(unique = false, name = "progress")
	private String progress;

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}
	
	
	

}
