package modelo;

import interfaces.IPersona; // Interfaz que define los métodos para manejar una persona

public class Persona implements IPersona { // Clase que implementa la interfaz IPersona para representar una persona con nombre y DNI
	private String nombre; 
	private int dni;
	
	public Persona (int dni, String nombre) { // Constructor que inicializa una persona con un nombre y un DNI
		this.nombre = nombre; // Asignamos el nombre recibido al atributo nombre de la persona
		this.dni = dni; // Asignamos el DNI recibido al atributo dni de la persona
	}
	
	@Override
	public String getNombre() { // Método que devuelve el nombre de la persona
		return nombre;
	}
	@Override
	public void setNombre(String nombre) { // Método que establece el nombre de la persona
		this.nombre = nombre;
	}
	@Override
	public int getDni() { // Método que devuelve el DNI de la persona
		return dni;
	}
	@Override
	public void setdni(int dni) { // Método que establece el DNI de la persona
		this.dni = dni;
		}
		
	@Override
	public String toString() {
		return "Persona: Nombre:" + nombre + ", DNI:" + dni;
}

	
}


