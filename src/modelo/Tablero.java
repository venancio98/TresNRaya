package modelo;

import utiles.RespuestaColocacion;

public class Tablero {

	private int dimension = 3;
	private Tipo matriz[][] = new Tipo[dimension][dimension];
	private String errorActual = "";

	public Tipo getValorCasilla(int x, int y) {
		return matriz[x][y];
	}

	public Tablero() {
		super();
		inicializarMatriz();
	}

	private void inicializarMatriz() {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = Tipo.blanco;
			}
		}
	}

	public boolean limpiarCasilla(Coordenada coordenada) {
		if (getPosicion(coordenada) != Tipo.blanco) {
			setPosicion(coordenada, Tipo.blanco);
			return true;
		}
		return false;
	}

	private void setPosicion(Coordenada coordenada, Tipo blanco) {
		matriz[coordenada.getX()][coordenada.getY()] = blanco;

	}

	public boolean borrarCasilla(Coordenada coordenada, Tipo tipo) {
		// primero hay que borrar una casilla no bloqueada de tu turno
		if (isPropiedad(coordenada, tipo) && !comprobarCasillaBloqueada(coordenada)) {
			limpiarCasilla(coordenada);
			return true;
		}
		return false;
	}

	public boolean colocarFicha(Coordenada coordenada, Tipo tipoActual) {
		
		if (matriz[coordenada.getX()][coordenada.getY()] == Tipo.blanco) {
			matriz[coordenada.getX()][coordenada.getY()] = tipoActual;
//			System.out.println("coordenada puesta");
			return true;
		}
		return false;
	}

	public Tipo getPosicion(Coordenada coordenada) {
		return matriz[coordenada.getX()][coordenada.getY()];
	}

	private boolean isLibre(Coordenada coordenada) {
		return getPosicion(coordenada) == Tipo.blanco;
	}

	/**
	 * 
	 * @param coordenada
	 * @return false si encuentra una libre y true en caso contrario
	 */
	public boolean comprobarCasillaBloqueada(Coordenada coordenada) {
		for (int x = coordenada.getX() - 1; x <= coordenada.getX() + 1; x++)
			for (int y = coordenada.getY() - 1; y <= coordenada.getY() + 1; y++)
				if (x >= 0 && x < this.dimension && y >= 0 && y < this.dimension)
					if (this.isLibre(new Coordenada(x, y)))
						return false;
		return true;
	}

	public String getErrorActual() {
		return this.errorActual;
	}

	public boolean isPropiedad(Coordenada coordenada, Tipo tipo) {
		return getPosicion(coordenada) == tipo;
	}

	public boolean isLinea() {
		return comprobarHorizontal()||comprobarVertical()||comprobarDiagonal();
	}
	

	private boolean comprobarDiagonal() {
		boolean respuesta = true;
		for (int diagonalDerecha = 0; diagonalDerecha < matriz.length-1 && respuesta; diagonalDerecha++) {
			if (matriz[diagonalDerecha][diagonalDerecha] == Tipo.blanco || matriz[diagonalDerecha][diagonalDerecha] != matriz[diagonalDerecha+1][diagonalDerecha+1]) {
				respuesta = false;
			}
		}
		if(respuesta) {
			return true;
		}
		respuesta = true;
		int tamanoTablero = matriz.length-1; 
		for (int columna = tamanoTablero; columna > 0 && respuesta; columna--) {
			int fila = tamanoTablero-columna; 
			if(matriz[fila][columna]==Tipo.blanco||matriz[fila][columna] != matriz[fila+1][columna-1] ) {
				respuesta = false;
			}
		}
		return respuesta;
	}

	public boolean comprobarVertical() {
		boolean respuesta = false;
		for (int columna = 0; columna < matriz.length && !respuesta; columna++) {
			boolean valido = true;
			for (int fila = 0; fila < matriz.length - 1 && valido; fila++) {

				if (matriz[fila][columna] == Tipo.blanco || matriz[fila][columna] != matriz[fila + 1][columna]) {
					valido = false;
				}
			}
			if (valido) {
				respuesta = true;
			}
		}
		return respuesta;
	}

	public boolean comprobarHorizontal() {
		boolean resultado = false;
		for (int i = 0; i < matriz.length && !resultado; i++) {
			resultado = comprobarFila(matriz[i]);
		}
		return resultado;
	}

	public boolean comprobarFila(Tipo[] vector) {
		boolean encontrado = true;
		for (int j = 0; j < vector.length - 1; j++) {
			if (vector[j]!=Tipo.blanco&&vector[j] == vector[j + 1]) {
				encontrado = true;
			} else {
				return false;
			}
		}
		return encontrado;
	}
	

}