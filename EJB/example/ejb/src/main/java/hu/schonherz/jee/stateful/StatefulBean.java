package hu.schonherz.jee.stateful;

import java.util.Date;
import java.util.concurrent.Future;

import javax.annotation.PostConstruct;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.interceptor.Interceptors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import hu.schonherz.jee.StatefulLocal;
import hu.schonherz.jee.StatefulRemote;
import hu.schonherz.jee.interceptor.SimpleInterceptor;

@Local(StatefulLocal.class)
@Remote(StatefulRemote.class)
@Stateful
@Interceptors(SimpleInterceptor.class)
public class StatefulBean implements StatefulLocal, StatefulRemote {
	private static Log logger = LogFactory.getLog(StatefulBean.class);

	private Double result;

	@PostConstruct
	public void init() {
		result = 0.0;
	}

	@Override
	public void hello() {
		logger.info("Statelessful : " + this);
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

	@Override
	public Double add(Double a) {
		return result += a;
	}

}
