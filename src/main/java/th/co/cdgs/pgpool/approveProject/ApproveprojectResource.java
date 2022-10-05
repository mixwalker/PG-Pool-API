package th.co.cdgs.pgpool.approveProject;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("approveproject")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class ApproveprojectResource {

	@Inject
	ApproveprojectService ApproveprojectService;

	@GET
	public List<Approveproject> get() {
		List<Approveproject> list = ApproveprojectService.get();
		return list;
	}
	
	@GET
	@Path("queryproject")
	public List<Approveproject> getProject(@QueryParam("month") String month,@QueryParam("year") String year) {
		List<Approveproject> list = ApproveprojectService.getProjectByQuery(month,year);
		return list;
	}
	
	@POST
	@Transactional
	public Response create(Approveproject ap) {
		Response entity = ApproveprojectService.create(ap);
		return entity;
	}

	@PUT
	@Path("{id}")
	@Transactional
	public Response update(Integer id,Approveproject ap) {
		Response entity = ApproveprojectService.update(id, ap);
		return entity;
	}
}
