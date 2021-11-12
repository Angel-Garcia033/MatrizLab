package modelo;

public class Matriz 
{
	private boolean[][] Matriz;
	
	//==========================================================================
	
	public boolean[][] getMatriz() {
		return Matriz;
	}

	public void setMatriz(boolean[][] matriz) {
		Matriz = matriz;
	}

	//==========================================================================

	public void crearMatriz (int Tamano)
	{
		Matriz = new boolean[Tamano][Tamano];
	}
}