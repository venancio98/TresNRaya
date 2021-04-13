package modelo;

public class Coordenada {
	private int x,y;

	public Coordenada(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	

	public Coordenada(String coorden) {
		super();
		String[] split = coorden.split(":");
		this.x=Integer.valueOf(split[0]);
		this.y=Integer.valueOf(split[1]);
	}
	
	public Coordenada(char[] coorden) {
		super();
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * 
	 * @return true si son contiguas
	 */
	public boolean isContigua(Coordenada antigua) {
		int x = this.x - antigua.getX(), y = this.y - antigua.getY();
		if (x > -2 && x < 2 && y > -2 && y < 2)
			return true;
		return false;

	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
}