package ca.ibs.imenu;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ca.ibs.imenu.entity.Role;
import ca.ibs.imenu.entity.User;
import ca.ibs.imenu.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class UserTest {
	
	@Autowired
	private UserService userService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Before
	public void setup() {
	}

	@After
	public void tearDown() throws Exception {
	}
		
	@Test
	@Order(1)
	public void case001_findAll() throws Exception {
		List<User> users = userService.findAll();	
		//Expected - Actual
		assertEquals("admin",users.get(0).getUsername());
		assertEquals(Role.ADMINISTRATOR,users.get(0).getRole());
	}
	
	@Test
	@Order(2)
	public void case002_getUser() throws Exception {
		User userDB = userService.findByUsername("admin");
		
		//Expected - Actual
		assertEquals("admin", userDB.getUsername());
	}

	
	@Test
	@Order(3)
	public void case003_addUser() throws Exception {
		User user = new User(); 
		user.setName("staff");
		user.setRole(Role.STAFF);
		user.setPassword("1");
		user.setUsername("staff");
				
		user = userService.save(user);
		User userDB = userService.findByUsername(user.getUsername());
		
		//Expected - Actual
		assertEquals(user.getName(), userDB.getName());
		assertEquals(user.getRole(), userDB.getRole());
		assertEquals(user.getUsername(), userDB.getUsername());
	}
	
	
	@Test
	@Order(4)
	public void case004_addUser() throws Exception {
		User user = new User(); 
		user.setName("staff");
		user.setRole(Role.STAFF);
		user.setPassword("1");
		user.setUsername("staff");
				
		user = userService.save(user);
		User userDB = userService.findByUsername(user.getUsername());
		
		//Expected - Actual
		assertEquals(user.getName(), userDB.getName());
		assertEquals(user.getRole(), userDB.getRole());
		assertEquals(user.getUsername(), userDB.getUsername());
	}
	
	@Test
	@Order(5)
	public void case005_removeUser() throws Exception {
		userService.delete( userService.findByUsername("staff"));
		//Expected - Actual
		assertEquals(null, userService.findByUsername("staff"));
	}

}