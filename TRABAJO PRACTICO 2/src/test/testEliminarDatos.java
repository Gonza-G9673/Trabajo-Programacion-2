package test;
import modelo.Persona;
import interfaces.ICompDNI;
import interfaces.ICompNombre;
import interfaces.IArbol;
import modelo.Arbol;

public class testEliminarDatos {

    public static void main(String[] args) {

        // Acá armamos un array con varias personas para probar
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
                new Persona(17345436, "Valentín"),
                new Persona (47345654, "Fernando"),
                new Persona (22345324, "Bautista"),
                new Persona (19346274, "Salvador"),
                new Persona (69482762, "Lola"),
                new Persona (23387533, "Ricardo"),
                
        };
            
                
        ICompDNI cmpDni = new ICompDNI(); 

        ICompNombre cmpNombre = new ICompNombre();
        
        
        IArbol<Persona> ArbolDNI = new Arbol<>();
        IArbol<Persona> ArbolNombre = new Arbol<>();

        for (Persona p : personas) {
            ArbolDNI.insertar(p, cmpDni);
            ArbolNombre.insertar(p, cmpNombre);
        }
        // Eliminar una persona por DNI
        Persona personaAEliminar = new Persona(12345643, "Nicolás"); 
        System.out.println("Eliminando a " + personaAEliminar.getNombre() + " del árbol ordenado por DNI:");
        System.out.println("----------------------------");
        ArbolDNI.eliminar(personaAEliminar, cmpDni);
        System.out.println("Árbol Ordenado por DNI después de la eliminación:");
        System.out.println("----------------------------");
        ArbolDNI.recorridoInOrder();
        System.out.println("-------------------------------");
        // Eliminar una persona por Nombre
        Persona personaAEliminarPorNombre = new Persona(69482762, "Lola");
        System.out.println("Eliminando a " + personaAEliminarPorNombre.getNombre() + " del árbol ordenado por Nombre:");
        System.out.println("----------------------------");
        ArbolNombre.eliminar(personaAEliminarPorNombre, cmpNombre);
        System.out.println("Árbol Ordenado por Nombre después de la eliminación:");
        System.out.println("----------------------------");
        ArbolNombre.recorridoInOrder();
        System.out.println("------------------------------");
        // Buscar una persona después de la eliminación
        Persona personaBuscada = new Persona(12345643, "Nicolás");
        System.out.println("Buscando a " + personaBuscada.getNombre() + " en el árbol ordenado por DNI:");
        System.out.println("----------------------------");
        boolean encontradoDNI = ArbolDNI.buscar(personaBuscada, cmpDni);
        System.out.println("Encontrado: " + encontradoDNI);
        System.out.println("Buscando a " + personaBuscada.getNombre() + " en el árbol ordenado por Nombre:");
        System.out.println("----------------------------");
        boolean encontradoNombre = ArbolNombre.buscar(personaBuscada, cmpNombre);
        System.out.println("Encontrado: " + encontradoNombre);
        System.out.println("-----------------------------");

        //verificacion lola 
        Persona personaBuscadaLola = new Persona(69482762, "Lola");
        System.out.println("Buscando a " + personaBuscadaLola.getNombre() + " en el árbol ordenado por DNI:");
        System.out.println("----------------------------");
        boolean encontradoDniLola = ArbolDNI.buscar(personaBuscadaLola, cmpDni);
        System.out.println("Encontrado: " + encontradoDniLola);
        System.out.println("Buscando a " + personaBuscadaLola.getNombre() + " en el árbol ordenado por Nombre:");
        System.out.println("----------------------------");
        boolean encontradoNombreLola = ArbolNombre.buscar(personaBuscadaLola, cmpNombre);
        System.out.println("Encontrado: " + encontradoNombreLola);
        System.out.println("-----------------------------");
        
        // estado del árbol después de las eliminaciones
        System.out.println("Estado del árbol ordenado por DNI después de las eliminaciones:");
        System.out.println("----------------------------");
        ArbolDNI.recorridoInOrder();
        System.out.println("Estado del árbol ordenado por Nombre después de las eliminaciones:");
        System.out.println("----------------------------");
        ArbolNombre.recorridoInOrder();
        


    }
    }
