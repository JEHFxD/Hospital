package clases.empleado;

import javax.swing.JOptionPane;

import clases.Persona;

public class Empleado extends Persona{
    
    private String codigoDeEmpleado;
    private int numeroDeHorasExtras;
    private String fechaDeIngreso;
    private String area;
    private String cargo;
    
    @Override
    public boolean DatosCompletos(){
        return super.DatosCompletos() &&
               codigoDeEmpleado != null && !codigoDeEmpleado.isEmpty() &&
               numeroDeHorasExtras>0 &&
               fechaDeIngreso != null && !fechaDeIngreso.isEmpty() &&
               area != null && !area.isEmpty() &&
               cargo != null && !cargo.isEmpty();      
    }
    
    
   @Override
    public void registrarDatos(){
        super.registrarDatos();
        
        codigoDeEmpleado=JOptionPane.showInputDialog("Ingrese el codigo del empleado");
        numeroDeHorasExtras=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de horas extras"));
        fechaDeIngreso=JOptionPane.showInputDialog("Ingrese la fecha de ingreso (dd/mm/aaaa)");
        area=JOptionPane.showInputDialog("Ingrese el area");
        cargo=JOptionPane.showInputDialog("Ingrese el cargo");
    }
    
    @Override
    public void ImprimirDatosPersona(String datos){
        if (!DatosCompletos()) {
            JOptionPane.showMessageDialog(null, 
                "Información incompleta. Por favor, asegúrese de que todos los datos del empleado estén completos.", 
                "Advertencia", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        super.ImprimirDatosPersona(datos);
        
        datos+= "Codigo De Empleado: "+codigoDeEmpleado+ "\n";
        datos+= "Numero De Horas Extras: "+numeroDeHorasExtras+ "\n";
        datos+= "Fecha De Ingreso: "+fechaDeIngreso+ "\n";
        datos+= "Area: "+area+ "\n";
        datos+= "Cargo: "+cargo+ "\n";
        
        System.out.println(datos);
        
    }

    public String getCodigoDeEmpleado() {
        return codigoDeEmpleado;
    }

    public void setCodigoDeEmpleado(String codigoDeEmpleado) {
        this.codigoDeEmpleado = codigoDeEmpleado;
    }

    public int getNumeroDeHorasExtras() {
        return numeroDeHorasExtras;
    }

    public void setNumeroDeHorasExtras(int numeroDeHorasExtras) {
        this.numeroDeHorasExtras = numeroDeHorasExtras;
    }

    public String getFechaDeIngreso() {
        return fechaDeIngreso;
    }

    public void setFechaDeIngreso(String fechaDeIngreso) {
        this.fechaDeIngreso = fechaDeIngreso;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    
}
