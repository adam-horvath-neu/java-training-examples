package hu.training.design.patterns.behavioral.observer;

/**
 * Subject interface
 * 
 * @author Janos Pelsoczi
 * 
 */
public interface Subject {
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();
}
