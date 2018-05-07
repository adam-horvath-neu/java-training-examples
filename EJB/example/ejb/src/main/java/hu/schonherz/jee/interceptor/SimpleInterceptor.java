package hu.schonherz.jee.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SimpleInterceptor {
	private static Log logger = LogFactory.getLog(SimpleInterceptor.class);

	@AroundInvoke
	public Object intercept(InvocationContext context) throws Exception {
		logger.info("instance: " + context.getTarget());

		Object result = context.proceed();

		return result;
	}

}