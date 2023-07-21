package com.udacity.pricing;

import com.udacity.pricing.api.PricingController;
import com.udacity.pricing.domain.price.Price;
import com.udacity.pricing.service.PricingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PricingController.class)
@AutoConfigureJsonTesters
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
public class PricingServiceApplicationTests {


	@Test
	public void contextLoads() {
	}


//	@LocalServerPort
//	private int port;
//
//	@Autowired
//	private TestRestTemplate restTemplate;


	@Autowired
	private MockMvc mockMvc;

//	@MockBean
//	PricingService pricingService;

	@Mock
	PricingService pricingService;

	@Autowired
	private JacksonTester<Price> json;


	@Test
	public void getPrice() throws Exception {
		Price p = new Price();
		mockMvc.perform(get("/services/price?vehicleId=1"))
				.andExpect(status().isOk());

//				get(new URI("services/price?vehicleId=1"))
//						.content(json.write(p).getJson())
//						.contentType(MediaType.APPLICATION_JSON_UTF8)
//						.accept(MediaType.APPLICATION_JSON_UTF8))
//				.andExpect(status().isOk());

//				MockMvcRequestBuilders.get("/services/price?vehicleId=1"))
//				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
//				.andExpect(MockMvcResultMatchers.status().isOk());
//		mockMvc.perform(


		verify(pricingService, times(1)).getPrice(1L);
	}


//	@Test
//	public void getPrice() {
//		ResponseEntity<Price> response =
//				this.restTemplate.getForEntity("http://localhost:" + port + "/services/price/1", Price.class);
//
//		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
//	}




}
