import controlador.Controlador;
import modelo.Agenda;
import vista.Vista;

public class AppMain {
    public static void main(String[] args) {
        Vista vista = new Vista();
        int opcionAgenda = vista.pedirOpcionAgenda();
        switch (opcionAgenda){
            case 1:
                Agenda agenda = new Agenda();
                Controlador controlador = new Controlador(vista, agenda);
                controlador.ejecutar();
                break;

            case 2:
                int espacioAgenda = vista.pedirEspacioAgenda();
                Agenda agenda2 = new Agenda(espacioAgenda);
                Controlador controlador2 = new Controlador(vista, agenda2);
                controlador2.ejecutar();
                break;

            default:
                System.out.println("Ingrese una opción válida.");
        }
    }
}
