package vista;
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
        System.out.println("Nombre: " + contacto.nombre);
        System.out.println("Apellido: " + contacto.apellido);
        System.out.println("Teléfono: " + contacto.telefono);
    }

    public void mostrarListaContactos(List<Contacto> contactos) {
        for(Contacto : contacto) {
            
        }
    }

}
