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
import hu.schonherz.jee.timer.TimerSessionBean;

@Startup
@Singleton
@DependsOn("StartupBean3")
public class StartupBean4 {

	private static Log logger = LogFactory.getLog(StartupBean4.class);

	@EJB
	TimerSessionBean timerSessionBean;

	@PostConstruct
	private void init() {
		logger.info("StartupBean4 init");

		timerSessionBean.createTimer(10000);
	}
}
