package clases;

import clases.empleado.Medico;
import javax.swing.JOptionPane;


public class CitaMedica {
    
    private Paciente paciente;
    private Medico medico;
    private String servicio;
    private String fechaConsulta;
    private String horaConsulta;
    private String lugar;
    
    public CitaMedica(Paciente paciente,Medico medico,String servicio,String fechaConsulta,String HoraConsulta,String lugar){
        
        this.paciente = paciente;
        this.medico  = medico;
        this.servicio = servicio;
        this.fechaConsulta = fechaConsulta;
        this.horaConsulta = horaConsulta;
        this.lugar = lugar;
    }
    
    public boolean DatosCompletos(){
        return paciente != null &&
               medico != null &&
               servicio != null && !servicio.isEmpty() &&
               fechaConsulta != null && !fechaConsulta.isEmpty() &&
               horaConsulta != null && !horaConsulta.isEmpty() &&
               lugar != null && !lugar.isEmpty();
    }
    
    public String informacionCitaMedica(){
        if (!DatosCompletos()) {
            JOptionPane.showMessageDialog(null, 
                "Información incompleta. Por favor, asegúrese de que todos los datos de la cita médica estén completos.", 
                "Advertencia", 
                JOptionPane.WARNING_MESSAGE);
            return "";
        }
        String datosCita="<< INFORMACIÓN CITA MEDICA >>\\n";
        datosCita+="Paciente: "+paciente.getNombre()+"\n";
        datosCita+="Medico: "+medico.getNombre()+"\n";
        datosCita+="Motivo Consulta: "+servicio+"\n";
        datosCita+="Fecha Consulta: "+fechaConsulta+"  - Hora: "+horaConsulta+"\n";
        datosCita+="Lugar: "+lugar+"\n\n";
        
        return datosCita;
                
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(String fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public String getHoraConsulta() {
        return horaConsulta;
    }

    public void setHoraConsulta(String horaConsulta) {
        this.horaConsulta = horaConsulta;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    
    
    
}
