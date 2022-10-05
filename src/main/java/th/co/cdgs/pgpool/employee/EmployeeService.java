package th.co.cdgs.pgpool.employee;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import th.co.cdgs.pgpool.operation.Operation;

@ApplicationScoped
public class EmployeeService {

	@Inject
	EntityManager entityManager;

	public List<Employee> get() {
		List<Employee> list = entityManager.createQuery("from Employee e", Employee.class).getResultList();
		return list;
	}
	
	public Employee getSingle(String id) {
		Employee entity = entityManager.find(Employee.class, id);

		if (entity == null) {
			throw new WebApplicationException("Employee with id of " + id + " does not exist.", Status.NOT_FOUND);
		}
		return entity;
	}

	public Response create(Employee employee) {
		if (employee.getDepartment() == null) {
			employee.setDepartment("ADD");
		}
		entityManager.persist(employee);
		return Response.status(Status.CREATED).entity(employee).build();
	}

	public Response delete(String id) {
		Employee entity = entityManager.getReference(Employee.class, id);
		List<Operation> findById = entityManager
				.createQuery("from Operation o where o.employee.empNo = :Id ", Operation.class).setParameter("Id", id)
				.getResultList();
		if (!findById.isEmpty()) {
			for (Operation Op : findById) {
				entityManager.remove(Op);
			}
		}

		if (entity == null) {
			throw new WebApplicationException("project with id of " + id + " does not exist.", Status.NOT_FOUND);
		}
		entityManager.remove(entity);
		return Response.ok().build();
	}

	public Response update(String empNo, Employee employee) {
		Employee entity = entityManager.find(Employee.class, empNo);
		if (entity == null) {
			throw new WebApplicationException("Employee with id of " + empNo + " does not exist.", Status.NOT_FOUND);
		}
		entity.setFirstName(employee.getFirstName());
		entity.setLastName(employee.getLastName());
		entity.setDepartment(employee.getDepartment());
		entity.setPosition(employee.getPosition());
		entity.setEmail(employee.getEmail());
		entity.setProgress(employee.getProgress());
		
		return Response.ok(entity).build();
	}

}
