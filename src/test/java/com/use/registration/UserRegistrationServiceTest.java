package com.use.registration;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.user.registration.models.Users;
import com.user.registration.repositories.UserRepository;
import com.user.registration.services.UserServiceBean;


@RunWith(SpringJUnit4ClassRunner.class)
public class UserRegistrationServiceTest {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserServiceBean userService;

	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetAllUsers(){
		List<Users> userList = new ArrayList<Users>();		
		userList.add(new Users("Ramesh","ramesh.t@gmail.com"));
		userList.add(new Users("Malathi","malathi.t@gmail.com"));
		userList.add(new Users("Adithi","adithi.t@gmail.com"));
		when(userRepository.findAll()).thenReturn(userList);
		Collection<Users> result = userService.findAll();
		assertEquals(3, result.size());
	}

	@Test
	public void testGetUserById(){
		Users users = new Users("Anusha","anusha.t@gmail.com");
		when(userRepository.findOne((long) 1)).thenReturn(users);
		Users result = userService.findOne((long) 1);
		assertEquals("Anusha", result.getUserName());
		assertEquals("anusha.t@gmail.com", result.getEmailAddress());		
	}

	@Test
	public void saveUser(){
		Users users = new Users("Amul","amul.d@gmail.com");
		when(userRepository.save(users)).thenReturn(users);
		Users result = userService.create(users);
		assertEquals("Amul", result.getUserName());
		assertEquals("amul.d@gmail.com", result.getEmailAddress());
	}

	@Test
	public void deleteUser(){
		Users users = new Users("Anusha","anusha.t@gmail.com");
		int id=1;
		when(userRepository.findOne((long) 1)).thenReturn(users);
		userService.delete((long) 1);
		verify(userRepository, times(1)).delete((long) id);
	//	assertNull(userService.findOne((long) 1));
	}

	@Test
	public void deleteUserById(){
	  Users users = new Users("Nitin","nitin.t@gmail.com");
		userRepository.save(users);
	  Long userId = users.getId();
	  userService.delete(userId);
	  Users user = userRepository.findOne(userId);
	  assertNull(user);
	}

}