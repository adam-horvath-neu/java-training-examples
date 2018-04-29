package hu.neuron.web.security;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.realm.GenericPrincipal;
import org.apache.catalina.realm.RealmBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomRealm extends RealmBase {

	private String username;
	private String password;
	protected static Logger log = LogManager.getLogger(CustomRealm.class);

	public CustomRealm() {
		log.info("CustomRealm activated");
	}

	@Override
	public Principal authenticate(String username, String credentials) {

		this.username = username;
		this.password = credentials;
		log.info("Authentication is taking place with userid: " + username);
		/* authentication just check the username and password is same */
		if (this.username.equals(this.password)) {
			return getPrincipal(username);
		} else {
			return null;
		}
	}

	@Override
	protected String getPassword(String username) {
		return password;
	}

	@Override
	protected Principal getPrincipal(String string) {
		List<String> roles = new ArrayList<String>();
		roles.add("TomcatAdmin"); // Adding role "TomcatAdmin" role to the user
		log.info("Realm: " + this);
		Principal principal = new GenericPrincipal(username, password, roles);
		log.info("Principal: " + principal);
		return principal;
	}
}