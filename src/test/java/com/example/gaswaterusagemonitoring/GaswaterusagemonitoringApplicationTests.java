package com.example.gaswaterusagemonitoring;

import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URI;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@SpringBootTest
@AutoConfigureMockMvc
public class GaswaterusagemonitoringApplicationTests {

	private static final String RESOURCE_URL = "/v1/users";
	@Autowired
	private MockMvc mockMvc;


	@Test
	public void exposeUserConsumptionByUserId_noUserFound() throws Exception {

		mockMvc.perform(get(RESOURCE_URL+"/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string("[]"))
		;

	}

	@Test
	public void exposeUserConsumptionByUserId_UserFound() throws Exception {

		mockMvc.perform(
				post(RESOURCE_URL)
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"userId\":\"1\",\"gas\":\"1000\",\"coldwater\":\"500\",\"hotwater\":\"700\"}"))
				.andExpect(status().isCreated());

		mockMvc.perform(
				post(RESOURCE_URL)
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"userId\":\"1\",\"gas\":\"2000\",\"coldwater\":\"600\",\"hotwater\":\"800\"}"))
				.andExpect(status().isCreated());

		mockMvc.perform(
				post(RESOURCE_URL)
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"userId\":\"1\",\"gas\":\"3000\",\"coldwater\":\"700\",\"hotwater\":\"900\"}"))
				.andExpect(status().isCreated());


		mockMvc.perform(
				get(RESOURCE_URL +"/1")
						.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(jsonPath("$[*].gas", containsInAnyOrder(1000, 2000, 3000)))
				.andExpect(jsonPath("$[*].coldwater", containsInAnyOrder(500, 600, 700)))
				.andExpect(jsonPath("$[*].hotwater", containsInAnyOrder(700, 800, 900)))
				;

	}
	@Test
	void contextLoads() {
	}

}
