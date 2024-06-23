package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.AreaEntity;
import com.example.demo.entity.EmpleadoEntity;
import com.example.demo.service.AreaService;
import com.example.demo.service.EmpleadoService;

@Controller
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;
	
	@Autowired
	private AreaService areaService;
	
	//Lista
	@GetMapping("/listar")
	public String listarEmpleados(Model model) {
        List<EmpleadoEntity> empleados = empleadoService.obtenerTodosEmpleados();
        model.addAttribute("empleados", empleados);
        return "lista_empleados";
    }
	
	
    @GetMapping("/registrar")
    public String showFormularioRegistrar(Model model) {
        EmpleadoEntity empleado = new EmpleadoEntity();
        List<AreaEntity> areas = areaService.obtenerTodasAreas();
        model.addAttribute("empleado", empleado);
        model.addAttribute("areas", areas);
        return "registrar_empleado"; 
    }
    //Sirve para los dos formularios de registro y editar
    @PostMapping("/guardar")
    public String guardarEmpleado(@ModelAttribute("empleado") EmpleadoEntity empleado) {
        empleadoService.guardarActualizarEmpleado(empleado);
        return "redirect:/listar"; 
    }
    
    
    @GetMapping("/editar/{dni}")
    public String showFormularioEditar(@PathVariable("dni") String dni, Model model) {
        EmpleadoEntity empleado = empleadoService.obtenerEmpleadoPorId(dni);
        List<AreaEntity> areas = areaService.obtenerTodasAreas();
        model.addAttribute("empleado", empleado);
        model.addAttribute("areas", areas);
        return "editar_empleado"; 
    }
    
    //Eliminar
    @GetMapping("/eliminar/{dni}")
    public String eliminarEmpleado(@PathVariable("dni") String dni) {
        empleadoService.eliminarEmpleado(dni);
        return "redirect:/listar"; 
    }
	
}
