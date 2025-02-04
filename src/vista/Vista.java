package vista;
import modelo.Contacto;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.List;
import java.util.Scanner;
public class Vista {

    private Scanner scanner;

    public Vista (){
        this.scanner = new Scanner(System.in);
    }

    public int mostrarMenuPrincipal() {

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

    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
        //scanner.nextLine();
    }

    public void mostrarContacto(Contacto contacto) {
        System.out.println("|||DATOS DE CONTACTO|||");
        System.out.println(contacto.toString());

    }

    public void mostrarListaContactos(List<Contacto> contactos) {
        int contador = 1;
        for(Contacto contacto: contactos) {
            System.out.println(contador + " - ");
            System.out.println(contacto.toString());
            contador++;
        }
    }

    public String[]  pedirDatosContacto(){

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

    public String pedirNombreContacto(){
        System.out.println("Ingrese el nombre: ");
        scanner.nextLine();
        String nombre = scanner.nextLine();
        return nombre;
    }

    public String pedirApellidoContacto(){
        System.out.println("Ingrese el apellido: ");
        //scanner.nextLine();
        String apellido = scanner.nextLine();
        return apellido;
    }

    public String pedirNumeroContacto(){
        System.out.println("Ingrese el teléfono: ");
        //scanner.nextLine();
        String telefono = scanner.nextLine();
        return telefono;
    }

    public int pedirOpcionAgenda(){
        System.out.println("*****BIENVENIDO AL SISTEMA DE GESTIÓN DE AGENDA*****");
        System.out.println("Para empezar, debemos crear una nueva agenda");
        System.out.println("1. Agenda por defecto (Solo tendrás 10 espacios disponibles)");
        System.out.println("2. Ingresar la cantidad de espacios disponibles deseada.");
        return scanner.nextInt();
    }

    public int pedirEspacioAgenda(){
        System.out.println("Ingrese la cantidad de espacios que quiere para la agenda: ");
        return scanner.nextInt();
    }


}
