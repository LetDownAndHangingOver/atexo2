package com.atexo;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Contains;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.atexo.controller.CartesController;
import com.atexo.service.CarteService;

@WebMvcTest(CartesController.class)
@ContextConfiguration(classes = {CarteService.class})
public class CartesControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void dixCarteAleatoireValid() throws Exception{
		this.mockMvc.perform(get("/cartes/generate")).andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("CARREAU")))
		.andExpect(content().string(containsString("TREFLE")))
		.andExpect(content().string(containsString("COEUR")))
		.andExpect(content().string(containsString("PIQUE")))
		.andExpect(content().string(containsString("As")))
		.andExpect(content().string(containsString("Valet")))
		.andExpect(content().string(containsString("Dame")))
		.andExpect(content().string(containsString("Roi")))
		
		;
	}
	
//	@Test
//	public void valeursAleatoireValid() throws Exception{
//		this.mockMvc.perform(get("/valeursAleatoires")).andDo(print())
//		.andExpect(status().isOk());
////		.andExpect(jsonPath("*".length(), is(13)));
//	}
}
