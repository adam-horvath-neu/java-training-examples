package hu.schonherz.jee.timer;

import java.util.Date;

import javax.ejb.Schedule;
import javax.ejb.Schedules;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Singleton
@Startup
public class SimpleTimer {
	private static Log logger = LogFactory.getLog(SimpleTimer.class);

	@Schedules({ @Schedule(hour = "*", minute = "*", second = "10", persistent = false),
			@Schedule(hour = "*", minute = "*", second = "45") })
	public void printTime() {
		logger.info(getClass().getName() + ": " + new Date());
	}
}
