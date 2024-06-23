package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AreaEntity;
import com.example.demo.repository.AreaRepository;

@Service
public class AreaServiceImpl implements AreaService{

	@Autowired
	private AreaRepository areaRepository;

	@Override
	public List<AreaEntity> obtenerTodasAreas() {
		return areaRepository.findAll();
	}
	
}
