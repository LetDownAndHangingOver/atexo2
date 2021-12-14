package com.atexo;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import com.atexo.service.CarteService;

@WebMvcTest
public class CartesControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	
	
	
	@Test
	public void couleurAleatoireValid() throws Exception{
		this.mockMvc.perform(get("/couleursAleatoires")).andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("CARREAU")))
		.andExpect(content().string(containsString("COEUR")))
		.andExpect(content().string(containsString("PIQUE")))
		.andExpect(content().string(containsString("TREFLE")));
	}
	
	@Test
	public void valeursAleatoireValid() throws Exception{
		this.mockMvc.perform(get("/valeursAleatoires")).andDo(print())
		.andExpect(status().isOk());
//		.andExpect(jsonPath("*".length(), is(13)));
	}
}
