package com.example.demo.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_empleado")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmpleadoEntity {

	@Id
	@Column(name = "dni_empleado",
			nullable = false,
			length = 8,
			columnDefinition = "CHAR(8)",
			unique = true)
	private String dniEmpleado;
	
	
	@Column(name = "nombre_empleado",
			nullable = false,
			columnDefinition = "VARCHAR(45)")
    private String nombreEmpleado;
	

    @Column(name = "apellido_empleado",
    		nullable = false,
			columnDefinition = "VARCHAR(45)")
    private String apellidoEmpleado;
    

    @Column(name = "fecha_nacimiento",
    		nullable = false,
    		updatable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaNacimiento;
    

    @Column(name = "direccion",
    		nullable = false,
			columnDefinition = "VARCHAR(45)")
    private String direccion;
    

    @Column(name = "correo",
    		nullable = false,
			columnDefinition = "VARCHAR(45)")
    private String correo;
    
    
    @ManyToOne
    @JoinColumn(name = "area_id",nullable = false)
    private AreaEntity area;
	
}
