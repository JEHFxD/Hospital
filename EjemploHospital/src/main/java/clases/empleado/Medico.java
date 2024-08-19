package clases.empleado;
import javax.swing.JOptionPane;

public class Medico extends EmpleadoPlanilla {
    
    private String especialidad;
    private int numeroDeConsultorio;

    @Override
    public void registrarDatos(){
        super.registrarDatos();
        
        especialidad=JOptionPane.showInputDialog("Ingrese su especialidad");
        numeroDeConsultorio=Integer.parseInt(JOptionPane.showInputDialog("Num consultorio"));
    }
    
    @Override
    public boolean DatosCompletos(){
        return super.DatosCompletos() && especialidad !=null && !especialidad.isEmpty() && numeroDeConsultorio>0;
    }
    
    @Override
    public void ImprimirDatosPersona(String datos){
        if (!DatosCompletos()){
                JOptionPane.showMessageDialog(null, "Información incompleta.Por favor, asegúrese de que todos los datos del medico esten completos ", "Advertencia",JOptionPane.WARNING_MESSAGE);
                return;
            }
        super.ImprimirDatosPersona(datos);
        
        datos+="Ingrese la especialidad: "+especialidad+ "\n";
        datos+="Ingrese el numerio del Consultorio: "+numeroDeConsultorio+ "\n";
        
        System.out.println(datos);
    }
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getNumeroDeConsultorio() {
        return numeroDeConsultorio;
    }

    public void setNumeroDeConsultorio(int numeroDeConsultorio) {
        this.numeroDeConsultorio = numeroDeConsultorio;
    }

    public String getcodigoDeEmpleado() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
