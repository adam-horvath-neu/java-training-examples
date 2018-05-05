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

import hu.schonherz.jee.SingletonLocal;
import hu.schonherz.jee.singleton.SingletonBean;

@Startup
@Singleton
@DependsOn("StartupBean4")
public class StartupBean5 {

	private static Log logger = LogFactory.getLog(StartupBean5.class);

	@EJB
	SingletonLocal singletonBean;

	@PostConstruct
	private void init() {
		logger.info("StartupBean5 init");

		ExecutorService executor = Executors.newFixedThreadPool(10);

		for (int i = 0; i < 20; i++) {

			executor.submit(new Runnable() {
				@Override
				public void run() {
					singletonBean.hello();

				}
			});
		}

		executor.shutdown();
	}
}
