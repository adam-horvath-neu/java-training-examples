package hu.schonherz.jee.lookup;

import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import hu.schonherz.jee.StatefulRemote;

public class TestLookUpStateful {

	public static void main(String[] args) {

		Properties prop = new Properties();

		prop.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		prop.put(Context.PROVIDER_URL, "http-remoting://127.0.0.1:8080");
		// prop.put(Context.SECURITY_PRINCIPAL, "admin");
		// prop.put(Context.SECURITY_CREDENTIALS, "password");

		// prop.put("jboss.naming.client.ejb.context", true);
		Context context = null;
		try {
			context = new InitialContext(prop);

			StatefulRemote remote = (StatefulRemote) context
					.lookup("ejb:ear-bus/ejb/StatefulBean!hu.schonherz.jee.StatefulRemote?stateful");

			ExecutorService executor = Executors.newFixedThreadPool(10);

			for (int i = 0; i < 20; i++) {

				executor.submit(new Runnable() {
					@Override
					public void run() {
						Double rv = remote.add(10.0);
						System.out.println(rv);
					}
				});
			}

			executor.shutdown();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			try {
				context.close();
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
	}

}
