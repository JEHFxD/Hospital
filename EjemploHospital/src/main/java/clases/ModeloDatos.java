package clases;


import clases.empleado.EmpleadoEventual;
import clases.empleado.EmpleadoPlanilla;
import clases.empleado.Medico;
import java.util.HashMap;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ModeloDatos {
    
    
    
    HashMap<String, Paciente>pacientesMap;
    HashMap<String, EmpleadoPlanilla> empleadosPlanillaMap;
    HashMap<String, EmpleadoEventual> empleadosEventualMap;
    HashMap<String, Medico>medicosMap;
    ArrayList<CitaMedica> citasList;
    
    public ModeloDatos(){
        pacientesMap=new HashMap<String, Paciente>();
        empleadosPlanillaMap=new HashMap<String, EmpleadoPlanilla>();
        empleadosEventualMap=new HashMap<String, EmpleadoEventual>();
        medicosMap=new HashMap<String, Medico>();
        citasList=new ArrayList<CitaMedica>();
    }
    
    public void registrarPersona(Paciente miPaciente){
        pacientesMap.put(miPaciente.getNumeroDeDNI(), miPaciente);
        System.out.println("Se ha registrado el paciente "+miPaciente.getNombre()+" Satisfactoriamente");
    }
    
    public void registrarDatos(EmpleadoPlanilla miEmpPlanilla){
        empleadosPlanillaMap.put(miEmpPlanilla.getNumeroDeDNI(), miEmpPlanilla);
    }
    
    public void registrarPersona(EmpleadoEventual miEmpEventual){
        empleadosEventualMap.put(miEmpEventual.getNumeroDeDNI(), miEmpEventual);
        System.out.println("Se ha registrado el empleado eventual "+miEmpEventual.getNombre()+" Satisfactoriamente");
    }
    
    public void registrarPersona(Medico miMedico){
        medicosMap.put(miMedico.getNumeroDeDNI(), miMedico);
        System.out.println("Se ha registrado el medi "+miMedico.getNombre()+" Satisfactoriamente");
    }
    
    
    public void imprimirPacientes(){
        String msj="Pacientes REGISTRADOS\n";
        
        for (String clave: pacientesMap.keySet()){
                pacientesMap.get(clave).ImprimirDatosPersona(msj);
        }
    }
    
    public void imprimirEmpleadosEventuales(){
        String msj="EMPLEADOS EVENTUALES REGISTRADOS\n";
        
        for (String clave: empleadosEventualMap.keySet()){
                empleadosEventualMap.get(clave).ImprimirDatosPersona(msj);
        }
    }
    
    public void imprimirEmpleadosPorPlanilla(){
        String msj="EMPLEADOS POR PLANILLA REGISTRADOS\n";
        
        for (String clave: empleadosPlanillaMap.keySet()){
                empleadosPlanillaMap.get(clave).ImprimirDatosPersona(msj);
        }
    }
    
    public void imprimirMedicos(){
        String msj="MEDICOS REGISTRADOS\n";
        
        for (String clave:medicosMap.keySet()){
            medicosMap.get(clave).ImprimirDatosPersona(msj);
        }
    }
    
    public Paciente consultarPacientePorDocumento(String documentoPaciente){
        Paciente miPaciente=null; 
        if(pacientesMap.containsKey(documentoPaciente)){
            miPaciente=pacientesMap.get(documentoPaciente);
        }
        
        //Si el paciente existe lo retorna, sinó retorna null
        return miPaciente;
    }
    
    public Medico consultarMedicoPorNombre(String nombreMedico){
        for(Medico medico : medicosMap.values()){
            if(medico.getNombre().equalsIgnoreCase(nombreMedico)){
            return medico;//al retornar atomaticamete termina el ciclo
            }
        }
        //En caso de no encontrar ningún medico retorna null
        return null;
    }
    
    public EmpleadoPlanilla consultarEmpleadoPlanillaPorCodigo(String codigoDeEmpleado) {
        EmpleadoPlanilla miEmpPlanilla=null;
       if(empleadosPlanillaMap.containsKey(codigoDeEmpleado)){
            miEmpPlanilla=empleadosPlanillaMap.get(codigoDeEmpleado);
        }
        
        //Si el empleado Planilla existe lo retorna, sinó retorna null
        return miEmpPlanilla;
    }
    
    public Medico consultarMedicoPorCodigo(String codigoDeEmpleado) {
        Medico miMedico=null;
       if(medicosMap.containsKey(codigoDeEmpleado)){
            miMedico=medicosMap.get(codigoDeEmpleado);
        }
        
        //Si el empleado Planilla existe lo retorna, sinó retorna null
        return miMedico;
    }
    
    public EmpleadoEventual consultarEmpleadoEventualPorCodigo(String codigoDeEmpleado) {
        EmpleadoEventual miEmpEventual=null;
       if(empleadosEventualMap.containsKey(codigoDeEmpleado)){
            miEmpEventual=empleadosEventualMap.get(codigoDeEmpleado);
        }
        
        //Si el empleado Eventual existe lo retorna, sinó retorna null
        return miEmpEventual;
    }
    
    public void registrarCitaMedica(CitaMedica miCita){
        citasList.add(miCita);
        System.out.println("Se ha registrado la cita exitosamente\n");
        System.out.println(miCita.informacionCitaMedica());
    }
    
    public void imprimirCitasMedicasProgramadas(){
        String msj="CITAS MEDICAS PROGRAMADAS";
        CitaMedica miCita=null;
        
        System.out.println(msj+"\n");
        
        if(citasList.size()>0){
            for(int i=0; i< citasList.size(); i++){
                miCita=citasList.get(i);
                System.out.println(miCita.informacionCitaMedica());
            }
        }else{
            System.out.println("No existen citas programadas");
        }
    }
}
