package pl.dopierala.SpringCourse;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.dopierala.SpringCourse.domain.repository.InMemoryRepository;
import pl.dopierala.SpringCourse.domain.Knight;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringCourseApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCastle(){
		//given
		String shouldReturn = "InMemoryRepository named InMemoryRepository Black. Knight Knight named:Lancelot (age: 29). Has quest: Save the princess. is living here.";
		//when
		//then
		Assert.assertTrue(true);
	}

}
