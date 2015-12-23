package ch06.rule;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import ch06.UserDao;

@SuppressWarnings("unused")
public class UserDaoTest {
	private UserDao sut;

	@Rule
	public InMemoryDBRule db = new InMemoryDBRule();

	@Before
	public void setUp() throws Exception {
		sut = new UserDao();
	}

	@Test
	public void getListは0件を返す() throws Exception {
		fail("未実装");
	}

}
