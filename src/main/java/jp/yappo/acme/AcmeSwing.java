package jp.yappo.acme;

import java.util.ArrayList;

/**
 * This library is funny ASCII Art generator.
 *
 * @author Yappo
 * @version 1.0
 */
public class AcmeSwing {
	private final static int STATUS_START = 0;
	private final static int STATUS_DOWN  = 1;
	private final static int STATUS_UP    = 2;

	private int nextStatus     = STATUS_START;
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
		nextStatus  = STATUS_START;
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
		if (nextStatus == STATUS_START) {
			return impl.startText();
		} else if (nextStatus == STATUS_UP) {
			return impl.swingUpText();
		} else if (nextStatus == STATUS_DOWN) {
			return impl.swingDownText();
		}
		return "";
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
		if (nextStatus == STATUS_START) {
			message += impl.startAA(messageText);
			nextStatus = STATUS_DOWN;
		} else if (nextStatus == STATUS_DOWN) {
			if (textStack.size() == 1) {
				message = implStack.get(0).swingUpAA(textStack.get(0));
			}
			message += impl.swingDownAA(messageText);
			nextStatus = STATUS_UP;
		} else if (nextStatus == STATUS_UP) {
			message += impl.swingUpAA(messageText);
			nextStatus = STATUS_DOWN;
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
