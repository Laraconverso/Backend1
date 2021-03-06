import dao.impl.OdontologoDaoH2;
import dao.impl.PacienteDaoH2;
import model.Domicilio;
import model.Odontologo;
import model.Paciente;
import service.OdontologoService;
import service.PacienteService;

import java.util.Date;

public class Main {


    public static void main(String[] args) {
        // Pruebas si usar JUNIT
        PacienteService pacienteService = new PacienteService(new PacienteDaoH2());
        OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

        Domicilio domicilio = new Domicilio("Av Santa fe", "444", "CABA", "Buenos Aires");
        Paciente paciente= new Paciente("Santiago", "Paz", "88888888", new Date(), domicilio);
        Odontologo odontologo = new Odontologo(234,"Pancho", "Dionez");
        Paciente p = pacienteService.guardar(paciente);
        Odontologo o = odontologoService.guardar(odontologo);

    }
}
