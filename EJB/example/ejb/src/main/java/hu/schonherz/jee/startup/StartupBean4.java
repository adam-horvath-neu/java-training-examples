package hu.schonherz.jee.startup;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.DependsOn;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import hu.schonherz.jee.timer.TimerSessionBean;
import hu.schonherz.jee.timer.TimerSessionSchedule;

@Startup
@Singleton
@DependsOn("StartupBean3")
public class StartupBean4 {

	private static Log logger = LogFactory.getLog(StartupBean4.class);

	@EJB
	TimerSessionBean timerSessionBean;

	@EJB
	TimerSessionSchedule timerSessionSchedule;

	@PostConstruct
	private void init() {
		logger.info("StartupBean4 init");

		timerSessionBean.createTimer(1000 * 60);
		timerSessionSchedule.createTimer(1000 * 60);
	}

	@PreDestroy
	private void destroy() {
		timerSessionBean.stopTimer();
		timerSessionSchedule.stopTimer();
	}
}
