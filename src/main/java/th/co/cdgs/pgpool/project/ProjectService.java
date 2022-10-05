package th.co.cdgs.pgpool.project;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import th.co.cdgs.pgpool.operation.Operation;

@ApplicationScoped
public class ProjectService {
	@Inject
	EntityManager entityManager;

	public List<Project> get() {
		List<Project> list = entityManager.createQuery("from Project", Project.class).getResultList();
		for (int i = 0; i < list.size(); i++) {
			Project project = list.get(i);
			int projRef = project.getProjRef();
			List<Operation> findById = entityManager
					.createQuery("from Operation o where o.project.projRef = :Id", Operation.class)
					.setParameter("Id", projRef).getResultList();
			project.setAmountPerson(findById.size());
		}
		return list;
	}

	public Project getSingle(Integer id) {
		Project entity = entityManager.find(Project.class, id);
		if (entity == null) {
			throw new WebApplicationException("Project with id of " + id + " does not exist.", Status.NOT_FOUND);
		}
		List<Operation> findById = entityManager
				.createQuery("from Operation o where o.project.projRef = :Id", Operation.class)
				.setParameter("Id", id).getResultList();
		entity.setAmountPerson(findById.size());
		return entity;
	}

	public Response create(Project project) {
		if (project.getProjRef() != null) {
			project.setProjRef(null);
		}
		if(project.getStatus() == null) {
			project.setStatus(1);
		}

		List<Project> list = entityManager.createQuery("from Project p WHERE p.projCode = :code", Project.class)
				.setParameter("code", project.getProjCode()).getResultList();
		if (list.size() > 0) {
			throw new WebApplicationException("Project with Code was exist.");
		}
		entityManager.persist(project);
		return Response.status(Status.CREATED).entity(project).build();
	}

	public List<Project> getProjectByProjCode(String Id) {
		List<Project> list = entityManager.createQuery("from Project p where p.projCode = :Id ", Project.class)
				.setParameter("Id", Id).getResultList();
		return list;
	}

	public Response delete(Integer id) {
		Project entity = entityManager.getReference(Project.class, id);
		List<Operation> findById = entityManager
				.createQuery("from Operation o where o.project.projRef = :Id ", Operation.class).setParameter("Id", id)
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

	public Response update(Integer id, Project project) {
		Project entity = entityManager.find(Project.class, id);
		if (entity == null) {
			throw new WebApplicationException("Project with id of " + id + " does not exist.", Status.NOT_FOUND);
		}
		entity.setProjCode(project.getProjCode());
		entity.setProjName(project.getProjName());
		entity.setProjAbbrThai(project.getProjAbbrThai());
		entity.setProjAbbrEng(project.getProjAbbrEng());
		entity.setProjType(project.getProjType());
		entity.setProjStartDate(project.getProjStartDate());
		entity.setProjEndDate(project.getProjEndDate());
		entity.setCustomerCode(project.getCustomerCode());
		entity.setStatus(project.getStatus());
		return Response.ok(entity).build();
	}
}
