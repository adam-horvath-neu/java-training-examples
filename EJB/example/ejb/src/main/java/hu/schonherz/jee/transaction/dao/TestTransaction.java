package hu.schonherz.jee.transaction.dao;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import hu.schonherz.jee.MappedNameStatelessRemote;
import hu.schonherz.jee.TestTransactionLocal;
import hu.schonherz.jee.TestTransactionRemote;

@Stateless
@Local(TestTransactionLocal.class)
@Remote(TestTransactionRemote.class)
@TransactionManagement(TransactionManagementType.CONTAINER)
@EJB(name = TestTransactionRemote.JAVA_GLOBAL_MAPPED_NAME, beanInterface = TestTransactionRemote.class)
public class TestTransaction implements TestTransactionLocal, TestTransactionRemote {

	@EJB
	TestDao dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void commit() {
		dao.insert("commit");
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void rollback() {
		dao.insert("rollback");
		dao.insertNewTransaction("rollback with NewTransaction");
		newTranasaction();
		throw new RuntimeException("rollback");
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void newTranasaction() {
		dao.insert("newTranasaction");
	}
}
