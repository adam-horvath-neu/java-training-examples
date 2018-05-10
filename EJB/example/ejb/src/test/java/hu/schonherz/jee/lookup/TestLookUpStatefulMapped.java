package hu.schonherz.jee.lookup;

import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import hu.schonherz.jee.MappedNameStatelessRemote;

public class TestLookUpStatefulMapped {

	public static void main(String[] args) {

		Properties prop = new Properties();

		prop.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		prop.put(Context.PROVIDER_URL, "http-remoting://127.0.0.1:8080");
		// prop.put(Context.SECURITY_PRINCIPAL, "admin");
		// prop.put(Context.SECURITY_CREDENTIALS, "password");

		prop.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		prop.put("jboss.naming.client.ejb.context", true);
		
		Context context = null;
		try {
			context = new InitialContext(prop);

			MappedNameStatelessRemote remote = (MappedNameStatelessRemote) context
					.lookup("ejb:/MappedNameStatelessRemote");

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
		} finally {
			try {
				context.close();
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
	}

}
