package vista;
import modelo.Contacto;

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
        System.out.println("3)Buscar Contacto");
        System.out.println("4)Actualizar Contacto");
        System.out.println("5)Mostrar todos los contactos");
        System.out.println("6)Modificar contactos");
        System.out.println("7)Espacio disponible");
        System.out.println("8)Salir");

        return scanner.nextInt();
    }

    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }

    public void mostrarContacto(Contacto contacto) {
        System.out.println("|||DATOS DE CONTACTO|||");
        System.out.println("Nombre: " + contacto.getNombre());
        System.out.println("Apellido: " + contacto.getApellido());
        System.out.println("Teléfono: " + contacto.getTelefono());
    }

    public void mostrarListaContactos(List<Contacto> contactos) {
        for(Contacto contacto: contactos) {
            System.out.println("Nombre: " + contacto.getNombre());
            System.out.println("Apellido: " + contacto.getApellido());
            System.out.println("Teléfono: : " + contacto.getTelefono());
        }
    }

    public String[]  pedirDatosContacto(){

        String[] datos = new String[3];

        System.out.println("Ingrese el nombre: ");
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
        String nombre = scanner.nextLine();
        return nombre;
    }

    public String pedirApellidoContacto(){
        System.out.println("Ingrese el apellido: ");
        String apellido = scanner.nextLine();
        return apellido;
    }

    public String pedirNumeroContacto(){
        System.out.println("Ingrese el teléfono: ");
        String telefono = scanner.nextLine();
        return telefono;
    }


}
