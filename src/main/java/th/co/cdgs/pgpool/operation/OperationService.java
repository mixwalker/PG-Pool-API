package th.co.cdgs.pgpool.operation;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


@ApplicationScoped
public class OperationService {
	@Inject
	EntityManager entityManager;

	public List<Operation> get() {
		List<Operation> list = entityManager.createQuery("from Operation o", Operation.class).getResultList();
		return list;
	}

	public List<Operation> getProject(Integer Id) {
		List<Operation> list = entityManager
				.createQuery("from Operation op where op.project.projRef = :Id ", Operation.class)
				.setParameter("Id", Id).getResultList();
		return list;
	}

	public List<Operation> getEmployee(String Id) {
		List<Operation> list = entityManager
				.createQuery("from Operation op where op.employee.empNo = :Id ", Operation.class).setParameter("Id", Id)
				.getResultList();
		return list;
	}

	public Response create(Operation operation) {
		if (operation.getOpId() != null) {
			operation.setOpId(null);
		}
		entityManager.persist(operation);
		return Response.status(Status.CREATED).entity(operation).build();
	}

	public Response deleteOperation(Integer id, String empNo) {
		List<Operation> findById = entityManager
				.createQuery("from Operation o where o.project.projRef = :Id and o.employee.empNo = :empNo ",
						Operation.class)
				.setParameter("Id", id).setParameter("empNo", empNo).getResultList();
		if (!findById.isEmpty()) {
			for (Operation Op : findById) {
				entityManager.remove(Op);
			}
		}
		return Response.ok().build();
	}
}
