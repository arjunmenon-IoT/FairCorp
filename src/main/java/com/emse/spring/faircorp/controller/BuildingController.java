package com.emse.spring.faircorp.controller;

import com.emse.spring.faircorp.dao.BuildingDao;
import com.emse.spring.faircorp.dto.BuildingDto;
import com.emse.spring.faircorp.model.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/building")
@Transactional
public class BuildingController {

    @Autowired
    private BuildingDao buildingDao;

    @GetMapping
    public List<BuildingDto> findAll() {
        return buildingDao.findAll().stream().map(BuildingDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/{building_id}")
    public BuildingDto findById(@PathVariable Long building_id) {
        return buildingDao.findById(building_id).map(BuildingDto::new).orElse(null);
    }

    @DeleteMapping(path = "/{building_id}")
    public void delete(@PathVariable Long building_id) {
        buildingDao.deleteById(building_id);
    }

    @PostMapping(path = "/")
    public BuildingDto create(@RequestBody BuildingDto dto) {
        Building building;
        if (dto.getId() == null) {
            building = buildingDao.save(new Building(dto.getId(), dto.getName()));
        } else {
            building = buildingDao.getById(dto.getId());
            building.setName(dto.getName());
        }
        return new BuildingDto(building);
    }
}
