package hu.neuron.java.rs;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Path("/users")
public class UserRestWebService {
	private static Log logger = LogFactory.getLog(UserRestWebService.class);

	private static List<UserWebServiceVo> users = new ArrayList<>();

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	@Path("/list")
	public UserWebServiceVoList getUserList() {
		logger.info("call getUserList ");
		return new UserWebServiceVoList(users);
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/{username}")
	public UserWebServiceVo getUser(@PathParam("username") String userName) {
		logger.info("call getUser ");
		return users.stream().filter(u -> userName.equals(userName)).findFirst().get();
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/id")
	public UserWebServiceVo getUserById(@QueryParam("id") Long id) {
		logger.info("call getUserById ");
		return users.stream().filter(u -> id.equals(id)).findFirst().get();
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/save")
	public UserWebServiceVo save(UserWebServiceVo serviceVo) {
		logger.info("call save ");
		serviceVo.setId(new Long(users.size() + 1));
		users.add(serviceVo);
		return serviceVo;
	}
}