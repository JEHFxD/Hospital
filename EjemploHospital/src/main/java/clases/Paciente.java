package clases;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Paciente extends Persona{
    
    private int numeroHistoriaClínica;
    private String sexo;
    private String grupoSanguineo;
    private ArrayList<String> listaMedicamentosAlergico;

   @Override
   public void registrarDatos(){
       super.registrarDatos();
       
       listaMedicamentosAlergico=new ArrayList<String>();
       numeroHistoriaClínica=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de la historia clinica"));
       sexo=JOptionPane.showInputDialog("Ingrese el sexo");
       grupoSanguineo=JOptionPane.showInputDialog("Ingrese el grupo sanguineo");
       
       String pregunta=JOptionPane.showInputDialog("¿Es alergico a algun medicamento? ingrese si o no");
       
       if(pregunta.equalsIgnoreCase("si")){
           String medicamento="";
           String continuar="";
           do{
               medicamento=JOptionPane.showInputDialog("Ingrese el nombre del medicamento al que es alergico");
               listaMedicamentosAlergico.add(medicamento);
           
               continuar=JOptionPane.showInputDialog("Ingrese si, si desea continuar");
           
            }while (continuar.equalsIgnoreCase("si"));
        }
    }
   
   @Override
    public boolean DatosCompletos() {
        return super.DatosCompletos()&&
               numeroHistoriaClínica > 0 &&
               sexo != null && !sexo.isEmpty() &&
               grupoSanguineo != null && !grupoSanguineo.isEmpty() &&
               listaMedicamentosAlergico != null;
    }
   
   @Override
   public void ImprimirDatosPersona(String datos){
       if(!DatosCompletos()){
           JOptionPane.showMessageDialog(null, 
            "Información incompleta. Por favor, asegúrese de que todos los datos del paciente estén registrados.", 
            "Advertencia", 
            JOptionPane.WARNING_MESSAGE);
        return;
       }
       super.ImprimirDatosPersona(datos);
       
       datos+="Numero Historia Clinica: "+numeroHistoriaClínica+"\n";
       datos+="Sexo: "+sexo+"\n";
       datos+="Grupo Sanguineo: "+grupoSanguineo+"\n";
       
       if(listaMedicamentosAlergico.size()>0){
           datos+="lista de Medicamentos a los que es Alergico\n";
           for(int i = 0;i<listaMedicamentosAlergico.size();i++){
               datos+="\t"+listaMedicamentosAlergico.get(i)+"\n";
           }
       }else{
           datos+="El paciente no es alergico a ningún medicamento";
       }
       
       System.out.println(datos);
   }
   
    public int getNumeroHistoriaClínica() {
        return numeroHistoriaClínica;
    }

    public void setNumeroHistoriaClínica(int numeroHistorialClínica) {
        this.numeroHistoriaClínica = numeroHistorialClínica;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public ArrayList<String> getListaMedicamentosAlergico() {
        return listaMedicamentosAlergico;
    }

    public void setListaMedicamentosAlergico(ArrayList<String> listaMedicamentosAlergico) {
        this.listaMedicamentosAlergico = listaMedicamentosAlergico;
    }
    
    
}
