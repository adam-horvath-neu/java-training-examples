package hu.schonherz.jee;

public interface TestTransactionRemote {
	
	public static final String JAVA_GLOBAL_MAPPED_NAME = "java:global/TestTransactionRemote";
	public void commit();

	public void rollback();

}
