import controlador.Controlador;
import modelo.Agenda;
import vista.Vista;

public class AppMain {
    public static void main(String[] args) {
        Vista vista = new Vista(); // Se instancia una nueva vista.
        int opcionAgenda = vista.pedirOpcionAgenda(); // Pedimos que tipo de agenda quiere el usuario
        switch (opcionAgenda){
            case 1:
                Agenda agenda = new Agenda(); // se intancia con el controlador por defecto
                Controlador controlador = new Controlador(vista, agenda); // Se instancia el controlador
                controlador.ejecutar(); // Se ejecita el programa
                break;

            case 2:
                int espacioAgenda = vista.pedirEspacioAgenda(); // Se le pide al usuario cuántos espacios quiere en la agenda
                Agenda agenda2 = new Agenda(espacioAgenda); // Se usa el constructor con espacios
                Controlador controlador2 = new Controlador(vista, agenda2); // Se instancia el controlador
                controlador2.ejecutar(); // Se ejecuta el programa
                break;

            default:
                System.out.println("Ingrese una opción válida.");
        }
    }
}
