package it.uniroma3.diadia;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class LabirintoTest {

	private Stanza stanzaVincente;
	private Stanza stanzaCorrente;
	private Labirinto reticolo;
	
	@Before
	public void setUp () {
		
		stanzaVincente = new Stanza("Biblioteca");
		stanzaCorrente = new Stanza("Atrio");
		reticolo = new Labirinto();
		
	}
	
	@Test
	public void getStanzaVincenteTest() {
		
		assertEquals(reticolo.getStanzaVincente().getNome(), stanzaVincente.getNome());
		
	}
	
	@Test
	public void getStanzaVincenteNotNullTest() {
		
		assertNotEquals(reticolo.getStanzaVincente(), null);
	}

	@Test
	public void getStanzaCorrenteTest() {
		
		assertEquals(reticolo.getStanzaCorrente().getNome(), stanzaCorrente.getNome());
	}
	
	@Test
	public void getStanzaCorrenteNotNullTest() {
		
		assertNotEquals(reticolo.getStanzaCorrente().getNome(), null);
	}
}
