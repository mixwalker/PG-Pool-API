package th.co.cdgs.pgpool.project;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("project")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class ProjectResource {

	@Inject
	ProjectService projectService;

	@GET
	public List<Project> get() {
		List<Project> list = projectService.get();
		return list;
	}

	@GET
	@Path("{id}")
	public Project getSingle(Integer id) {
		Project entity = projectService.getSingle(id);
		return entity;
	}

	@GET
	@Path("findprojectbyprojcode/{id}")
	public List<Project> getProjectByProjCode(String id) {
		List<Project> list = projectService.getProjectByProjCode(id);
		return list;
	}

	@POST
	@Transactional
	public Response create(Project project) {
		Response entity = projectService.create(project);
		return entity;
	}

	@DELETE
	@Path("{id}")
	@Transactional
	public Response delete(Integer id) {
		Response entity = projectService.delete(id);
		return entity;
	}

	@PUT
	@Path("{id}")
	@Transactional
	public Response update(Integer id,Project project) {
		Response entity = projectService.update(id, project);
		return entity;
	}

}
