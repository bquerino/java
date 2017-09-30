package com.boot;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.boot.controller.PacientesController;
import com.boot.model.Paciente;
import com.boot.repository.PacienteRepository;


public class PacienteControllerTest {
	@InjectMocks
	private PacientesController pc;
	
	@Mock
	private PacienteRepository pacienteRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testPacienteGet() {
		Paciente pa = new Paciente();
		pa.setId(1l);
		when(pacienteRepository.findOne(1l)).thenReturn(pa);
		
		Paciente pac = pc.get(1L);
		
		verify(pacienteRepository).findOne(1l);
		
		/*Mockito*/
		//assertEquals(1l, pac.getId().longValue());
		/*Hamcrest*/
		assertThat(pac.getId(), is(1l));
	}

}
