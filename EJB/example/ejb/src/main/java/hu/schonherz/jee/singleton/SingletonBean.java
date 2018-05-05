package hu.schonherz.jee.singleton;

import java.util.Date;
import java.util.concurrent.Future;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.interceptor.Interceptors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import hu.schonherz.jee.SingletonLocal;
import hu.schonherz.jee.SingletonRemote;
import hu.schonherz.jee.interceptor.SimpleInterceptor;
import hu.schonherz.jee.timer.SimpleTimer;

@Singleton(mappedName = "SingletonBean")
@Local(SingletonLocal.class)
@Remote(SingletonRemote.class)
@Interceptors(SimpleInterceptor.class)
public class SingletonBean implements SingletonLocal, SingletonRemote {
	private static Log logger = LogFactory.getLog(SimpleTimer.class);

	@Override
	public void hello() {
		logger.info(this);
	}

	@Override
	@Asynchronous
	public Future<Date> asynchronousPrintTime() {
		logger.info("call asynchronousPrintTime" + new Date());
		try {
			Thread.sleep(5 * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new AsyncResult<Date>(new Date());
	}

}
