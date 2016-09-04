import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import dao.UserDAO;
import model.User;

/**
 * Created by KMacioszek on 2016-07-11.
 */
@Path("users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @EJB
    UserDAO mockUserTable;

    @Path("")
    @GET
    public Response getUsersXML() {
        List<User> users = mockUserTable.getAll();
        if (users == null)
            return Response.serverError().build();

        GenericEntity<List<model.User>> ge = new GenericEntity<List<User>>(users){};
        return Response.ok(ge).build();
    }

    @Path("{id}")
    @GET
    public Response getUserXMLById(@PathParam("id") Integer id) {
        return Response.ok(mockUserTable.getById(id)).build();
    }

    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public Response saveUser(User user) {
        mockUserTable.save(user);
        return Response.ok("<status>success</status>").build();
    }

    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    @PUT
    public Response updateUser(User user) {
        mockUserTable.update(user);
        return Response.ok("<status>success</status>").build();
    }

    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @DELETE
    public Response deleteUser(@PathParam("id")Integer id) {
        mockUserTable.delete(id);
        return Response.ok("<status>success</status>").build();
    }

}
