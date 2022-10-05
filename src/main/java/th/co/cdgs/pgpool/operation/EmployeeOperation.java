package th.co.cdgs.pgpool.operation;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "employeeoperation")
public class EmployeeOperation {
	@Id
	@SequenceGenerator(name = "empOpSequence", sequenceName = "empOp_id_seq", allocationSize = 1, initialValue = 15)
	@GeneratedValue(generator = "empOpSequence")
	@Column(name = "empop_id")
	private Integer empOpId;
	@Column(name = "empop_startdate")
	private Date startDate;
	@Column(name = "empop_enddate")
	private Date endDate;
	@Column(length = 5, name = "duration")
	private float empDuration;
	@Column(length = 5, name = "working")
	private float empWorking;
	@Column(length = 5, name = "assigned")
	private float empAssigned;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "op_id")
	private Operation operation;
	
	public Integer getEmpOpId() {
		return empOpId;
	}
	public void setEmpOpId(Integer empOpId) {
		this.empOpId = empOpId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public float getEmpDuration() {
		return empDuration;
	}

	public void setEmpDuration(float empDuration) {
		this.empDuration = empDuration;
	}

	public float getEmpWorking() {
		return empWorking;
	}

	public void setEmpWorking(float empWorking) {
		this.empWorking = empWorking;
	}

	public float getEmpAssigned() {
		return empAssigned;
	}

	public void setEmpAssigned(float empAssigned) {
		this.empAssigned = empAssigned;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}
	
//	public Operation getOperation() {
//		return operation;
//	}
//	
	
}


