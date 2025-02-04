package vista;
import java.util.Scanner;
public class Vista {
    Scanner sc;
    public Vista(){
        this.sc = new Scanner(System.in);
    }

    public int mostrarMenuPrincipal(){
        System.out.println("BIENVENIDO A LA AGENDA TELEFONICA");
        System.out.println("Por favor, ingrese una opción: ");
        System.out.println("1. Añadir un nuevo contacto.");
        System.out.println("2. Eliminar un contacto.");
        System.out.println("3. Modificar el número de un contacto.");
        System.out.println("4. Buscar contacto por nombre y apellido.");
        System.out.println("5. Listar los contactos existentes.");
        System.out.println("6. Consultar si la agenda está llena.");
        return sc.nextInt();
    }

    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }

    public String[] pedirDatosContacto(){
        System.out.println("Ingrese el nombre del contacto: ");
        sc.nextLine();
        String nombre = sc.nextLine();

        System.out.println("Ingrese el apellido del contacto: ");
        String apellido = sc.nextLine();

        System.out.println("Ingrese el numero de telefono: ");
        String numero = sc.nextLine();

        return new String[] {nombre, apellido, numero};
    }

    public String pedirNombreContacto(){
        System.out.println("Ingrese el nombre del contacto: ");
        return sc.nextLine();
    }

    public String pedirApellidoContacto(){
        System.out.println("Ingrese el apellido del contacto: ");
        return sc.nextLine();
    }

    public String pedirNumeroContacto(){
        System.out.println("Ingrese el número: ");
        return sc.nextLine();
    }

}
