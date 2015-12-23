package ch06.rule;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import ch06.InMemoryDB;

public class InMemoryDBRule implements TestRule {

	InMemoryDB db = null;

	public Statement apply(final Statement base, Description description) {
		db = new InMemoryDB();
		
		return new Statement() {
			public void evaluate() throws Throwable {
				db.start();
				try {
					base.evaluate();
				} finally {
					db.shutdown();
				}
			}
		};
	}

}
