package it.uniroma3.diadia;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.giocatore.Giocatore;

public class GiocatoreTest {
	
	Giocatore player;

	@Before
	public void setUp() {
		
		player = new Giocatore();
	}
	
	@Test
	public void getCfuNullTest() {
	
		assertEquals(player.getCfu(), 20);
	}
	
	@Test
	public void getCfuSpecificoTest() {
		
		player.setCfu(5);
		assertEquals(player.getCfu(), 5);
		
		
	}
	@Test
	public void setCfuTest() {
		
		player.setCfu(6);
		assertNotEquals(player.getCfu(),5);
	}
}
