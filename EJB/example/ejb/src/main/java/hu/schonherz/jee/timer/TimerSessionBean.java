package hu.schonherz.jee.timer;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;
import javax.interceptor.Interceptors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import hu.schonherz.jee.interceptor.SimpleInterceptor;

@Stateless
@LocalBean
@Interceptors(SimpleInterceptor.class)
public class TimerSessionBean {
	private static final String MY_TIMER = "My Timer";

	private static Log logger = LogFactory.getLog(TimerSessionBean.class);

	@Resource
	TimerService timerService;

	public void createTimer(long intervalDuration) {

		// Timer timer = timerService.createTimer(intervalDuration, MY_TIMER);

		TimerConfig timerConfig = new TimerConfig(MY_TIMER, true);
		timerService.createIntervalTimer(0, intervalDuration, timerConfig);

	}

	@Timeout
	@Interceptors(SimpleInterceptor.class)
	public void timeout(Timer timer) {
		logger.info("Timeout occurred");
		logger.info("NextTimeout : " + timer.getNextTimeout());
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