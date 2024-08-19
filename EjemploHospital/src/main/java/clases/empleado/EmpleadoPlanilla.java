package clases.empleado;
import javax.swing.JOptionPane;

public class EmpleadoPlanilla  extends Empleado{
    
        private double salarioMensual;
        private double porcetanjeAdicionalPorHoraExtra;
        
        @Override
        public boolean DatosCompletos(){
            return super.DatosCompletos() && salarioMensual > 0 &&  porcetanjeAdicionalPorHoraExtra >=0;
        }
        
        @Override
        public void registrarDatos(){
            super.registrarDatos();
            
            salarioMensual=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario Mensual"));
            porcetanjeAdicionalPorHoraExtra=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el porcentaje Adicional por Hora Extra"));
        }
        
        @Override
        public void ImprimirDatosPersona(String datos){
            if (!DatosCompletos()) {
            JOptionPane.showMessageDialog(null, 
                "Información incompleta. Por favor, asegúrese de que todos los datos del empleado de planilla estén completos.", 
                "Advertencia", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
            super.ImprimirDatosPersona(datos);
            
            datos+="Salario Mensual:"+salarioMensual+ "\n";
            datos+="Porcentaje Adicional Por Hora Extra: "+porcetanjeAdicionalPorHoraExtra+ "\n";
            
            System.out.println(datos);
        }

    public double getSalariomensual() {
        return salarioMensual;
    }

    public void setSalariomensual(double salariomensual) {
        this.salarioMensual = salariomensual;
    }

    public double getPorcetajeAdicionalPorHoraExtra() {
        return porcetanjeAdicionalPorHoraExtra;
    }

    public void setPorcetajeAdicionalPorHoraExtra(double porcetajeAdicionalPorHoraExtra) {
        this.porcetanjeAdicionalPorHoraExtra = porcetajeAdicionalPorHoraExtra;
    }
        
        
    
}
