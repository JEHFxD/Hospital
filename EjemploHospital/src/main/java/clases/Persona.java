package clases;
import javax.swing.JOptionPane;

public class Persona {
    
    private String numeroDeDNI;
    private String nombre;
    private String apellido;
    private String fechaDeNacimiento;
    private String direccion;
    private String ciudadDeProcedencia;
    
    public boolean DatosCompletos(){
        return numeroDeDNI != null && !numeroDeDNI.isEmpty() &&
               nombre != null && !nombre.isEmpty() &&
               apellido != null && !apellido.isEmpty() &&
               fechaDeNacimiento != null && !fechaDeNacimiento.isEmpty() &&
               direccion != null && !direccion.isEmpty() &&
               ciudadDeProcedencia != null && !ciudadDeProcedencia.isEmpty();
    }
    
    public void ImprimirDatosPersona(String datos){
        if (!DatosCompletos()) {
            JOptionPane.showMessageDialog(null, 
                "Información incompleta. Por favor, asegúrese de que todos los datos de la persona estén registrados.", 
                "Advertencia", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
            datos+="Nombre: "+nombre+"\n";
            datos+="Apellido: "+apellido+"\n";
            datos+="Fecha de Nacimiento: "+fechaDeNacimiento+"\n";
            datos+="Dirección: "+direccion+"\n";
            datos+="Ciudad de Procedencia: "+ciudadDeProcedencia+"\n";
            
            System.out.println(datos);
    }
    
    public void registrarDatos(){
        numeroDeDNI=JOptionPane.showInputDialog("Ingrese el numero del documento");
        nombre=JOptionPane.showInputDialog("Ingrese el nombre");
        apellido=JOptionPane.showInputDialog("Ingrese el apellido");
        fechaDeNacimiento=JOptionPane.showInputDialog("Ingrese la fecha de nacimiento (dd/mm/aaaa)");
        direccion=JOptionPane.showInputDialog("Ingrese la dirección");
        ciudadDeProcedencia=JOptionPane.showInputDialog("Ingrese la ciudad de Procedencia");  
    }

    public String getNumeroDeDNI() {
        return numeroDeDNI;
    }

    public void setNumeroDeDNI(String numeroDeDNI) {
        this.numeroDeDNI = numeroDeDNI;
    }

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

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudadDeProcedencia() {
        return ciudadDeProcedencia;
    }

    public void setCiudadDeProcedencia(String ciudadDeProcedencia) {
        this.ciudadDeProcedencia = ciudadDeProcedencia;
    }


    
}
