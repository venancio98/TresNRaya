package modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import utiles.RespuestaColocacion;

class GestionDatosTest {

	@Test
	void testRealizarJugadaApartirDeLaSeptima() {
		GestionDatos gestion=new GestionDatos();
		//Emular las seis primeras jugadas
		int posX[] = {0,0,1,1,2,2};
		int posY[] = {1,2,2,1,0,1};
		for (int i = 0; i < posX.length; i++) {
			gestion.realizarJugada(new Coordenada(posX[i],posY[i]));
		}
		//Ahora que hago
		//primera parte donde borramos una ficha no bloqueada del turno
		RespuestaColocacion realizarJugada = gestion.realizarJugada(new Coordenada(1,1));
		assertFalse(realizarJugada.isRespuesta());
		realizarJugada = gestion.realizarJugada(new Coordenada(0,1));
		assertTrue(realizarJugada.isRespuesta());
		//ahora la vamos a poner en una posicion contigua
		RespuestaColocacion realizarJugada2 = gestion.realizarJugada(new Coordenada(0,0));
		assertTrue(realizarJugada2.isRespuesta());
	}

}
