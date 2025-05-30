package interfaces;

public interface IPersona { 
	
	// Pre: La persona está inicializada y tiene un DNI válido.
	// Post: Devuelve el DNI de la persona.
	public int getDni(); // Método para obtener el DNI de la persona
	
	// Pre: La persona está inicializada y tiene un nombre válido.
	// Post: Devuelve el nombre de la persona.
	public String getNombre(); // Método para obtener el nombre de la persona
	
	// Pre: La persona está inicializada.
	// Post: Establece el nombre de la persona.
	public void setNombre(String nombre); // Método para establecer el nombre de la persona

	// Pre: La persona está inicializada.
	// Post: Establece el DNI de la persona.
	public void setdni(int dni); // Método para establecer el DNI de la persona


}
