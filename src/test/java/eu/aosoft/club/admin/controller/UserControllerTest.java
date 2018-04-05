/**
 * 
 */
package eu.aosoft.club.admin.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import eu.aosoft.club.admin.dto.UserDto;
import eu.aosoft.club.admin.utils.GsonUtils;

/**
 * @author Offermann Alexander
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testGetUserByUserNameFaild() throws Exception {

		String URI = "/user/NotFound";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);

		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

		assertEquals(HttpStatus.NO_CONTENT.value(), mvcResult.getResponse().getStatus());
	}

	@Test
	public void testGetUserByUserNameSucces() throws Exception {

		String URI = "/user/aoffermann";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);

		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

		assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
	}

	@Test
	public void testSaveUserSucces() throws Exception {

		String URI = "/user/add";

		UserDto userDto = UserDto.builder().userName("coffermann").password("pwd123").build();

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URI).contentType(MediaType.APPLICATION_JSON_UTF8)
				.accept(MediaType.APPLICATION_JSON_UTF8).content(GsonUtils.objectToJson(userDto));

		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

		assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
	}

}
