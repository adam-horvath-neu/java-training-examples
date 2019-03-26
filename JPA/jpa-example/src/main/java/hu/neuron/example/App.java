package hu.neuron.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import hu.neuron.example.entity.Employee;

public class App {
	
	private static Logger LOGGER = LogManager.getLogger(App.class);
	
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hu.neuron.example");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Employee found = entityManager.find(Employee.class, 21);
		LOGGER.info("found=" + found);
	}
}
