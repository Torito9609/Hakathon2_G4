package modelo;

public class Contacto {
    private String nombre;
    private String apellido;
    private String telefono;

    public Contacto(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = "0000000";
    }
    //cosntructor con validacion de campos vacios
    public Contacto(String nombre, String apellido, String telefono) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido no puede estar vacío");
        }
        if (telefono == null || telefono.trim().isEmpty()) {
            throw new IllegalArgumentException("El teléfono no puede estar vacío");
        }

        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    //Para sobrescribir el metodo equal que pertenece a la clase base object
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

    //casteo
        Contacto contacto = (Contacto) obj;

        // Comparación de nombre y apellido ignorando mayúsculas y minúsculas
        return this.nombre.equalsIgnoreCase(contacto.nombre) &&
                this.apellido.equalsIgnoreCase(contacto.apellido);
    }

    //Sobre carga del método toString de la clase abstracta Object.
    @Override
    public String toString(){
        return("Nombre: " + getNombre() + "\n" +
                "Apellido: " + getApellido() + "\n" +
                "Telefono: " + getTelefono());
    }
    //getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
