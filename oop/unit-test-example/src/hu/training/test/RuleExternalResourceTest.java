package hu.training.test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;

public class RuleExternalResourceTest {
	Server myServer = new Server();

	@Rule
	public ExternalResource resource = new ExternalResource() {
		@Override
		protected void before() throws Throwable {
			myServer.connect();
		};

		@Override
		protected void after() {
			myServer.disconnect();
		};
	};

	@Test
	public void testFoo() {
		new Client().run(myServer);
	}
}