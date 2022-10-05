package th.co.cdgs.pgpool.operation;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@ApplicationScoped
public class EmployeeOperationService {
	
	@Inject
	EntityManager entityManager;

	public List<EmployeeOperation> get() {
		List<EmployeeOperation> list = entityManager.createQuery("from EmployeeOperation e", EmployeeOperation.class).getResultList();
		return list;
	}
	
	public Response create(EmployeeOperation empOp) {
		if (empOp.getEmpOpId() != null) {
			empOp.setEmpOpId(null);
		}
		entityManager.persist(empOp);
		return Response.status(Status.CREATED).entity(empOp).build();
	}
	
	public Response update(int empOpId, EmployeeOperation empOp) {
		EmployeeOperation entity = entityManager.find(EmployeeOperation.class, empOpId);
		if (entity == null) {
			throw new WebApplicationException("Employee with id of " + empOpId + " does not exist.", Status.NOT_FOUND);
		}
		entity.setStartDate(empOp.getStartDate());
		entity.setEndDate(empOp.getEndDate());
		entity.setEmpWorking(empOp.getEmpWorking());
		entity.setEmpAssigned(empOp.getEmpAssigned());
		entity.setEmpDuration(empOp.getEmpDuration());
		
		return Response.ok(entity).build();
	}
	
	public Response delete(Integer id) {
		EmployeeOperation entity = entityManager.getReference(EmployeeOperation.class, id);
		if (entity == null) {
			throw new WebApplicationException("employeeOperation with id of " + id + " does not exist.", Status.NOT_FOUND);
		}
		entity.setOperation(null);
		entityManager.remove(entity);
		return Response.ok().build();
    }
}
