package hu.neuron.java.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet ParamFilter implementation class ParamFilter
 */
@WebFilter("/ForwardWithAttribute")
public class ParamChangeFilter implements Filter {
	private static final Logger logger = LogManager.getLogger(ParamChangeFilter.class);

	/**
	 * Default constructor.
	 */
	public ParamChangeFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ParamChangeFilter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ParamChangeFilter#doFilter(ServletRequest, ServletResponse,
	 *      FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Map<String, String[]> map = ((HttpServletRequest) request).getParameterMap();

		for (String key : map.keySet()) {
			String[] array = map.get(key);
			if (key.equals("text")) {
				array[0] += "magic";
				logger.debug("Filter: Changed param " + array[0]);
				// map.put(key, array);
			}
		}

		chain.doFilter(request, response);
	}

	/**
	 * @see ParamChangeFilter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
