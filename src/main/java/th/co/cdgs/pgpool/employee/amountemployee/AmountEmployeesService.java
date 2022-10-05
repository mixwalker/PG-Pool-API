package th.co.cdgs.pgpool.employee.amountemployee;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import th.co.cdgs.pgpool.employee.Employee;

@ApplicationScoped
public class AmountEmployeesService {
	@Inject
	EntityManager entityManager;
	
	public AmountEmployees get() {
		AmountEmployees entity = entityManager.find(AmountEmployees.class, 1);
		List<Employee> employeeList = entityManager.createQuery("from Employee ", Employee.class).getResultList();
		AmountEmployees amountEmployee = entity;
		amountEmployee.setAmountEmployees(employeeList.size());
		return entity;
	}

	
	
}
