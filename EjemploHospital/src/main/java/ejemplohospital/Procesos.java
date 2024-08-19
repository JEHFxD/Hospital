package ejemplohospital;

import clases.CitaMedica;
import clases.ModeloDatos;
import clases.Paciente;
import clases.empleado.EmpleadoEventual;
import clases.empleado.EmpleadoPlanilla;
import clases.empleado.Medico;
import javax.swing.JOptionPane;

public class Procesos {
    
    ModeloDatos miModeloDatos;
    
    public Procesos(){
        miModeloDatos=new ModeloDatos();
        presentarMenuOpciones();
    }
    
    private void presentarMenuOpciones(){
        
        String menu="MENU HOSPITAL\n\n";
        menu+="1. Registrar Paciente\n";
        menu+="2. Registrar Empleado\n";
        menu+="3. Registrar Cita Medica\n";
        menu+="4. Imprimir Información\n";
        menu+="5. Salir\n\n";
        menu+=" Ingrese una opción\n";
        
        int opcion=0;
        
        do{
            
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch(opcion){
                case 1: registrarPaciente(); break;
                case 2: registrarEmpleado(); break;
                case 3: registrarCitaMedica(); break;
                case 4: imprimirInformacion(); break;
                case 5: System.out.println("El sistema ha terminado!"); break;
                default: System.out.println("No existe el codigo, verifique nuevamente");
                    break;
            }
        
        }while (opcion!=5);
    } 

    private void registrarPaciente(){
       try {
        Paciente miPaciente = new Paciente();
        miPaciente.registrarDatos();
        
        if (miModeloDatos.consultarPacientePorDocumento(miPaciente.getNumeroDeDNI()) != null) {
            JOptionPane.showMessageDialog(null, 
                "El número de documento ya está registrado. Por favor, verifique e intente nuevamente.", 
                "Error de Registro", 
                JOptionPane.ERROR_MESSAGE);
        } else {
            miModeloDatos.registrarPersona(miPaciente);
            JOptionPane.showMessageDialog(null, 
                "Paciente registrado exitosamente.", 
                "Registro Exitoso", 
                JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, 
            "Error al registrar el paciente. Por favor, verifique los datos e intente nuevamente.", 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
    }
    
    private void registrarEmpleado(){
        String menuTipoEmpleado = "Registro de Empleado\n";
    menuTipoEmpleado += "1. Empleado Eventual\n";
    menuTipoEmpleado += "2. Empleado Por Planilla\n";
    menuTipoEmpleado += " Seleccione el tipo de empleado a registrar\n";

    int tipoEmpleado = 0;

    try {
        tipoEmpleado = Integer.parseInt(JOptionPane.showInputDialog(menuTipoEmpleado));
        switch (tipoEmpleado) {
            case 1: // Registrar Empleado Eventual
                EmpleadoEventual miEmpEventual = new EmpleadoEventual();
                miEmpEventual.registrarDatos();
                
                if (miModeloDatos.consultarEmpleadoEventualPorCodigo(miEmpEventual.getCodigoDeEmpleado()) != null) {
                    JOptionPane.showMessageDialog(null, 
                        "El número de documento ya está registrado. Por favor, verifique e intente nuevamente.", 
                        "Error de Registro", 
                        JOptionPane.ERROR_MESSAGE);
                } else {
                    miModeloDatos.registrarPersona(miEmpEventual);
                    JOptionPane.showMessageDialog(null, 
                        "Empleado eventual registrado exitosamente.", 
                        "Registro Exitoso", 
                        JOptionPane.INFORMATION_MESSAGE);
                }
                break;

            case 2: // Registrar Empleado Por Planilla
                String resp = JOptionPane.showInputDialog("Ingrese 'si' si es un médico, de lo contrario es otro tipo de empleado");

                if (resp.equalsIgnoreCase("si")) {
                    // Registro Médico
                    Medico miMedico = new Medico();
                    miMedico.registrarDatos();

                    if (miModeloDatos.consultarMedicoPorCodigo(miMedico.getCodigoDeEmpleado()) != null) {
                        JOptionPane.showMessageDialog(null, 
                            "El médico ya está registrado. Por favor, verifique e intente nuevamente.", 
                            "Error de Registro", 
                            JOptionPane.ERROR_MESSAGE);
                    } else {
                        miModeloDatos.registrarPersona(miMedico);
                        JOptionPane.showMessageDialog(null, 
                            "Médico registrado exitosamente.", 
                            "Registro Exitoso", 
                            JOptionPane.INFORMATION_MESSAGE);
                    }

                } else {
                    // Registro Empleado Planilla
                    EmpleadoPlanilla miEmpPlanilla = new EmpleadoPlanilla();
                    miEmpPlanilla.registrarDatos();

                    if (miModeloDatos.consultarEmpleadoPlanillaPorCodigo(miEmpPlanilla.getCodigoDeEmpleado()) != null) {
                        JOptionPane.showMessageDialog(null, 
                            "El código de empleado ya está registrado. Por favor, verifique e intente nuevamente.", 
                            "Error de Registro", 
                            JOptionPane.ERROR_MESSAGE);
                    } else {
                        miModeloDatos.registrarDatos(miEmpPlanilla);
                        JOptionPane.showMessageDialog(null, 
                            "Empleado por planilla registrado exitosamente.", 
                            "Registro Exitoso", 
                            JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                break;

            default:
                System.out.println("El tipo de empleado no es válido, inténtelo nuevamente.");
                break;
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, 
            "Entrada inválida. Por favor, ingrese un número para continuar.", 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, 
            "Error al registrar el empleado. Por favor, verifique los datos e intente nuevamente.", 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
        
    }
    
    private void registrarCitaMedica(){
        String documentoPaciente=JOptionPane.showInputDialog("Ingrese el documento del paciente");
        
        Paciente pacienteEncontrado=miModeloDatos.consultarPacientePorDocumento(documentoPaciente);
        
        if(pacienteEncontrado!=null){
            String nombreMedico=JOptionPane.showInputDialog("Ingrese el nombre del médico");
            Medico medicoEncontrado=miModeloDatos.consultarMedicoPorNombre(nombreMedico);
            
            if(medicoEncontrado!=null){
                String servicio=JOptionPane.showInputDialog("Ingrese el servicio o el motivo de la consulta");
                String fechaConsulta=JOptionPane.showInputDialog("Ingrese la fecha de la consulta");
                String horaConsulta=JOptionPane.showInputDialog("Ingrese la hora de la consulta");
                
                String lugar="La cita será en el consultorio "+medicoEncontrado.getNumeroDeConsultorio();
                CitaMedica miCita=new CitaMedica(pacienteEncontrado, medicoEncontrado,servicio,fechaConsulta,horaConsulta,lugar);
                miModeloDatos.registrarCitaMedica(miCita);
            }else{
                System.out.println("El medico no se encuentra registrado en el sistema");
            }
        }else{
            System.out.println("El paciente no se encuentra registrado en el sistema");
        }
        
    }
    
    private void imprimirInformacion(){
        
        String menuImprimir="MENU IMPRESIONES\n";
        menuImprimir+="1. Listar Pacientes\n";
        menuImprimir+="2. Listar Empleados Eventuales\n";
        menuImprimir+="3. Listar Empleados por Planilla\n";
        menuImprimir+="4. Listar Medicos\n";
        menuImprimir+="5. Listar Citas Programadas\n";
        menuImprimir+="Ingrese una opción\n";
        
        System.out.println("***********************************************************");
        
        int opcion=Integer.parseInt(JOptionPane.showInputDialog(menuImprimir));
        
        switch(opcion){
        case 1: miModeloDatos.imprimirPacientes(); break;
        case 2: miModeloDatos.imprimirEmpleadosEventuales(); break;
        case 3: miModeloDatos.imprimirEmpleadosPorPlanilla(); break;
        case 4: miModeloDatos.imprimirMedicos(); break;
        case 5: miModeloDatos.imprimirCitasMedicasProgramadas(); break;
        
        default:System.out.println("No existe esa opción");
            break;
        
            
        }
        
    }
}
