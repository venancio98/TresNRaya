package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Coordenada;

class CoordenadaTest {

	@Test
	void testIsContigua() {
		Coordenada origen=new Coordenada(0, 2);
		Coordenada destinoUno=new Coordenada(1, 2);
		Coordenada destinoDos=new Coordenada(0, 0);
		assertTrue(origen.isContigua(destinoUno));
		assertFalse(origen.isContigua(destinoDos));
	}

}
