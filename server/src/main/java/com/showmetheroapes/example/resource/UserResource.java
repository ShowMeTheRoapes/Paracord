package com.showmetheroapes.example.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.showmetheroapes.example.data.UserController;
import com.showmetheroapes.example.domain.User;

/**
 * Resource class for retrieving information.
 *
 * @author Dustin Roan (Dustin.a.roan@gmail.com)
 */
@Path("/example")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
	private final UserController controller = new UserController();

	@GET
	@Path("/users/{userId}")
	public Response getUserFollowersAndSubfollowers(@PathParam("userId") final String userId) {
		final User user = controller.getAUser(userId);
		return Response.ok(new Gson().toJson(user)).build();
	}
}
