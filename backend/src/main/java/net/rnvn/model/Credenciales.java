package net.rnvn.model;

public class Credenciales {
    private String identificacion;
    private String password;

    public Credenciales(String identificacion, String password) {
        this.identificacion = identificacion;
        this.password = password;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getPassword() {
        return password;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "{" +
                " identificacion='" + getIdentificacion() + "'" +
                ", password='" + getPassword() + "'" +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (o == this)
            return true;
        if (!(o instanceof Credenciales)) {
            return false;
        }
        Credenciales cliente = (Credenciales) o;
        return identificacion.equals(cliente.identificacion) && password.equals(cliente.password);
    }

}
