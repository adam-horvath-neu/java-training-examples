package hu.training.oop.design.principles.clazz.solid.lsp.mediaplayer.bad;

/**
 * Now there is a need of launching new Winamp player to play audio, but playing
 * video is not supported at this stage.
 * 
 * Oops... LSP is violated here! Why? Logically winamp player only supports
 * playing audio. So what's wrong in overriding playVideo method of super class?
 *
 * Well, see how it broke the client program (ClientTestProgram.java)
 *
 * @author Janos Pelsoczi
 */
public class WinampMediaPlayer extends MediaPlayer {

	// Play video is not supported in Winamp player
	public void playVideo() {
		throw new VideoUnsupportedException();
	}
}
