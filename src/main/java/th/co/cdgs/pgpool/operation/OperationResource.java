package th.co.cdgs.pgpool.operation;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("operation")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class OperationResource {
	@Inject
	OperationService operationService;

	@GET
	public List<Operation> get() {
		List<Operation> list = operationService.get();
		return list;
	}
	
	@GET
	@Path("findproject/{Id}")
	public List<Operation> getProject(Integer Id) {
		List<Operation> list = operationService.getProject(Id);
		return list;
	}
	
	@GET
	@Path("findemployee/{Id}")
	public List<Operation> getEmployee(String Id) {
		List<Operation> list = operationService.getEmployee(Id);
		return list;
	}
	
	@POST
	@Transactional
	public Response create(Operation operation) {
		Response entity = operationService.create(operation);
		return entity;
	}
	
	@DELETE
    @Transactional
    public Response deleteProject(@QueryParam("projRef") Integer projRef,@QueryParam("empNo") String empNo) {
		Response entity = operationService.deleteOperation(projRef,empNo);
        return entity;
    }
}
