package hu.schonherz.jee.stateless;

import java.util.Date;
import java.util.concurrent.Future;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import hu.schonherz.jee.StatelessLocal;
import hu.schonherz.jee.StatelessRemote;

@Stateless
@Local(StatelessLocal.class)
@Remote(StatelessRemote.class)
public class StatelessBean implements StatelessLocal, StatelessRemote {
	private static Log logger = LogFactory.getLog(StatelessBean.class);

	@Override
	public void hello() {
		logger.info("StatelessBean : " + this);
	}

	@Override
	@Asynchronous
	public Future<Date> asynchronousPrintTime() {
		logger.info("call printTime" + new Date());
		try {
			Thread.sleep(5 * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new AsyncResult<Date>(new Date());
	}

}
