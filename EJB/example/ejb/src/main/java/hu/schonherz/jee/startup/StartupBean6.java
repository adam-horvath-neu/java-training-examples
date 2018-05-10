package hu.schonherz.jee.startup;

import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import hu.schonherz.jee.transaction.dao.TestDao;

@Startup
@Singleton
@DependsOn("StartupBean5")
public class StartupBean6 {

	private static Log logger = LogFactory.getLog(StartupBean6.class);

	@EJB
	TestDao dao;

	@PostConstruct
	public void init() {
		dao.createTable();
	}

}
