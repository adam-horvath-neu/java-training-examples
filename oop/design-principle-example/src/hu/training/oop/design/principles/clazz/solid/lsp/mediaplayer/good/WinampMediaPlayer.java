package hu.training.oop.design.principles.clazz.solid.lsp.mediaplayer.good;

/**
 * Now there is a need of launching new Winamp player to play audio, but playing
 * video is not supported at this stage.
 * 
 * So Winamp Media player extending behavior of super class Audio Media Player.
 * Perfect, LSP is not violated here.
 *
 * @author Janos Pelsoczi
 */
public class WinampMediaPlayer extends AudioMediaPlayer {

}
