package org.zhygalov.springcrud;
import org.zhygalov.springcrud.model.*;
import org.zhygalov.springcrud.config.*;
import org.zhygalov.springcrud.dao.*;
import org.zhygalov.springcrud.service.*;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class App {
  public static void main(String [] args) {
	  ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(WebConfig.class, UserJpaConfig.class);
		var service = applicationContext.getBean(UserService.class);
		var user1 = new User("User", "1", "1111");
		var user2 = new User("User", "2", "2222");
		var user3 = new User("User", "3", "3333");
		List.of(user1, user2, user3).forEach(service::create);
		service.findAll().forEach(System.out::println);
		user1.setPhoneNumber("1212");
		service.update(user1);
		service.findAll().forEach(System.out::println);
		service.delete(user2);
		service.findAll().forEach(System.out::println);
		
  }
}