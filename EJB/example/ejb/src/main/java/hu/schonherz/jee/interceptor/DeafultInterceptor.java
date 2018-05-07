package hu.schonherz.jee.interceptor;

import java.util.Date;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DeafultInterceptor {
	private static Log logger = LogFactory.getLog(DeafultInterceptor.class);

	@AroundInvoke
	public Object intercept(InvocationContext context) throws Exception {
		Date date = new Date();
		logger.info("before " + context.getMethod().getName());

		Object result = context.proceed();

		logger.info("after " + (new Date().getTime() - date.getTime()));

		return result;
	}

}