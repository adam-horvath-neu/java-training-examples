package hu.neuron.java.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet ParamFilter implementation class ParamFilter
 */

public class ParamFilter implements Filter {
	private static final Logger logger = LogManager.getLogger(ParamFilter.class);

	private String loggerPrefix;

	/**
	 * Default constructor.
	 */
	public ParamFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ParamFilter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ParamFilter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Map<String, String[]> map = ((HttpServletRequest) request).getParameterMap();
		for (String key : map.keySet()) {
			String[] array = map.get(key);
			logger.debug(loggerPrefix + " " + key + " value: " + Arrays.toString(array));
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see ParamFilter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		loggerPrefix = fConfig.getInitParameter("LOGGER_PREFIX");

	}

}
