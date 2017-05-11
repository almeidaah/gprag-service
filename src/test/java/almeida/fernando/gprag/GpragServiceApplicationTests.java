package almeida.fernando.gprag;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import almeida.fernando.gprag.model.Cliente;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GpragServiceApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;
	
	/*
	 * o Endpoint / está sem serviços, não deve retornar nada.
	 */

	@SuppressWarnings("unchecked")
	@Test
	public void homeTestStatus() {
		Map<String, String> homeReturn = this.restTemplate.getForObject("/", HashMap.class);
		assertEquals(404, homeReturn.get("status"));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void homeTestMessage() {
		Map<String, String> homeReturn = this.restTemplate.getForObject("/", HashMap.class);
		assertEquals("No message available", homeReturn.get("message"));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testGetClients() {
		List<Cliente> clientes = (List<Cliente>) this.restTemplate.getForObject("/gprag/v1/clients", ArrayList.class);
		assertTrue(clientes.size() > 0);
	}

}
