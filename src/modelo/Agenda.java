package modelo;
import java.util.*;

public class Agenda {
    private static final int TAMANIO_POR_DEFECTO = 10;
    private int maxContactos;
    private List<Contacto> contactos;

    public Agenda() {
        this(TAMANIO_POR_DEFECTO);
    }

    public Agenda(int maxContactos) {
        this.maxContactos = maxContactos;
        this.contactos = new ArrayList<>();
    }

    public boolean añadirContacto(Contacto c) {
        if (agendaLlena()) return false;

        for (Contacto contacto : contactos) {
            if (contacto.equals(c)) {
                return false;
            }
        }

        contactos.add(c);
        return true;
    }

    public boolean existeContacto(Contacto c) {
        for (Contacto contacto : contactos) {
            if (contacto.equals(c)) {
                return true;
            }
        }
        return false;
    }

    public List<Contacto> listarContactos() {
        List<Contacto> ordenados = new ArrayList<>(contactos);
        ordenados.sort(Comparator.comparing(Contacto::getNombre).thenComparing(Contacto::getApellido));
        return ordenados;
    }

    public void buscarContacto(String nombre, String apellido) {
        for (Contacto c : contactos) {
            if (c.getNombre().equals(nombre) && c.getApellido().equals(apellido)) {
                System.out.println("Teléfono de " + nombre + " " + apellido + ": " + c.getTelefono());
                return;
            }
        }
        System.out.println("Contacto no encontrado.");
    }

    public boolean eliminarContacto(Contacto c) {
        if (contactos.remove(c)) {
            return true;
        }
        return false;
    }

    public boolean modificarTelefono(String nombre, String apellido, String nuevoTelefono) {
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
    }

    public int espacioLibre() {
        return maxContactos - contactos.size();
    }
}
