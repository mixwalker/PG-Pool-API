package th.co.cdgs.pgpool.employee.amountemployee;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("amount_employees")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class AmountEmployeesResource {

	@Inject
	AmountEmployeesService amountService;

	@GET
	public AmountEmployees get() {
		AmountEmployees list = amountService.get();
		return list;
	}
}
