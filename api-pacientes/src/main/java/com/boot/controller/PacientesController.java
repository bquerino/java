package com.boot.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.Paciente;
import com.boot.repository.PacienteRepository;

@RestController
@RequestMapping("api/v1/")
public class PacientesController {
  
  @Autowired
  private PacienteRepository PacienteRepository;
  
  @RequestMapping(value = "pacientes", method = RequestMethod.GET)
  public List<Paciente> list(){
    return PacienteRepository.findAll();
  }
  
  @RequestMapping(value = "pacientes", method = RequestMethod.POST)
  public Paciente create(@RequestBody Paciente paciente) {
    return PacienteRepository.saveAndFlush(paciente);
  }
  
  @RequestMapping(value = "pacientes/{id}", method = RequestMethod.GET)
  public Paciente get(@PathVariable Long id) {
    return PacienteRepository.findOne(id);
  }
  
  @RequestMapping(value = "pacientes/{id}", method = RequestMethod.PUT)
  public Paciente update(@PathVariable Long id, @RequestBody Paciente paciente) {
    Paciente existingPaciente = PacienteRepository.findOne(id);
    BeanUtils.copyProperties(paciente, existingPaciente);
    return PacienteRepository.saveAndFlush(existingPaciente);
    
  }
  
  @RequestMapping(value = "pacientes/{id}", method = RequestMethod.DELETE)
  public Paciente create(@PathVariable Long id) {
    Paciente existingPaciente = PacienteRepository.findOne(id);
    PacienteRepository.delete(existingPaciente);
    return existingPaciente;
  }
}
