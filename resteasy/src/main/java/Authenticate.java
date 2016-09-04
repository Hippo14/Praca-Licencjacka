import dao.UserDAO;
import model.*;
import model.User;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by MSI on 2016-09-03.
 */
@Path("authenticate")
@Produces(MediaType.APPLICATION_JSON)
public class Authenticate {

    @EJB
    UserDAO mockUserTable;

    @QueryParam("username")
    String username;

    @Path("{username}")
    @GET
    public Response getTokenByUser() {
        if (username == null)
            return Response.ok("username is null").build();

        User user = mockUserTable.getByName(username);

        if (user.getName() == username) {
            int random = (int) Math.random();
            return Response.ok(random).build();
        }
        else
            return Response.ok("username not found!").build();
    }

}
