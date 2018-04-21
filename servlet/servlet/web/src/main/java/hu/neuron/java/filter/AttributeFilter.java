package hu.neuron.java.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet ParamFilter implementation class ParamFilter
 */
@WebFilter("/result.jsp")
public class AttributeFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public AttributeFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see AttributeFilter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see AttributeFilter#doFilter(ServletRequest, ServletResponse,
	 *      FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		request.setAttribute("requestValue", " magicFilter");

		chain.doFilter(request, response);
	}

	/**
	 * @see AttributeFilter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
