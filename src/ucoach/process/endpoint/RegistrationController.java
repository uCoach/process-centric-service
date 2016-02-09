package ucoach.process.endpoint;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import ucoach.util.Authorization;

@Path("/register")
public class RegistrationController {

	@POST
  @Produces({MediaType.APPLICATION_JSON})
  public Response afterLoginProcedure(@Context HttpHeaders headers) {
		// Build JSON response object
		JSONObject json = new JSONObject();
			
		String userToken = headers.getHeaderString("User-Authorization");
		if(!Authorization.validateRequest(headers) || (userToken == "" || userToken == null)){
			json.put("status", "401").put("message", "Unauthorize");
			return Response.status(401).entity(json.toString()).build();
		}

		json.put("status", 200);
		return Response.status(200).entity(json.toString()).build();
	}
}
