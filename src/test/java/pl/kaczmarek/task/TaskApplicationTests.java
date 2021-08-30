package pl.kaczmarek.task;
import static org.junit.Assert.assertFalse;

import org.junit.Assert;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.Transactional;
import pl.kaczmarek.task.model.Group;
import pl.kaczmarek.task.service.GroupServiceImpl;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Transactional
class TaskApplicationTests {

	@Autowired
	GroupServiceImpl groupService;

	@Test
	@Order(1)
	void testAddNewGroup() {
		Assert.assertEquals(groupService.getAllGroups().size(),0);
		groupService.addGroup("Grupa 1");
		Assert.assertEquals(groupService.getAllGroups().size(),1);
	}

	@Test
	@Order(2)
	void testDeleteNewGroup() {
		groupService.addGroup("Grupa 1");
		Assert.assertEquals(groupService.getAllGroups().size(),1);
		groupService.deleteGroup(1L);
		Assert.assertEquals(groupService.getAllGroups().size(),0);
	}

	@Test
	@Order(3)
	void assignOrCancelToGroup() throws InterruptedException {
		Group group  = groupService.addGroup("Grupa 1");
		groupService.assignGroup(group.getId());
		Assert.assertEquals(new BigDecimal(1.0), new BigDecimal(group.getNumberOfUsers()));
		groupService.cancelAssignGroup(group.getId());
		Assert.assertEquals(new BigDecimal(0.0), new BigDecimal(group.getNumberOfUsers()));
	}

	@Test
	@Order(4)
	void canAddGroup() throws InterruptedException {
		groupService.deleteGroup(1L);
		groupService.deleteGroup(2L);
		groupService.addGroup("Grupa 1");
		groupService.addGroup("Grupa 2");
		groupService.addGroup("Grupa 3");
		groupService.addGroup("Grupa 4");
		Assert.assertTrue(groupService.canAddGroup());
		groupService.addGroup("Grupa 5");
		Assert.assertFalse(groupService.canAddGroup());
	}





}
