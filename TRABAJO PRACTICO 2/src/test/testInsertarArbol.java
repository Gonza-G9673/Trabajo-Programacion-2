package test;

import modelo.Persona;
import interfaces.ICompDNI;
import interfaces.ICompNombre;
import interfaces.IArbol;
import modelo.Arbol;



public class testInsertarArbol {
    public static void main(String[] args) {
        
		Persona [] personas = {
		
				new Persona (47123321, "Pilar"),
				new Persona (20122234, "Agostina"),
				new Persona (46123456, "Gonzalo"),
				new Persona (47865123, "Juan"),
				new Persona (24123321, "Victoria"),
				new Persona (12345643, "Nicolás"),
				new Persona (54345322, "Carlos"),
				new Persona (23454326, "Joaquin"),
				new Persona (12334322, "Esteban"),
				new Persona (17345436, "Valentín"),
				new Persona (47345654, "Fernando"),
				new Persona (22345324, "Bautista"),
				new Persona (19346274, "Salvador"),
				new Persona (69482762, "Lola"),
				new Persona (23387533, "Ricardo"),
				
		};
        //Para testear que se haya insertado correctamente el árbol muestro el recorrido en preorden ya que
        //es el orden en que se insertan los elementos.
        ICompDNI cmpDni = new ICompDNI(); // Comparador de DNI para el árbol ordenado por DNI
        ICompNombre cmpNombre = new ICompNombre(); // Comparador de Nombre para el árbol ordenado por Nombre
        IArbol<Persona> ArbolDNI = new Arbol<>(); // Árbol ordenado por DNI
        IArbol<Persona> ArbolNombre = new Arbol<>(); // Árbol ordenado por Nombre

        for (Persona p : personas) { // Recorro el array de personas y las inserto en los árboles
            ArbolDNI.insertar(p, cmpDni); // Inserto en el árbol ordenado por DNI
            ArbolNombre.insertar(p, cmpNombre); // Inserto en el árbol ordenado por Nombre
        }


        System.out.println("Los elementos fueron insertados en este orden: ");
        System.out.println("---------------------------------");
        System.out.println("En nombres fueron insertados: ");
        for (Persona p : personas) {
            System.out.print(p.getNombre() + " ");
        }
        System.out.println("----------------------------------");
        System.out.println("\nEn DNI fueron insertados: ");
        for (Persona p : personas) {
            System.out.print(p.getDni() + " ");
        }

        System.out.println("Árbol Ordenado por Nombre insertados: ");
        System.out.println("---------------------------------");
        ArbolNombre.recorridoPreOrder(); // Recorrido en preorden del árbol ordenado por Nombre
        


        System.out.println("Árbol Ordenado por DNI insertados: ");
        System.out.println("---------------------------------");
        ArbolDNI.recorridoPreOrder(); // Recorrido en preorden del árbol ordenado por DNI
        

       
        
    }
}
