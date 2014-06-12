package jp.yappo.acme;

import java.util.ArrayList;

/**
 * This library is funny ASCII Art generator.
 *
 * @author Yappo
 * @version 1.0
 */
public class AcmeSwing {
	enum swingStatus { START, DOWN, UP };
	private swingStatus nextStatus = swingStatus.START;

	private String message = "";
	private final ArrayList<String> textStack            = new ArrayList<String>();
	private final ArrayList<IAcmeSwingMessage> implStack = new ArrayList<IAcmeSwingMessage>();

	IAcmeSwingMessage smallImpl;
	IAcmeSwingMessage largeImpl;
	
	/**
	 * create instance.
	 */
	public AcmeSwing() {
		smallImpl = new AcmeSwingMessageSmallImpl();
		largeImpl = new AcmeSwingMessageLargeImpl();
		clear();
	}
	
	/**
	 * crate instance.
	 * 
	 * @param small small ASCII Art object
	 * @param large large ASCII Art object
	 */
	public AcmeSwing(IAcmeSwingMessage small, IAcmeSwingMessage large) {
		smallImpl = small;
		largeImpl = large;
		clear();
	}
	
	/**
	 * clear the swing message stack.
	 * 
	 * @return swing object
	 */
	public final AcmeSwing clear() {
		nextStatus  = swingStatus.START;
		message = "";
		textStack.clear();
		implStack.clear();
		return this;
	}

	/**
	 * generate funny ASCII Art.
	 * 
	 * @return ASCII Art
	 */
	@Override
	public final String toString() {
		return message;
		
	}
	
	private final String generateText (IAcmeSwingMessage impl) {
		switch (nextStatus) {
			case START:
				return impl.startText();
			case UP:
				return impl.swingUpText();
			case DOWN:
				return impl.swingDownText();
			default:
				return "";
		}
	}

	/**
	 * add ASCII Art stack.
	 * 
	 * @return swing object
	 */
	public final AcmeSwing swing() {
		return generate(smallImpl, generateText(smallImpl));
	}

	/**
	 * add ASCII Art stack.
	 * 
	 * @param messageText message text
	 * @return swing object
	 */
	public final AcmeSwing swing(String messageText) {
		return generate(smallImpl, messageText);
	}

	/**
	 * add ASCII Art stack.
	 * 
	 * @return swing object
	 */
	public final AcmeSwing Swing() {
		return generate(largeImpl, generateText(largeImpl));
	}

	/**
	 * add ASCII Art stack.
	 * 
	 * @param messageText message text
	 * @return swing object
	 */
	public final AcmeSwing Swing(String messageText) {
		return generate(largeImpl, messageText);
	}

	private final AcmeSwing generate(IAcmeSwingMessage impl, String messageText) {
		switch (nextStatus) {
			case START:
				message += impl.startAA(messageText);
				nextStatus = swingStatus.DOWN;
				break;
			case DOWN:
				if (textStack.size() == 1) {
					message = implStack.get(0).swingUpAA(textStack.get(0));
				}
				message += impl.swingDownAA(messageText);
				nextStatus = swingStatus.UP;
				break;
			case UP:
				message += impl.swingUpAA(messageText);
				nextStatus = swingStatus.DOWN;
				break;
			default:
				break;
		}
		
		textStack.add(messageText);		
		implStack.add(impl);		
		return this;
	}
}

class AcmeSwingMessageSmallImpl implements IAcmeSwingMessage { 
	public String startText() {
		return "Swing!Swing!";
	}

	public String swingUpText() {
		return "Swing!";
	}

	public String swingDownText() {
		return "Swing!";
	}

	public String startAA(String messageText) {
		return	"　 _ 　∩\n" +
				"(　゜∀゜)彡　" + messageText + "\n" +
				"　⊂彡\n";		
	}

	public String swingUpAA(String messageText) {
		return	"　 _ 　∩\n" +
				"(　゜∀゜)彡　" + messageText + "\n";
	}

	public String swingDownAA(String messageText) {
		return	"(　゜∀゜)彡　" + messageText + "\n" +
				"　⊂彡\n";
	}
}

class AcmeSwingMessageLargeImpl extends AcmeSwingMessageSmallImpl { 
	public String startAA(String messageText) {
		return 	"　　　 _ 　∩\n" +
				"　　(　゜∀゜)彡　" + messageText + "\n" +
				"　　(　 ⊂彡\n" +
				"　 　|　　　|\n" +
				"　 　し ⌒Ｊ\n";
	}

	public String swingUpAA(String messageText) {
		return 	"　　　 _ 　∩\n" +
				"　　(　゜∀゜)彡　" + messageText + "\n" +
				"　　(　 　　|\n" +
				"　 　|　　　|\n" +
				"　 　し ⌒Ｊ\n";
	}

	public String swingDownAA(String messageText) {
		return 	"　　　 _\n" +
				"　　(　゜∀゜)　　" + messageText + "\n" +
				"　　(　 ⊂彡\n" +
				"　 　|　　　|\n" +
				"　 　し ⌒Ｊ\n";
	}
}
