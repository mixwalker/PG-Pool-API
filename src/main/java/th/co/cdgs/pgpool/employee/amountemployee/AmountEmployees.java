package th.co.cdgs.pgpool.employee.amountemployee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AMOUNT_EMPLOYEES")
public class AmountEmployees {
		@Id
		@Column(unique = true, name = "AMOUNT_ID")
		private Integer amountId;
		@Column(unique = false, name = "AMOUNT_EMPLOYEES")
		private Integer amountEmployees;
		
		public Integer getAmountId() {
			return amountId;
		}
		public void setAmountId(Integer amountId) {
			this.amountId = amountId;
		}
		public Integer getAmountEmployees() {
			return amountEmployees;
		}
		public void setAmountEmployees(Integer amountEmployees) {
			this.amountEmployees = amountEmployees;
		}
		
		
}
