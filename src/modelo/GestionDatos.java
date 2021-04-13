package modelo;

import utiles.RespuestaColocacion;

public class GestionDatos {
	private Tablero tablero;
	private Juego juego;
	private Coordenada antigua = null;

	public GestionDatos() {
		super();
		tablero = new Tablero();
		juego = new Juego();
	}

	public RespuestaColocacion realizarJugada(Coordenada coordenada) {
		RespuestaColocacion respuesta = new RespuestaColocacion();
		// A partir de la septima jugada
		if (juego.isMover()) {
			if (tablero.borrarCasilla(coordenada, this.juego.getTurnoActual())) {
				this.juego.setMover(false);
				antigua = coordenada;
				respuesta = new RespuestaColocacion(true, "", tablero.getPosicion(coordenada));
			} else {
				respuesta = new RespuestaColocacion(false, "esa casilla no es tuya", tablero.getPosicion(coordenada));
			}
			// luego hay que colocar en un casilla libre contigua
		} else if (juego.isJugadaMovimiento()) {
			respuesta = colocarFicha(coordenada, antigua);
		} else {
			respuesta = colocarFicha(coordenada);
		}
		if(tablero.isLinea()) {
			respuesta.setFinJuego(true);
			respuesta.setMensaje("Juego finalizado. El ganador es el "+this.juego.getTurnoAnteriorName());
		}
		return respuesta;
	}

	private RespuestaColocacion colocarFicha(Coordenada coordenada, Coordenada antigua) {
		if (coordenada.isContigua(antigua)) {
			return colocarFicha(coordenada);
		}
		return new RespuestaColocacion(false, "no es contigua", tablero.getPosicion(coordenada));
	}

	private RespuestaColocacion colocarFicha(Coordenada coordenada) {
		boolean colocada = this.tablero.colocarFicha(coordenada, this.juego.getTurnoActual());
		if (colocada) {
			this.juego.incrementaJugada();
			return new RespuestaColocacion(true, "", tablero.getPosicion(coordenada));
		}
		return new RespuestaColocacion(false, "no esta vacia", tablero.getPosicion(coordenada));
	}

	public String getTipoActualName() {
		return this.juego.getTurnoActualName();
	}

	public String getTipoAnteriorName() {
		return this.juego.getTurnoAnteriorName();
	}

//	public RespuestaColocacion getErrorActualName() {
//		return this.tablero.getErrorActual();
//	}
//	
}
