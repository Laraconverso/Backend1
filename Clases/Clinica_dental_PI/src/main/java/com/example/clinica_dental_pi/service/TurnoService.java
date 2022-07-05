package com.example.clinica_dental_pi.service;

import com.example.clinica_dental_pi.Repository.OdontologoRepository;
import com.example.clinica_dental_pi.Repository.PacienteRepository;
import com.example.clinica_dental_pi.Repository.TurnoRepository;
import com.example.clinica_dental_pi.exceptions.BadRequestException;
import com.example.clinica_dental_pi.exceptions.ResourceNotFoundException;
import com.example.clinica_dental_pi.model.Turno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {

   // @Autowired
    private TurnoRepository turnoRepository;
    //@Autowired
    private PacienteRepository pacienteRepository;
   // @Autowired
    private OdontologoRepository odontologoRepository;

    public TurnoService(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    public List<Turno> buscarTodos(){
        return turnoRepository.findAll();
    }

    public Turno registrarTurno(Turno turno) throws BadRequestException {
        if(pacienteRepository.findById(turno.getPaciente().getId()) == null ){
            throw new BadRequestException("No existe ningun paciente con ese id: "+ turno.getPaciente().getId());
        } else if (odontologoRepository.findById(turno.getOdontologo().getId())== null){
            throw new BadRequestException("No existe ningun odontologo con ese id: "+ turno.getOdontologo().getId());
        }

//        if (turno.getPaciente().getId() == null || turno.getOdontologo().getId() == null){
//            throw new BadRequestexception("el odontologo o paciente no es valido");
//
//        }else{
//            turno.setFecha(new Date());
//            return turnoRepository.save(turno);
//        }
        return turnoRepository.save(turno);
    }

    public void eliminarTurno(Integer id) throws ResourceNotFoundException {
        if(buscar(id)==null){
            throw new ResourceNotFoundException("No existe ningun turno con ese id: " +id);
        }
        turnoRepository.deleteById(id);
    }

    public Turno actualizar(Turno t) {
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
