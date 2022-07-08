package com.example.clinica_dental_pi;

import com.example.clinica_dental_pi.model.Domicilio;
import com.example.clinica_dental_pi.model.Odontologo;
import com.example.clinica_dental_pi.model.Paciente;
import com.example.clinica_dental_pi.model.Turno;
import com.example.clinica_dental_pi.service.OdontologoService;
import com.example.clinica_dental_pi.service.PacienteService;
import com.example.clinica_dental_pi.service.TurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Date;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class TurnoIntegrationTest {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private OdontologoService odontologoService;

    @Autowired
    private TurnoService turnoService;

    @Autowired
    private MockMvc mockMvc;


    public void cargarDataSet() throws Exception {
        //Se registrar Paciente y Odontologo
        Domicilio domicilio = new Domicilio("Av Santa fe", "444", "CABA", "Buenos Aires");
        Paciente p = pacienteService.guardar(new Paciente("Santiago", "Paz", "88888888", new Date(), domicilio));
        Odontologo o = odontologoService.guardar(new Odontologo(21341, "Ramirez", "Callag"));
        //Se registra un Turno
        Turno turno= new Turno(p, o, new Date());
        turnoService.registrarTurno(turno);
    }

    @Test
    public void listarTurnos() throws Exception{
        //Carga un turno
        this.cargarDataSet();
        //Se debe llamar al endpoint correspondiente del controller usando MockMvc
        MvcResult response= this.mockMvc.perform(MockMvcRequestBuilders.get("/turnos"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        Assert.assertFalse(response.getResponse().getContentAsString().isEmpty());
    }

    @Test
    public void buscarTurnoPorId() throws Exception {
        //Cargar un paciente
        Domicilio domicilio = new Domicilio("Av Santa fe", "444", "CABA", "Buenos Aires");
        Paciente p = pacienteService.guardar(new Paciente("Santiago", "Paz", "88888888", new Date(), domicilio));
        Odontologo o = odontologoService.guardar(new Odontologo(23145, "Perlas", "Blancas"));
        Turno t = turnoService.registrarTurno(new Turno(p, o, new Date()));
        //Se debe llamar al endpoint correspondiente del controller usando MockMvc
        MvcResult response= this.mockMvc.perform(MockMvcRequestBuilders.get("/turnos/{id}",t.getId()))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        //Assert.assertFalse(response.getResponse().getContentAsString().isEmpty());
        Assert.assertEquals("application/json",response.getResponse().getContentType());
    }

    @Test
    public void registrarTurno() throws Exception {
        //Crea un nuevo objeto Turno
        Odontologo odontologo = odontologoService.guardar(new Odontologo(2312, "Ramirez", "Juan"));
        Domicilio domicilio = new Domicilio("Av Santa fe", "00", "CABA", "Buenos Aires");
        Paciente p = pacienteService.guardar(new Paciente("Juan", "Perez", "88888888", new Date(), domicilio));
        Turno t = turnoService.registrarTurno(new Turno(p,odontologo, new Date()));
        //Ahora se debe convertir el objeto a un String Json para enviarlo al REQUEST
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String odontolgoJson = writer.writeValueAsString(t);

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/turnos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(odontolgoJson))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        Assert.assertFalse(response.getResponse().getContentAsString().isEmpty());
    }

    @Test
    public void actualizarOdontologo() throws Exception{
        Odontologo odontologo = odontologoService.guardar(new Odontologo(2312, "Ramirez", "Juan"));
        Domicilio domicilio =  new Domicilio("Av Santa fe", "00", "CABA", "Buenos Aires");
        Paciente p = pacienteService.guardar(new Paciente("Juanchoz", "Perez", "88888888", new Date(), domicilio));
        Paciente p2 = new Paciente(p.getId(),"Juan", "Perez", "88888888", new Date(), domicilio);
        Turno t = turnoService.registrarTurno(new Turno(p,odontologo, new Date()));
        Turno turnoAct = (new Turno(t.getId(),p2, odontologo, new Date()));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String odontologoJson = writer.writeValueAsString(turnoAct);

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.put("/turnos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(odontologoJson))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        Assert.assertFalse(response.getResponse().getContentAsString().isEmpty());
    }

}
