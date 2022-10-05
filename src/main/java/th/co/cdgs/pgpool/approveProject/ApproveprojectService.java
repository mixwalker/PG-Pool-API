package th.co.cdgs.pgpool.approveProject;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@ApplicationScoped
public class ApproveprojectService {

	@Inject
	EntityManager entityManager;

	public List<Approveproject> get() {
		List<Approveproject> list = entityManager.createQuery("from Approveproject a", Approveproject.class).getResultList();
		return list;
	}
	
	public List<Approveproject> getProjectByQuery(String month,String year) {
		List<Approveproject> list = entityManager
				.createQuery("from Approveproject ap where ap.approveMonth = :month and ap.approveYears = :year", Approveproject.class)
				.setParameter("month", month).setParameter("year", year).getResultList();
		return list;
	}
	
	public Response create(Approveproject ap) {
		if (ap.getApproveId() != null) {
			ap.setApproveId(null);
		}
		entityManager.persist(ap);
		return Response.status(Status.CREATED).entity(ap).build();
	}
	
	public Response update(Integer id, Approveproject ap) {
		Approveproject entity = entityManager.find(Approveproject.class, id);
		if (entity == null) {
			throw new WebApplicationException("Approveproject with id of " + id + " does not exist.", Status.NOT_FOUND);
		}
		entity.setApproveProjRef(ap.getApproveProjRef());
		entity.setApproveMonth(ap.getApproveMonth());
		entity.setApproveYears(ap.getApproveYears());
		entity.setApproveStatus(ap.getApproveStatus());
		return Response.ok(entity).build();
	}

	
}
