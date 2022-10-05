package th.co.cdgs.pgpool.user;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("users")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class UsersResource {
	@Inject
	UsersService usersService;

	@GET
    @Path("auth")
	public Response login(@QueryParam("username") String username, @QueryParam("password") String password) {
		Response list = usersService.login(username,password);
		return list;
	}
	
	
}
