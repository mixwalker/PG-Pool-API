package th.co.cdgs.pgpool.approveProject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "approve_project")
public class Approveproject {

	@Id
	@SequenceGenerator(name = "approveSequence", sequenceName = "approve_id_seq", allocationSize = 1, initialValue = 15)
	@GeneratedValue(generator = "approveSequence")
	@Column(name = "approve_id")
	private Integer approveId;
	@Column(length = 50, unique = false, name = "approve_projRef")
	private String approveProjRef;
	@Column(length = 50, unique = false, name = "approve_month")
	private String approveMonth;
	@Column(length = 4, unique = false, name = "approve_year")
	private String approveYears;
	@Column(length = 1, unique = false, name = "approve_status")
	private Boolean approveStatus;
	
	public Integer getApproveId() {
		return approveId;
	}
	public void setApproveId(Integer approveId) {
		this.approveId = approveId;
	}
	public String getApproveProjRef() {
		return approveProjRef;
	}
	public void setApproveProjRef(String approveProjRef) {
		this.approveProjRef = approveProjRef;
	}
	public String getApproveMonth() {
		return approveMonth;
	}
	public void setApproveMonth(String approveMonth) {
		this.approveMonth = approveMonth;
	}
	public String getApproveYears() {
		return approveYears;
	}
	public void setApproveYears(String approveYears) {
		this.approveYears = approveYears;
	}
	public Boolean getApproveStatus() {
		return approveStatus;
	}
	public void setApproveStatus(Boolean approveStatus) {
		this.approveStatus = approveStatus;
	}
	
	
}
