package hu.schonherz.jee.startup;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import hu.schonherz.jee.StatefulLocal;
import hu.schonherz.jee.StatelessLocal;
import hu.schonherz.jee.timer.SimpleTimer;

@Startup
@Singleton
@DependsOn("StartupBean")
public class StartupBean2 {
	private static Log logger = LogFactory.getLog(StartupBean2.class);
	@EJB
	StatefulLocal local;

	@PostConstruct
	private void init() {
		logger.info("StartupBean2 init");

		ExecutorService executor = Executors.newFixedThreadPool(10);

		for (int i = 0; i < 20; i++) {

			executor.submit(new Runnable() {
				@Override
				public void run() {
					local.hello();

				}
			});
		}

		executor.shutdown();
	}

}
