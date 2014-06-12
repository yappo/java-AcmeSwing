package jp.yappo.acme;

import static org.junit.Assert.*;
import jp.yappo.acme.AcmeSwing;
import jp.yappo.acme.AcmeSwingMessage;

import org.junit.Test;

public class AcmeSwingMessageSmallImplTest {

	final AcmeSwing swing = new AcmeSwing(
			new AcmeSwingMessageTestImpl(),
			new AcmeSwingMessageTestImpl()
			);

	@Test
	public void instance() {
		assertEquals("", swing.toString());
	}

	@Test
	public void allTest() {
		assertEquals("startAA=startText\n", swing.clear().swing().toString());
		assertEquals("startAA=foo\n", swing.clear().swing("foo").toString());
		assertEquals(
				"swingUpAA=startText\nswingDownAA=swingDownText\nswingUpAA=swingUpText\n",
				swing.clear().swing().swing().swing().toString()
				);
		assertEquals(
				"swingUpAA=niki\nswingDownAA=golf\nswingUpAA=dayo\n",
				swing.clear().swing("niki").swing("golf").swing("dayo").toString()
				);
	}

}

class AcmeSwingMessageTestImpl implements AcmeSwingMessage {
	public String startText() {
		return "startText";
	}

	public String swingUpText() {
		return "swingUpText";
	}

	public String swingDownText() {
		return "swingDownText";
	}

	public String startAA(String messageText) {
		return "startAA=" + messageText + "\n";
	}

	public String swingUpAA(String messageText) {
		return "swingUpAA=" + messageText + "\n";
	}

	public String swingDownAA(String messageText) {
		return "swingDownAA=" + messageText + "\n";
	}
}
