package hu.schonherz.jee;

public interface MappedNameStatelessRemote {
	public static final String JAVA_GLOBAL_MAPPED_NAME = "java:global/MappedNameStatelessRemote";

	public void hello();

	public Double add(Double a, Double b);

	public SerializabledVO upperCase(SerializabledVO serializabledVO);

	public NoSerializabledVO upperCase(NoSerializabledVO serializabledVO);
}
