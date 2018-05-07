package hu.schonherz.jee;

import java.util.Date;
import java.util.concurrent.Future;

public interface MappedNameStatelessLocal {

	public void hello();

	public Future<Date> asynchronousPrintTime();

	public Double add(Double a, Double b);

	public SerializabledVO upperCase(SerializabledVO serializabledVO);

	public NoSerializabledVO upperCase(NoSerializabledVO serializabledVO);
}
