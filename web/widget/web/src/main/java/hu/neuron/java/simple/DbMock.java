package hu.neuron.java.simple;

import java.util.HashMap;

public class DbMock {

	static HashMap<Long, Data> db = new HashMap<Long, Data>();

	static HashMap<Long, Data> getDb() {
		return db;
	}
}
