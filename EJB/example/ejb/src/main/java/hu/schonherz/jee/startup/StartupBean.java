package hu.schonherz.jee.startup;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import hu.schonherz.jee.StatelessLocal;

@Startup
@Singleton
public class StartupBean {
	private static Log logger = LogFactory.getLog(StartupBean.class);
	@EJB
	StatelessLocal local;

	@PostConstruct
	private void init() {
		logger.info("StartupBean init");

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
