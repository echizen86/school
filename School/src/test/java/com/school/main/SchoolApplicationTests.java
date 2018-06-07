package com.school.main;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.school.main.service.StudentService;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SchoolApplicationTests {

	@Autowired
	private StudentService studentService;
	
	private MockMvc mockMvc;
	
//	@SuppressWarnings("deprecation")
//	@Test
//	public void GetStudent() {
//		Student test = new Student();
//		test.setAge(35);
//		test.setFirstName("Test");
//		test.setLastName("Test");
//		test.setSex(false);
//		test.setId((long) 73);
//		
//		Student result = new Student();
//		
//		Mockito.when(studentService.getStudent((long)73)).thenReturn(test);
//		
//		result = studentService.getStudent((long)73);
//		
//		Assert.assertEquals(test, result);
//	}
	
	@Test
	public void verifyToDoById() throws Exception {
//		mockMvc.perform(MockMvcRequestBuilders.get("/student/73").accept(MediaType.APPLICATION_JSON))
//		.andExpect(jsonPath("$.id").exists())
//		.andExpect(jsonPath("$.firstName").exists())
//		.andExpect(jsonPath("$.lastName").exists())
//		.andExpect(jsonPath("$.age").exists())
//		.andExpect(jsonPath("$.sex").exists())
//		.andExpect(jsonPath("$.id").value(73))
//		.andExpect(jsonPath("$.firstName").value("Test"))
//		.andExpect(jsonPath("$.lastName").value("Test"))
//		.andExpect(jsonPath("$.age").value(35))
//		.andExpect(jsonPath("$.sex").value(false))
//		.andDo(print());
	}

}
