package hu.schonherz.jee;

public interface StatelessRemote {

	public void hello();

	public Double add(Double a, Double b);

	public SerializabledVO upperCase(SerializabledVO serializabledVO);

	public NoSerializabledVO upperCase(NoSerializabledVO serializabledVO);
}
