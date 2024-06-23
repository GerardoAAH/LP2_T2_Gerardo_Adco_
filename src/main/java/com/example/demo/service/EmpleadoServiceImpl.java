package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.EmpleadoEntity;
import com.example.demo.repository.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@Override
	public List<EmpleadoEntity> obtenerTodosEmpleados() {
		return empleadoRepository.findAll();
	}

	@Override
	public EmpleadoEntity obtenerEmpleadoPorId(String dni) {
		return empleadoRepository.findById(dni).get();
	}

	@Override
	public EmpleadoEntity guardarActualizarEmpleado(EmpleadoEntity empleado) {
		return empleadoRepository.save(empleado);
	}

	@Override
	public void eliminarEmpleado(String dni) {
		empleadoRepository.deleteById(dni);
	}

}
