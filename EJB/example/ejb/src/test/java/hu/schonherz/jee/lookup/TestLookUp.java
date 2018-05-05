package hu.schonherz.jee.lookup;

import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import hu.schonherz.jee.StatelessRemote;

public class TestLookUp {

	public static void main(String[] args) {

		Properties prop = new Properties();

		prop.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		prop.put(Context.PROVIDER_URL, "http-remoting://127.0.0.1:8080");
//		prop.put(Context.SECURITY_PRINCIPAL, "admin");
//		prop.put(Context.SECURITY_CREDENTIALS, "password");

//		prop.put("jboss.naming.client.ejb.context", true);

		try {
			Context context = new InitialContext(prop);

			StatelessRemote remote = (StatelessRemote) context
					.lookup("ejb:ear/ejb-0.0.1-SNAPSHOT/StatelessBean!hu.schonherz.jee.StatelessRemote");

			ExecutorService executor = Executors.newFixedThreadPool(10);

			for (int i = 0; i < 20; i++) {

				executor.submit(new Runnable() {
					@Override
					public void run() {
						remote.hello();

					}
				});
			}

			executor.shutdown();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

}
