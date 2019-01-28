package io.codementor.gtommee.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import io.codementor.gtommee.springbootmongodb.SpringBootMongoDbApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringBootMongoDbApplication.class })
public class PetsControllerTest {

	private ClassLoader classLoader = this.getClass().getClassLoader();

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setUp(){
		this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void shouldReturnStatusCreateWhenPostingForNfseStatus() throws Exception {
		this.mockMvc.perform(get("/pets/")).andExpect(status().isAccepted());
	}

}
