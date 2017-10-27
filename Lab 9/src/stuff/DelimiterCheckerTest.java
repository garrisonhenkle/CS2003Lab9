package stuff;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.jupiter.api.Test;

class DelimiterCheckerTest {

	DelimiterChecker dc = new DelimiterChecker();
	
	@Test
	void simpleMatching() {

		assertTrue(dc.check("{}{}{}{}{}{}{}{}{}"));
		assertTrue(dc.check("()"));
		assertTrue(dc.check("([{}])"));

	}

	@Test
	void matchingWithOtherChars() {
		assertTrue(dc.check("(1)(22)(333)(22)(1)"));
		assertTrue(dc.check("(h(e(l(l(o{ }w)o)r)l)d)"));
		assertTrue(dc.check("[{(1)(2)(3){4}{5}}[6][(7)]]"));
		assertTrue(dc.check("%Appdata%"));
	}
	
	@Test
	void incorrectLeftDelimiters() {
		assertFalse(dc.check(")"));
		assertFalse(dc.check("()({}{})]"));
		assertFalse(dc.check("[{([()()]})}]"));
	}
	
	@Test
	void incorrectRightDelimiters() {
		assertFalse(dc.check("("));
		assertFalse(dc.check("{}{"));
		assertFalse(dc.check("(()([][)())"));
		assertFalse(dc.check("{[][](()(()[))()"));
	}
	
	@Test
	void incorrectMatchingDelimiters() {
		assertFalse(dc.check("(}"));
		assertFalse(dc.check("()()()(){}[{}{}(]()]"));
		assertFalse(dc.check("[]{{)}"));
	}
}
