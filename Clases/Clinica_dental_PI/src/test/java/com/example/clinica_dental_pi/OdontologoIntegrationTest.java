package com.example.clinica_dental_pi;

import com.example.clinica_dental_pi.model.Odontologo;
import com.example.clinica_dental_pi.service.OdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
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

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class OdontologoIntegrationTest {

    @Autowired
    private OdontologoService odontologoService;

    @Autowired
    private MockMvc mockMvc;


    public void cargarDataSet() {
        Odontologo odontologo = odontologoService.guardar(new Odontologo(19034, "Juan", "Dentista"));
        Odontologo odontologo1 = odontologoService.guardar(new Odontologo(2345, "Perla", "Blancas"));
    }

    @Test
    public void buscarTodosLosOdontologos() throws Exception {
        //Cargar odontologos
        this.cargarDataSet();
        //Se debe llamar al endpoint correspondiente del controller usando MockMvc
        MvcResult response= this.mockMvc.perform(MockMvcRequestBuilders.get("/odontologos"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }

    @Test
    public void buscarOdontologoPorId() throws Exception {
        //Cargar un paciente
        this.cargarDataSet();
        //Se debe llamar al endpoint correspondiente del controller usando MockMvc
        MvcResult response= this.mockMvc.perform(MockMvcRequestBuilders.get("/odontologos/{id}","1"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        Assert.assertFalse(response.getResponse().getContentAsString().isEmpty());
        //Assert.assertEquals("application/json",response.getResponse().getContentType());
    }

    @Test
    public void registrarOdontologo() throws Exception {
        //Crea un nuevo objeto Odontologo
        Odontologo odontologo = new Odontologo(2312, "Ramirez", "Juan");
        //Ahora se debe convertir el objeto a un String Json para enviarlo al REQUEST
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String odontolgoJson = writer.writeValueAsString(odontologo);

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/odontologos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(odontolgoJson))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        Assert.assertFalse(response.getResponse().getContentAsString().isEmpty());
    }

    @Test
    public void actualizarOdontologo() throws Exception{
        Odontologo odontologo = odontologoService.guardar(new Odontologo(001, "Martin", "Rodriguez"));
        Odontologo odontologoAct = (new Odontologo(odontologo.getId(),002, "Martin", "Rodriguez"));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String odontologoJson = writer.writeValueAsString(odontologoAct);

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.put("/odontologos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(odontologoJson))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        Assert.assertFalse(response.getResponse().getContentAsString().isEmpty());
    }


}
