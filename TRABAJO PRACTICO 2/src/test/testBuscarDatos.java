package test;
import modelo.Persona;
import interfaces.ICompDNI;
import interfaces.ICompNombre;
import interfaces.IArbol;
import modelo.Arbol;


public class testBuscarDatos {

    public static void main(String[] args) {

        Persona[] personas = {

                new Persona(47123321, "Pilar"),
                new Persona(20122234, "Agostina"),
                new Persona(46123456, "Gonzalo"),
                new Persona(47865123, "Juan"),
                new Persona(24123321, "Victoria"),
                new Persona(12345643, "Nicolás"),
                new Persona(54345322, "Carlos"),
                new Persona(23454326, "Joaquin"),
                new Persona(12334322, "Esteban"),
                new Persona(17345436, "Valentín"),
                new Persona(47345654, "Fernando"),
                new Persona(22345324, "Bautista"),
                new Persona(19346274, "Salvador"),
                new Persona(69482762, "Lola"),
                new Persona(23387533, "Ricardo"),

        };

        ICompDNI cmpDni = new ICompDNI();
        ICompNombre cmpNombre = new ICompNombre();
        IArbol<Persona> ArbolDNI = new Arbol<>();
        IArbol<Persona> ArbolNombre = new Arbol<>();

        for (Persona p : personas) {
            ArbolDNI.insertar(p, cmpDni);
            ArbolNombre.insertar(p, cmpNombre);
        }

        System.out.println("Buscar por DNI 12345643: ");
        System.out.println("Resultado: " + ArbolDNI.buscar(new Persona(12345643, ""), cmpDni)); 
        System.out.println("Buscar por Nombre 'Agostina': ");
        System.out.println("Resultado: " + ArbolNombre.buscar(new Persona(0, "Agostina"), cmpNombre)); 

        System.out.println("Buscar por DNI 99999999 (no esta insertado): ");
        boolean encontradoDNI = ArbolDNI.buscar(new Persona(99999999, ""), cmpDni); // Cambié a boolean para reflejar si se encontró o no
        System.out.println("Resultado: " + (encontradoDNI ? "Persona encontrada" : "Persona no encontrada")); // el ? es un operador ternario que evalúa si se encontró o no

        System.out.println("Buscar por Nombre inexistente: ");
        boolean encontradoNombre = ArbolNombre.buscar(new Persona(0, "Inexistente"), cmpNombre); // Cambié a boolean para reflejar si se encontró o no
        System.out.println("Resultado: " + (encontradoNombre ? "Persona encontrada" : "Persona no encontrada")); 

    }

}
