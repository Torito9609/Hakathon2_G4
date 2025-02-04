package controlador;
import modelo.Agenda;
import modelo.Contacto;

public class Controlador {
    private Vista vista;
    private Agenda agenda;

    public Controlador(Vista vista, Agenda agenda){
        this.vista = vista;
        this.agenda = agenda;
    }

    public void ejecutar(){
        boolean salir = false;

        while (!salir) {
            int opcion = vista.mostrarMenuYObtenerOpcion();

            switch (opcion) {
                case 1:
                    manejarAnadirContacto();
                    break;
                case 2:
                    manejarEliminarContacto();
                    break;
                case 3:
                    manejarModificarTelefono();
                    break;
                case 4:
                    manejarBuscarContacto();
                    break;
                case 5:
                    manejarListarContactos();
                    break;
                case 6:
                    manejarAgendaLlena_EspaciosLibres();
                    break;
                case 7:
                    salir = true;
                    vista.mostrarMensaje("Saliendo de la agenda...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida. Intente de nuevo.");
            }
        }
    }

    public void manejarAnadirContacto() {
        String[] datos = vista.pedirDatosContacto();

        Contacto nuevoContacto = new Contacto(datos[0], datos[1], datos[2]);

        if (agenda.estaLlena()) {
            vista.mostrarMensaje("La agenda está llena. No se puede agregar más contactos.");
            return;
        }

        if (agenda.existeContacto(nuevoContacto)) {
            vista.mostrarMensaje("El contacto ya existe en la agenda. No se puede agregar un duplicado.");
            return;
        }

        boolean exito = agenda.añadirContacto(nuevoContacto);

        if (exito) {
            vista.mostrarMensaje("Contacto añadido con éxito.");
        } else {
            vista.mostrarMensaje("No se pudo añadir el contacto por una razón desconocida.");
        }
    }

    public void manejarEliminarContacto(){
        String[] datos = vista.pedirDatosContacto();

        Contacto contactoAEliminar = new Contacto(datos[0], datos[1], datos[2]);

        if(!agenda.existeContacto(contactoAEliminar)){
            vista.mostrarMensaje("El contacto no existe en la agenda y no se puede eliminar.");
        }

        boolean exito = agenda.eliminarContacto(contactoAEliminar);

        if (exito){
            vista.mostrarMensaje("Contacto eliminado con éxito.");
        } else{
            vista.mostrarMensaje("El contacto no se puede eliminar por una razón descnocida.");
        }

    }

    public void manejarModificarTelefono(){
        String nombre = vista.pedirNombreContacto();
        String apellido = vista.pedirApellidoContacto();

        Contacto contactoExistente = agenda.modificarTelefono(nombre, apellido, nuevoNumero);

        if(contactoExistente == null){
            vista.mostrarMensaje("No se encontró un contacto con ese nombre o apellido.");
            return;
        }

        String nuevoNumero = vista.pedirNumeroContacto();

        boolean exito = agenda.modificarNumero(contactoExistente, nuevoNumero);

        if(exito){
            vista.mostrarMensaje("Número modificado con éxito.");
        } else{
            vista.mostrarMensaje("No se pudo modificar el número.");
        }
    }

    public void manejarBuscarContacto(){
        String nombre = vista.pedirNombreContacto();
        String apellido = vista.pedirApellidoCOntacto();

        Contacto contactoAMostrar = agenda.buscarContacto(nombre, apellido);

        if(contactoAMostrar == null){
            vista.mostrarMensaje("No se encontró ningún contacto con ese nombre.");
        }else{
            vista.mostrarContacto(contactoAMostrar);
        }
    }

    public void manejarListarContactos(){
        List<Contacto> listaContactos = agenda.listarContactos();

        if(listaContactos.isEmpty()){
            vista.mostrarMensaje("No hay contactos en la agenda.");
            return;
        }
        for(Contacto contacto: listaContactos){
            vista.mostrarContacto(contacto);
        }
    }

    public void manejarAgendaLlena_EspaciosLibres(){
        boolean agendaEstaLlena = agenda.agendaLlena();
        int espaciosLibres = agenda.espacioLibre();

        if(agendaEstaLlena){
            vista.mostrarMensaje("La agenda se encuentra completamente llena.");
        }else{
            vista.mostrarMensaje("La agenda no esta llena. Tienes " + espaciosLibres + " Espacios libres.");
        }
    }
}
