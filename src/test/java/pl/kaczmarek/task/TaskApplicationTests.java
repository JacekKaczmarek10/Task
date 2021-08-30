package pl.kaczmarek.task;
import static org.junit.Assert.assertFalse;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kaczmarek.task.service.GroupServiceImpl;

@SpringBootTest
class TaskApplicationTests {

	@Autowired
	GroupServiceImpl groupService;

	@Test
	void testAddNewGroup() {
		Assert.assertEquals(groupService.getAllGroups().size(),0);
		groupService.addGroup("Grupa 1");
		Assert.assertEquals(groupService.getAllGroups().size(),1);
	}

}
