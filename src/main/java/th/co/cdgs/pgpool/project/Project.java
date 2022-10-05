package th.co.cdgs.pgpool.project;



import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Project")
public class Project {
	@Id
	@SequenceGenerator(name = "infoSequence", sequenceName = "info_id_seq", allocationSize = 1, initialValue = 15)
	@GeneratedValue(generator = "infoSequence")
	@Column(name = "PROJ_REF")
	private Integer projRef;
	
	@Column(length = 10, unique = false, name = "PROJ_CODE")
	private String projCode;
	
	@Column(length = 255, unique = false, name = "PROJ_NAME")
	private String projName;
	
	@Column(length = 1, unique = false, name = "PROJ_TYPE")
	private String projType;
	
	@Column(length = 50, unique = false, name = "PROJ_ABBR_THAI")
	private String projAbbrThai;
	
	@Column(length = 50, unique = false, name = "PROJ_ABBR_ENG")
	private String projAbbrEng;
	
	@Column(name = "PROJ_START_DATE")
	private Date projStartDate;
	
	@Column(name = "PROJ_END_DATE")
	private Date projEndDate;
	
	@Column(length = 10, unique = false, name = "customer_code")
	private String customerCode;
	
	@Column(length = 3, unique = false, name = "amount_persons")
	private Integer amountPerson;
	
	@Column(length = 1, unique = false, name = "status")
	private Integer status;

	public Project() {

	}

	public Project(Integer projRef) {
		this.projRef = projRef;
	}

	public Integer getProjRef() {
		return projRef;
	}

	public void setProjRef(Integer projRef) {
		this.projRef = projRef;
	}

	public String getProjCode() {
		return projCode;
	}

	public void setProjCode(String projCode) {
		this.projCode = projCode;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public String getProjType() {
		return projType;
	}

	public void setProjType(String projType) {
		this.projType = projType;
	}

	public String getProjAbbrThai() {
		return projAbbrThai;
	}

	public void setProjAbbrThai(String projAbbrThai) {
		this.projAbbrThai = projAbbrThai;
	}

	public String getProjAbbrEng() {
		return projAbbrEng;
	}

	public void setProjAbbrEng(String projAbbrEng) {
		this.projAbbrEng = projAbbrEng;
	}

	public Date getProjStartDate() {
		return projStartDate;
	}

	public void setProjStartDate(Date projStartDate) {
		this.projStartDate = projStartDate;
	}

	public Date getProjEndDate() {
		return projEndDate;
	}

	public void setProjEndDate(Date projEndDate) {
		this.projEndDate = projEndDate;
	}

	public Integer getAmountPerson() {
		return amountPerson;
	}

	public void setAmountPerson(Integer amountPerson) {
		this.amountPerson = amountPerson;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	

}
