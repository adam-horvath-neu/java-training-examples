package hu.schonherz.jee.timer;

import java.util.Date;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Schedules;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timer;
import javax.ejb.TimerService;
import javax.interceptor.Interceptors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import hu.schonherz.jee.interceptor.SimpleInterceptor;

@Singleton
@Startup
@Interceptors(SimpleInterceptor.class)
public class SimpleTimer {
	private static final String MY_TIMER = "TIMER";
	private static final String MY_TIMER2 = "TIMER2";

	private static Log logger = LogFactory.getLog(SimpleTimer.class);

	@Resource
	TimerService timerService;

	@Schedules({ @Schedule(hour = "*", minute = "*", second = "10", persistent = false, info = MY_TIMER),
			@Schedule(hour = "*", minute = "*", second = "45", info = MY_TIMER2) })
	public void printTime() {
		logger.info(getClass().getName() + ": " + new Date());
	}

	@PreDestroy
	public void stopTimer() {
		for (Object obj : timerService.getTimers()) {
			Timer t = (Timer) obj;
			if (t.getInfo().equals(MY_TIMER) || t.getInfo().equals(MY_TIMER2)) {
				t.cancel();
			}
		}
	}
}
