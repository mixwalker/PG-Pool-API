package th.co.cdgs.pgpool.operation;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import th.co.cdgs.pgpool.employee.Employee;
import th.co.cdgs.pgpool.project.Project;

@Entity
@Table(name = "operation")
public class Operation {
	@Id
	@SequenceGenerator(name = "OpSequence", sequenceName = "Op_id_seq", allocationSize = 1, initialValue = 15)
	@GeneratedValue(generator = "OpSequence")
	@Column(name = "op_id")
	private Integer opId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PROJ_REF")
	private Project project;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "emp_no")
	private Employee employee;
	
	@OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "operation",
            cascade = CascadeType.ALL,
            orphanRemoval = true
            )
    private List<EmployeeOperation> employeeOperation;

	public Integer getOpId() {
		return opId;
	}

	public void setOpId(Integer opId) {
		this.opId = opId;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<EmployeeOperation> getEmployeeOperation() {
		return employeeOperation;
	}

	public void setEmployeeOperation(List<EmployeeOperation> employeeOperation) {
		this.employeeOperation = employeeOperation;
	}

	
	
	

}
