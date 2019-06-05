package MisClases;

/**
 *
 * @author Omar
 */
public class Maquinistas {
    private String Nombre;
    private String ApPaterno;
    private String Cedula;
    private String ApMaterno;
    private String Antiguedad;
    

    public Maquinistas() {
    }
    
    public Maquinistas(String Nombre, String ApPaterno, 
            String ApMaterno, String Cedula, String Antiguedad) {
        this.Nombre = Nombre;
        this.ApPaterno = ApPaterno;
        this.ApMaterno = ApMaterno;
        this.Antiguedad = Antiguedad;
        this.Cedula = Cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApPaterno() {
        return ApPaterno;
    }

    public void setApPaterno(String ApPaterno) {
        this.ApPaterno = ApPaterno;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getApMaterno() {
        return ApMaterno;
    }

    public void setApMaterno(String ApMaterno) {
        this.ApMaterno = ApMaterno;
    }

    public String getAntiguedad() {
        return Antiguedad;
    }

    public void setAntiguedad(String Antiguedad) {
        this.Antiguedad = Antiguedad;
    }

    // NO TE PASES DE LA COLUMNA 80
    @Override
    public String toString() {
        return "\n" + "Maquinista-> " + "Nombre: " + Nombre + "\nApPaterno: "
                + ApPaterno + "\nCedula: " + Cedula + "\nEspecialidad: " + 
                ApMaterno + "\nAntiguedad: " + Antiguedad;
    }

    
    
}
