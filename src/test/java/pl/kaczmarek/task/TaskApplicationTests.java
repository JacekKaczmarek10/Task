package pl.kaczmarek.task;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.Transactional;
import pl.kaczmarek.task.service.GroupServiceImpl;
import pl.kaczmarek.task.service.MailService;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Transactional
class TaskApplicationTests {

	@Autowired
	GroupServiceImpl groupService;

	@Autowired
	MailService mailService;

	@Test
	@Order(5)
	void sendEmail(){
		mailService.sendEmail();
	}

}
