package vista;
import modelo.Contacto;
import java.util.List;
import java.util.Scanner;
public class Vista {

    private Scanner scanner; // Atributo de tipo Scanner

    public Vista (){
        this.scanner = new Scanner(System.in); // Se instancia un nuevo scanner dentro del constructor de la clase
    }

    public int mostrarMenuPrincipal() { // Función para mostrar el menú principal y capturar la entrade del usuario

        System.out.println("|||||MENÚ PRINCIPAL DE AGENDA DE CONTACTOS|||||");
        System.out.println("Porfavor elija una opción: ");
        System.out.println("1)Agregar Contacto");
        System.out.println("2)Eliminar Contacto");
        System.out.println("3)Editar teléfono de un Contacto");
        System.out.println("4)Buscar Contacto por nombre apellido");
        System.out.println("5)Mostrar todos los contactos");
        System.out.println("6)Verificar espacio disponible en la agenda");
        System.out.println("7)Salir");

        return scanner.nextInt();
    }

    public void mostrarMensaje(String mensaje){ // Función para mostrar cualquier mensaje por consola
        System.out.println(mensaje);
        //scanner.nextLine();
    }

    public void mostrarContacto(Contacto contacto) { // Función para mostrar un contacto
        System.out.println("|||DATOS DE CONTACTO|||");
        System.out.println(contacto.toString());

    }

    public void mostrarListaContactos(List<Contacto> contactos) { // Función para listar los contactos de la agenda
        int contador = 1;
        for(Contacto contacto: contactos) {
            System.out.println(contador + " - ");
            System.out.println(contacto.toString());
            contador++;
        }
    }

    public String[]  pedirDatosContacto(){ // Función para pedir los datos del contacto que se quiere guardar

        String[] datos = new String[3];

        System.out.println("Ingrese el nombre: ");
        scanner.nextLine();
        String nombre = scanner.nextLine();
        datos[0] = nombre;
        System.out.println("Ingrese el apellido: ");
        String apellido = scanner.nextLine();
        datos[1] = apellido;
        System.out.println("Ingrese el número de telefono: ");
        String telefono = scanner.nextLine();
        datos[2] = telefono;

        return datos;
    }

    public String pedirNombreContacto(){ // Función para pedir solo el nombre del contacto
        System.out.println("Ingrese el nombre: ");
        scanner.nextLine();
        String nombre = scanner.nextLine();
        return nombre;
    }

    public String pedirApellidoContacto(){ // Función para pedir solo el apellido
        System.out.println("Ingrese el apellido: ");
        //scanner.nextLine();
        String apellido = scanner.nextLine();
        return apellido;
    }

    public String pedirNumeroContacto(){ // Función para pedir solo el número
        System.out.println("Ingrese el teléfono: ");
        //scanner.nextLine();
        String telefono = scanner.nextLine();
        return telefono;
    }

    public int pedirOpcionAgenda(){ // Función para saber que tipo de agenda quiere el usuario
        System.out.println("*****BIENVENIDO AL SISTEMA DE GESTIÓN DE AGENDA*****");
        System.out.println("Para empezar, debemos crear una nueva agenda");
        System.out.println("1. Agenda por defecto (Solo tendrás 10 espacios disponibles)");
        System.out.println("2. Ingresar la cantidad de espacios disponibles deseada.");
        return scanner.nextInt();
    }

    public int pedirEspacioAgenda(){ // Función para pedir el espacio que el usuario quiere en la agenda.
        System.out.println("Ingrese la cantidad de espacios que quiere para la agenda: ");
        return scanner.nextInt();
    }


}
