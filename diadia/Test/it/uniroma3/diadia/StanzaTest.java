package it.uniroma3.diadia;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
	
	Stanza stanza1;
	Stanza stanza2;
	Stanza stanza3;
	
	Attrezzo attrezzo1;
	Attrezzo attrezzo2;

	@Before
	public void setUp() {
		
		stanza1 = new Stanza("Aula1");
		stanza2 = new Stanza("Aula2");
		stanza3 = new Stanza("Aula3");
		
		attrezzo1 = new Attrezzo("matita", 1);
		attrezzo2 = new Attrezzo("penna", 1);
		
	}
	
	@Test
	public void impostaStanzaAdiacenteNullTest() {
		
		assertEquals(stanza1.getStanzaAdiacente("nord"), null);
	}
	
	@Test
	public void impostaStanzaAdiacenteTest() {
		
		stanza1.impostaStanzaAdiacente("sud", stanza2);
		assertEquals(stanza1.getStanzaAdiacente("sud"), stanza2);
	}
	
	@Test
	public void impostaStanzaAdiacenteDoppiaTest() {
		
		stanza1.impostaStanzaAdiacente("est", stanza2);
		stanza1.impostaStanzaAdiacente("ovest", stanza3);
		
		assertTrue((stanza1.getStanzaAdiacente("est").equals(stanza2)) & (stanza1.getStanzaAdiacente("ovest").equals(stanza3)));
	}
	
	@Test
	public void addAttrezzoTest() {
		
		assertTrue(stanza1.addAttrezzo(attrezzo1));
		
	}
	
	@Test
	public void addAttrezzoSuperatoTest() {
		
		for (int i=0; i<10; i++) {
			
			stanza1.addAttrezzo(attrezzo1);
		}
		assertFalse(stanza1.addAttrezzo(attrezzo1));
	}
	
	@Test
	public void addAttrezzoNullTest() {
		
		stanza1.addAttrezzo(attrezzo1);
		assertEquals(stanza1.getAttrezzo("matita"), attrezzo1);
		
	}
	
	@Test
	public void hasAttrezzoTest() {
		
		stanza1.addAttrezzo(attrezzo1);
		assertTrue(stanza1.hasAttrezzo("matita"));
	}
	
	@Test
	public void hasAttrezzoNullTest() {
		
		assertFalse(stanza1.hasAttrezzo("matita"));
	}
	
	@Test
	public void hasAttrezzoDoppioTest() {
		
		stanza1.addAttrezzo(attrezzo1);
		stanza1.addAttrezzo(attrezzo2);
		
		assertTrue(stanza1.hasAttrezzo("matita") & stanza1.hasAttrezzo("penna"));
	}
	
	@Test
	public void removeAttrezzoCercatoPresenteTest() {
		
		stanza1.addAttrezzo(attrezzo1);
	
		assertTrue(stanza1.removeAttrezzo(attrezzo1));
	}
	
	@Test
	public void removeAttrezzoCercatoAssenteTest() {
		
		stanza1.addAttrezzo(attrezzo1);
		assertFalse(stanza1.removeAttrezzo(attrezzo2));
		
	}
	
	@Test
	public void removeAttrezzoCercatoStanzaSbagliataTest() {
		
		stanza1.addAttrezzo(attrezzo1);
		assertFalse(stanza2.removeAttrezzo(attrezzo1));
		
	}
	
	@Test
	public void removeAttrezzoNullTest() {
		
		assertFalse(stanza1.removeAttrezzo(attrezzo1));
	}
	
	@Test
	public void removeAttrezzoPrimoTest() {
		
		stanza1.addAttrezzo(attrezzo1);
		stanza1.addAttrezzo(attrezzo2);
		
		assertTrue(stanza1.removeAttrezzo(attrezzo1));
	}
	@Test
	public void removeAttrezzoSecondoTest() {
		
		stanza1.addAttrezzo(attrezzo2);
		stanza1.addAttrezzo(attrezzo1);
		
		assertTrue(stanza1.removeAttrezzo(attrezzo1));
	}
	
	@Test
	public void removeAttrezzoDoppioOrdinatoTest () {
		
		stanza1.addAttrezzo(attrezzo1);
		stanza1.addAttrezzo(attrezzo2);
		
		assertTrue(stanza1.removeAttrezzo(attrezzo1));
		assertTrue(stanza1.removeAttrezzo(attrezzo2));
	}
	
	@Test
	public void removeAttrezzoDoppioDisordinatoTest () {
		
		stanza1.addAttrezzo(attrezzo1);
		stanza1.addAttrezzo(attrezzo2);
		
		assertTrue(stanza1.removeAttrezzo(attrezzo2));
		assertTrue(stanza1.removeAttrezzo(attrezzo1));
	}
	
}
