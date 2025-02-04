package modelo;
import java.util.*;

public class Agenda {
    private static final int TAMANIO_POR_DEFECTO = 10;
    private int maxContactos;
    private List<Contacto> contactos;

    public Agenda() {
        this(TAMANIO_POR_DEFECTO);
    } //Constructor agenda por defecto

    public Agenda(int maxContactos) { // Constructor agenda para un espacio dado por el usuario
        this.maxContactos = maxContactos;
        this.contactos = new ArrayList<>();
    }

    public boolean añadirContacto(Contacto c) { // Método para añadir contacto
        if (agendaLlena()) return false;

        for (Contacto contacto : contactos) {
            if (contacto.equals(c)) {
                return false;
            }
        }

        contactos.add(c);
        return true;
    }

    public boolean existeContacto(Contacto c) { // Método para verificar contacto existente
        for (Contacto contacto : contactos) {
            if (contacto.equals(c)) {
                return true;
            }
        }
        return false;
    }

    public List<Contacto> listarContactos() { // Método para retornar una lista ordenada alfabéticamente de los contactos
        List<Contacto> ordenados = new ArrayList<>(contactos);
        ordenados.sort(Comparator.comparing(Contacto::getNombre).thenComparing(Contacto::getApellido));
        return ordenados;
    }

    public Contacto buscarContacto(String nombre, String apellido) { // Método para buscar un contacto por nombre y apellido
        for (Contacto c : contactos) {
            if (c.getNombre().equals(nombre) && c.getApellido().equals(apellido)) {
                return c;
            }
        }
        return null;

    }

    public boolean eliminarContacto(Contacto c) { // Método para eliminar un contacto
        if (contactos.remove(c)) {
            return true;
        }
        return false;
    }

    public boolean modificarTelefono(String nombre, String apellido, String nuevoTelefono) { // Método para modificar el teléfono de un contacto dado el nombre y apellido
        for (Contacto c : contactos) {
            if (c.getNombre().equals(nombre) && c.getApellido().equals(apellido)) {
                c.setTelefono(nuevoTelefono);
                return true;
            }
        }
        return false;
    }

    public boolean agendaLlena() {
        return contactos.size() >= maxContactos;
    } // Retorna si la agenda está llena

    public int espacioLibre() {
        return maxContactos - contactos.size();
    } // Retorna la cantidad de espacios libres en la agenda
}
