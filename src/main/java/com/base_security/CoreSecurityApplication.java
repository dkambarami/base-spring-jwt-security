package com.base_security;

import com.base_security.business.model.User;
import com.base_security.business.service.UserService;

import static com.base_security.dk_security.models.ApplicationUserRole.*;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class CoreSecurityApplication  implements CommandLineRunner  {

	@Autowired
	private ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(CoreSecurityApplication.class, args);

	}


	@Override
	public void run(String... args) throws Exception {
		UserService userService = applicationContext.getBean(UserService.class);
		BCryptPasswordEncoder bcrptEncoder = applicationContext.getBean(BCryptPasswordEncoder.class);
		User tom = new User("tom",bcrptEncoder.encode("tom"));
		User peter = new User("peter",bcrptEncoder.encode("peter"),"ROLE_ADMIN");
		User john = new User("john",bcrptEncoder.encode("john"),ADMIN.getGrantedAuthorities().toString(),true,true,true,true);
		userService.createOneUser(tom);
		userService.createOneUser(peter);
		userService.createOneUser(john);
	}


}
