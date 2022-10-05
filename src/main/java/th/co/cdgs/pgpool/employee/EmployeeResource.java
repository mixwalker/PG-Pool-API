package th.co.cdgs.pgpool.employee;

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

@Path("employee")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class EmployeeResource {

	@Inject
	EmployeeService employeeService;

	@GET
	public List<Employee> get() {
		List<Employee> list = employeeService.get();
		return list;
	}
	
	@GET
	@Path("{id}")
	public Employee getSingle(String id) {
		Employee entity = employeeService.getSingle(id);
		return entity;
	}

	@POST
	@Transactional
	public Response create(Employee employee) {
		Response entity = employeeService.create(employee);
		return entity;
	}
	
	@DELETE
    @Path("{id}")
    @Transactional
    public Response delete(String id) {
		Response entity = employeeService.delete(id);
        return entity;
    }
	
	@PUT
	@Path("{id}")
	@Transactional
	public Response update(String id,Employee employee) {
		Response entity = employeeService.update(id, employee);
		return entity;
	}
	
	
	
}
