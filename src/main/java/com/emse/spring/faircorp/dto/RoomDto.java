package com.emse.spring.faircorp.dto;

import com.emse.spring.faircorp.model.Room;


public class RoomDto {
    private Long id;
    private String name;
    private int floor;
    private Double currentTemperature;
    private Double targetTemperature;
    private Long buildingId;


    public RoomDto() {
    }

    public RoomDto(Room room) {
        this.name = room.getName();
        this.id = room.getId();
        this.currentTemperature = room.getCurrentTemperature();
        this.buildingId = room.getBuilding().getId();
        this.floor = room.getFloor();
        this.targetTemperature = room.getTargetTemperature();
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Double getCurrentTemperature() {
        return currentTemperature;
    }
    public void setCurrentTemperature(Double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }


    public void setName(String name) {
        this.name = name;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Double getTargetTemperature() {
        return targetTemperature;
    }

    public void setTargetTemperature(Double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }
}