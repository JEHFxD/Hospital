package clases.empleado;

import javax.swing.JOptionPane;

public class EmpleadoEventual extends Empleado {
    
        private double honorariosPorHora;
        private String fechaTerminoContrato;
        
        @Override
        public void registrarDatos(){
            super.registrarDatos();
            
            honorariosPorHora=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario Mensual"));
            fechaTerminoContrato=JOptionPane.showInputDialog("Ingrese fecha de Terminación de Contrato (dd/mm/aaaa)");
        }
        
        @Override
        public boolean DatosCompletos(){
            return  super.DatosCompletos() &&
                    honorariosPorHora > 0 && fechaTerminoContrato != null && !fechaTerminoContrato.isEmpty();
        }
        
        @Override
        public void ImprimirDatosPersona(String datos){
            if (!DatosCompletos()){
                JOptionPane.showMessageDialog(null, "Información incompleta.Por favor, asegúrese de que todos los datos del empleado eventual esten completos ", "Advertencia",JOptionPane.WARNING_MESSAGE);
                return;
            }
            super.ImprimirDatosPersona(datos);
            
            datos+="Honorarios por Horas: "+honorariosPorHora+"\n";
            datos+="Fecha Termino del contrato: "+fechaTerminoContrato+"\n";
            
            System.out.println(datos);
        }

    public double getHonorarioPorHora() {
        return honorariosPorHora;
    }

    public void setHonorarioPorHora(double honorarioPorHora) {
        this.honorariosPorHora = honorarioPorHora;
    }

    public String getFechaTerminoContrato() {
        return fechaTerminoContrato;
    }

    public void setFechaTerminoContrato(String fechaTerminoContrato) {
        this.fechaTerminoContrato = fechaTerminoContrato;
    }

    public String getcodigoDeEmpleado() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        
        
    
}
