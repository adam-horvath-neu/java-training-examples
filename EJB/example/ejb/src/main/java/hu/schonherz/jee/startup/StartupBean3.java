package hu.schonherz.jee.startup;

import java.util.Date;
import java.util.concurrent.Future;

import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import hu.schonherz.jee.StatelessLocal;
import hu.schonherz.jee.timer.SimpleTimer;

@Startup
@Singleton
@DependsOn("StartupBean2")
public class StartupBean3 {

	private static Log logger = LogFactory.getLog(StartupBean3.class);

	@EJB
	StatelessLocal local;

	@PostConstruct
	private void init() {
		logger.info("StartupBean3 init");

		Future<Date> future = local.asynchronousPrintTime();

		while (!future.isDone()) {
			try {
				logger.info("asynchronousPrintTime done: " + future.get());
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}

		}
	}
}
