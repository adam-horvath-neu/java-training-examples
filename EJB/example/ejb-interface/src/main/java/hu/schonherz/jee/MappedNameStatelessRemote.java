package hu.schonherz.jee;

public interface MappedNameStatelessRemote {

	public void hello();

	public Double add(Double a, Double b);

	public SerializabledVO upperCase(SerializabledVO serializabledVO);

	public NoSerializabledVO upperCase(NoSerializabledVO serializabledVO);
}
