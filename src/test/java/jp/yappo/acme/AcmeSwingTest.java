package jp.yappo.acme;

import static org.junit.Assert.*;
import jp.yappo.acme.AcmeSwing;

import org.junit.Test;


public class AcmeSwingTest {
	
	
	@Test
	public void instance() {
		AcmeSwing swing = new AcmeSwing();
		assertEquals("", swing.toString());
	}
	
	@Test
	public void small() {
		String message1 = 
				"　 _ 　∩\n" +
				"(　゜∀゜)彡　Swing!Swing!" + "\n" +
				"　⊂彡\n";
		String message2 = 
				"　 _ 　∩\n" +
				"(　゜∀゜)彡　Change!" + "\n" +
				"　⊂彡\n";
		
		AcmeSwing swing = new AcmeSwing();
		assertEquals(
				message1,
				swing.swing().toString()
		);

		swing.clear();

		assertEquals(
				message2,
				swing.swing("Change!").toString()
		);
	}

	@Test
	public void smallUpDownUp() {
		String message = 
				"　 _ 　∩\n" +
				"(　゜∀゜)彡　Swing!Swing!" + "\n" +
				"(　゜∀゜)彡　Swing!" + "\n" +
				"　⊂彡\n" +
				"　 _ 　∩\n" +
				"(　゜∀゜)彡　Swing!" + "\n";
		
		AcmeSwing swing = new AcmeSwing();
		assertEquals(
				message,
				swing.swing().swing().swing().toString()
		);
	}

	@Test
	public void large() {
		String message = 
				"　　　 _ 　∩\n" +
				"　　(　゜∀゜)彡　Swing!Swing!\n" +
				"　　(　 ⊂彡\n" +
				"　 　|　　　|\n" +
				"　 　し ⌒Ｊ\n";

		AcmeSwing swing = new AcmeSwing();
		assertEquals(
				message,
				swing.Swing().toString()
		);
	}

	@Test
	public void largeUpDownUp() {
		String message = 
				"　　　 _ 　∩\n" +
				"　　(　゜∀゜)彡　Swing!Swing!\n" +
				"　　(　 　　|\n" +
				"　 　|　　　|\n" +
				"　 　し ⌒Ｊ\n" +
				"　　　 _\n" +
				"　　(　゜∀゜)　　Swing!\n" +
				"　　(　 ⊂彡\n" +
				"　 　|　　　|\n" +
				"　 　し ⌒Ｊ\n" +
				"　　　 _ 　∩\n" +
				"　　(　゜∀゜)彡　Swing!\n" +
				"　　(　 　　|\n" +
				"　 　|　　　|\n" +
				"　 　し ⌒Ｊ\n";

		AcmeSwing swing = new AcmeSwing();
		assertEquals(
				message,
				swing.Swing().Swing().Swing().toString()
		);
	}

	@Test
	public void mixUpDown() {
		String message1 = 
				"　 _ 　∩\n" +
				"(　゜∀゜)彡　Swing!Swing!" + "\n" +
				"　　　 _\n" +
				"　　(　゜∀゜)　　Swing!\n" +
				"　　(　 ⊂彡\n" +
				"　 　|　　　|\n" +
				"　 　し ⌒Ｊ\n";

		String message2 = 
				"　　　 _ 　∩\n" +
				"　　(　゜∀゜)彡　Swing!Swing!\n" +
				"　　(　 　　|\n" +
				"　 　|　　　|\n" +
				"　 　し ⌒Ｊ\n" +
				"(　゜∀゜)彡　Swing!" + "\n" +
				"　⊂彡\n";

		AcmeSwing swing = new AcmeSwing();
		assertEquals(
				message1,
				swing.swing().Swing().toString()
		);

		swing.clear();
		assertEquals(
				message2,
				swing.Swing().swing().toString()
		);
	}
}
