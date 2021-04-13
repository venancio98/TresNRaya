package modelo;

public enum Tipo {
	X("X"),O("O"), blanco("");
	private String nombre;

	private Tipo(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	
}
