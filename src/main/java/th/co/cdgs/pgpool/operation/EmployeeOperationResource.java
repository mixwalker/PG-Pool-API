package th.co.cdgs.pgpool.operation;

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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import th.co.cdgs.pgpool.employee.Employee;

@Path("employee_operation")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class EmployeeOperationResource {
	@Inject
	EmployeeOperationService employeeOperationService;

	@GET
	public List<EmployeeOperation> get() {
		List<EmployeeOperation> list = employeeOperationService.get();
		return list;
	}
	
	@POST
	@Transactional
	public Response create(EmployeeOperation empOp) {
		Response entity = employeeOperationService.create(empOp);
		return entity;
	}
	
	@PUT
	@Path("{id}")
	@Transactional
	public Response update(Integer id,EmployeeOperation empOp) {
		Response entity = employeeOperationService.update(id, empOp);
		return entity;
	}
	
	@DELETE
	@Path("{id}")
    @Transactional
    public Response deleteEmpOp(Integer id) {
		Response entity = employeeOperationService.delete(id);
        return entity;
    }
}
