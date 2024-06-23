package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.EmpleadoEntity;

public interface EmpleadoService {

	List<EmpleadoEntity> obtenerTodosEmpleados();

    EmpleadoEntity obtenerEmpleadoPorId(String dni);

    EmpleadoEntity guardarActualizarEmpleado(EmpleadoEntity empleado);

    void eliminarEmpleado(String dni);
	
}
