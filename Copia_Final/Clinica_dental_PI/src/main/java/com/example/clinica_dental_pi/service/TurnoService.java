package com.example.clinica_dental_pi.service;

import com.example.clinica_dental_pi.repository.OdontologoRepository;
import com.example.clinica_dental_pi.repository.PacienteRepository;
import com.example.clinica_dental_pi.repository.TurnoRepository;
import com.example.clinica_dental_pi.exceptions.BadRequestException;
import com.example.clinica_dental_pi.exceptions.ResourceNotFoundException;
import com.example.clinica_dental_pi.model.Turno;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {

    private TurnoRepository turnoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private OdontologoRepository odontologoRepository;

    private static final Logger logger = Logger.getLogger(PacienteService.class);

    public TurnoService(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    public List<Turno> buscarTodos(){
        return turnoRepository.findAll();
    }

    public Turno registrarTurno(Turno turno) throws BadRequestException {
        if(pacienteRepository.findById(turno.getPaciente().getId()) == null ){
            logger.error("Se quiere crear un turno para un paciente inexistente en la base de datos.");
            throw new BadRequestException("No existe ningun paciente con ese id: "+ turno.getPaciente().getId());
        } else if (odontologoRepository.findById(turno.getOdontologo().getId())== null){
            logger.error("Se quiere crear un turno con un odontologo inexistente en la base de datos.");
            throw new BadRequestException("No existe ningun odontologo con ese id: "+ turno.getOdontologo().getId());
        }
        return turnoRepository.save(turno);
    }

    public void eliminarTurno(Integer id) throws ResourceNotFoundException {
        if(buscar(id)==null){
            logger.error("Se quiere eliminar un turno con un id inexistente en la base de datos.");
            throw new ResourceNotFoundException("No existe ningun turno con ese id: " +id);
        }
        turnoRepository.deleteById(id);
    }

    public Turno actualizar(Turno t) throws ResourceNotFoundException{
        if(buscar(t.getId())==null){
            logger.error("Se quiere actualizar un turno con un id inexistente en la base de datos.");
            throw new ResourceNotFoundException("No existe el turno");
        }
        return turnoRepository.save(t);
    }

    public Turno buscar(Integer id) {
        Turno turno = null;
        Optional<Turno> optionalTurno= turnoRepository.findById(id);
        if (optionalTurno.isPresent()){
            turno= optionalTurno.get();
        }
        return turno;
    }

}
