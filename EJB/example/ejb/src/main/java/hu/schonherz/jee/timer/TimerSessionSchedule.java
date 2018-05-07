package hu.schonherz.jee.timer;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.ScheduleExpression;
import javax.ejb.Singleton;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;
import javax.interceptor.Interceptors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import hu.schonherz.jee.interceptor.SimpleInterceptor;

@Singleton
@LocalBean
@Interceptors(SimpleInterceptor.class)
public class TimerSessionSchedule {
	private static final String MY_TIMER = "My CalendarTimer";

	private static Log logger = LogFactory.getLog(TimerSessionSchedule.class);

	@Resource
	TimerService timerService;

	public void createTimer(long intervalDuration) {
		TimerConfig timerConfig = new TimerConfig(MY_TIMER, true);
		ScheduleExpression schedule = new ScheduleExpression();
		schedule.hour("*").minute("*").second(15);

		Timer timer = timerService.createCalendarTimer(schedule, timerConfig);

		logger.info(timer.getNextTimeout());
	}

	@Timeout
	public void timeout(Timer timer) {
		logger.info("Timeout occurred");
	}

	@PreDestroy
	public void stopTimer() {
		for (Object obj : timerService.getTimers()) {
			Timer t = (Timer) obj;
			if (t.getInfo().equals(MY_TIMER)) {
				t.cancel();
			}
		}
	}
}