package hu.training.oop.concepts.cohesion;

/**
 * The purpose of "LowCohesion" is to read the resource. But it contains some
 * unrelated functions such as validateLocation(), checkFTP(), ping(). Hence it
 * is low cohesive.
 * 
 * @author
 * Janos Pelsoczi
 */
public class LowCohesion {
	// -------------- unrelated functions

	public boolean validateLocation(String pathIP) {
		return ping(pathIP) && checkFTP(pathIP);
	}

	private boolean checkFTP(String pathIP) {
		// TODO Add logic
		return true;
	}

	private boolean ping(String pathIP) {
		// TODO Add logic
		return true;
	}

	// -------------- functions related to read resource

	// read the resource from disk
	public String readFromDisk(String fileName) {
		return "data of " + fileName;
	}

	// read the resource from web
	public String readFromWeb(String url) {
		return "data of " + url;
	}

	// read the resource from network
	public String readFromNetwork(String networkAddress) {
		return "data of " + networkAddress;
	}
}
