package jp.yappo.acme;

/**
 * This interface for AcmeSwing ASCII Art.
 *
 * @author Yappo
 * @version 1.0
 */

public interface IAcmeSwingMessage {
	/**
	 * message text for start.
	 * 
	 * @return ASCII Art's message
	 */
	public String startText();

	/**
	 * message text for swing up.
	 * 
	 * @return ASCII Art's message
	 */
	public String swingUpText();
	
	/**
	 * message text for swing down.
	 * 
	 * @return ASCII Art's message
	 */
	public String swingDownText();
	
	/**
	 * ASCII Art for start.
	 * 
	 * @param messageText
	 * @return ASCII Art
	 */
	public String startAA(String messageText);
	
	/**
	 * ASCII Art for swing up.
	 * 
	 * @param messageText
	 * @return ASCII Art
	 */
	public String swingUpAA(String messageText);
	
	/**
	 * ASCII Art for swing down.
	 * 
	 * @param messageText
	 * @return ASCII Art
	 */
	public String swingDownAA(String messageText);
}
