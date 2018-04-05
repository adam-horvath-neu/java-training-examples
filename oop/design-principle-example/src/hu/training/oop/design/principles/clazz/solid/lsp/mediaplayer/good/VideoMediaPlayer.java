package hu.training.oop.design.principles.clazz.solid.lsp.mediaplayer.good;

/**
 * This class has ability to play video as well as getting audio ability from super class
 * 
 * @author Janos Pelsoczi
 */
public class VideoMediaPlayer extends MediaPlayer {

	// Play video implementation
	public void playVideo() {
		System.out.println("Playing video...");
	}
	
}
