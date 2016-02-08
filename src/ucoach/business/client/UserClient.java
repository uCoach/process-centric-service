package ucoach.business.client;

import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import ucoach.util.DatePatterns;

public class UserClient extends BaseClient {

	public UserClient() {
		// Call parent constructor
		super();
		baseTarget = baseTarget.path("user");
	}

	/**
	 * 
	 * @param userToken
	 * @return
	 */
	public JSONObject getUser(String userToken) {
		
		// Build target URL and send GET request
		Response response = getRequest(baseTarget, userToken);
		
		// Parse response
		try {
			parseResponseStatus(response);
			return new JSONObject(response.readEntity(String.class));

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
	}
}
