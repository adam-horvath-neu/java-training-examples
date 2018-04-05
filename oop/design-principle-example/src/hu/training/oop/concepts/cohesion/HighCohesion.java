package hu.training.oop.concepts.cohesion;

/**
 * The purpose of "HighCohesion" is to read the resource and it does that only.
 * It does not implement other unrelated things. Hence it is highly cohesive.
 * 
 * @author Janos Pelsoczi
 * 
 */
public class HighCohesion {
	// -------------- functions related to read resource

	// read the resource from disk
	public String readFromDisk(String fileName) {
		return "reading data of " + fileName;
	}

	// read the resource from web
	public String readFromWeb(String url) {
		return "reading data of " + url;
	}

	// read the resource from network
	public String readFromNetwork(String networkAddress) {
		return "reading data of " + networkAddress;
	}

}
