package modelo;

public class Juego {
	private int cantidadJugadores = 2;
	private int cantidadFichas = 3;
	private int numeroJugada = 1;
	private boolean mover=false;
	

	public boolean isJugadaMovimiento() {
		return numeroJugada>6;
	}
	public String getTurnoActualName() {
		// si es impar le toca a X
		return getTurnoActual().getNombre();
	}

	public Tipo getTurnoActual() {
		if (numeroJugada % 2 == 0) {
			return Tipo.O;
		}
		return Tipo.X;
	}

	public void incrementaJugada() {
		this.numeroJugada++;
		if(this.numeroJugada>6) {
			this.setMover(true);
		}
		

	}
//	public String getTurnoAnteriorName() {
//		if(getTurnoActual()==Tipo.X) {
//			return Tipo.O.getNombre();
//		}
//		return Tipo.X.getNombre();
//	}

	public Tipo getTurnoAnterior() {
		if(getTurnoActual()==Tipo.X) {
			return Tipo.O;
		}
		return Tipo.X;
	}
	
	public String getTurnoAnteriorName() {
		return getTurnoAnterior().getNombre();
	}

	public boolean isMover() {
		return this.mover;
	}

	public void setMover(boolean b) {
		this.mover=b;
		
	}
	
}