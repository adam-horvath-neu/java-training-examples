package hu.schonherz.jee;

import java.util.Date;
import java.util.concurrent.Future;

public interface SingletonLocal {

	public void hello();

	public Future<Date> asynchronousPrintTime();

}
