package th.co.cdgs.pgpool.user;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@ApplicationScoped
public class UsersService {


	@Inject
	EntityManager entityManager;

    public Response login(String username,String password) {
        Users entity = entityManager.createQuery("FROM Users WHERE username = :username AND password = :password", Users.class)
                .setParameter("username", username).setParameter("password", password)
                .getSingleResult();    
        if(entity == null) {
        	throw new WebApplicationException("username or password incorrect",
                    Status.NOT_FOUND);
        }
        return Response.ok().entity(entity).build();
    }
}
