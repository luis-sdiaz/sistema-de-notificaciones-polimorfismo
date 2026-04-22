package notificaciones.dominio;

public class Usuario {
    private String id;
    private String nombre;
    private String email;
    private String telefono;
    private String tokenApp;

    public Usuario() {
    }

    public Usuario(String id, String nombre, String email, String telefono, String tokenApp) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.tokenApp = tokenApp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTokenApp() {
        return tokenApp;
    }

    public void setTokenApp(String tokenApp) {
        this.tokenApp = tokenApp;
    }

    @Override
    public String toString() {
        return "Usuario {\n" +
                "  id: " + id + "\n" +
                "  nombre: " + nombre + "\n" +
                "  email: " + email + "\n" +
                "  telefono: " + telefono + "\n" +
                "  tokenApp: " + tokenApp + "\n" +
                "}";
    }
}