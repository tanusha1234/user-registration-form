package com.use.registration;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.user.registration.UserRegistrationFormApplication;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = UserRegistrationFormApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserRegistrationFormApplicationTests {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wc).build();

	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void verifyAllUserRegistrationList() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/users").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$", hasSize(4))).andDo(print());
	}

	@Test
	public void verifyUserRegistrationById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/users/1").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.id").exists())
		.andExpect(jsonPath("$.userName").exists())
		.andExpect(jsonPath("$.emailAddress").exists())
		.andExpect(jsonPath("$.registeredDate").exists())
		.andExpect(jsonPath("$.id").value(1))
		.andExpect(jsonPath("$.userName").value("Anusha"))
		.andExpect(jsonPath("$.emailAddress").value("anusha.t2601@gmail.com"))
		.andDo(print());
	}


	@Test
	public void verifyInvalidUserRegistrationId() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/users/8").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.errorCode").value(404))
		.andExpect(jsonPath("$.message").value("User doesn´t exist"))
		.andDo(print());
	}

	@Test
	public void verifyNullUserRegistration() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/users/0").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.errorCode").value(404))
		.andExpect(jsonPath("$.message").value("User doesn´t exist"))
		.andDo(print());
	}

	@Test
	public void verifyDeleteUserRegistration() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/users/3"))
		.andExpect(status().isOk())
		.andDo(print());
	}

	@Test
	public void verifyInvalidUserRegistrationIdToDelete() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/users/9"))
		.andExpect(jsonPath("$.errorCode").value(400))
		.andDo(print());
	}

	@Test
	public void verifySaveUser() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/users")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"userName\" : \"Amulya\", \"emailAddress\" : \"amulya@gmail.com\" }")
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.id").exists())
		.andExpect(jsonPath("$.userName").exists())
		.andExpect(jsonPath("$.emailAddress").exists())
		.andExpect(jsonPath("$.userName").value("Amulya"))
		.andExpect(jsonPath("$.emailAddress").value("amulya@gmail.com"))
		.andDo(print());
	}


}
