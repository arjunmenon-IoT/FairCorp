package com.emse.spring.faircorp.service;

import com.emse.spring.faircorp.dao.*;
import com.emse.spring.faircorp.model.*;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitService {
    @Autowired
    BuildingDao buildingDao;
    @Autowired
    RoomDao roomDao;
    @Autowired
    WindowDao windowDao;
    @Autowired
    HeaterDao heaterDao;


    /**
     * initializes the database with dummy data
     */
    public void init() {
        buildingDao.deleteAll();

        ArrayList<Building> buildings = new ArrayList<>();

        Building emse = new Building();
        emse.setName("EMSE");
        emse = buildingDao.save(emse);
        buildings.add(emse);
        Building building2 = new Building();
        building2.setName("Jean Monnet University");
        building2 = buildingDao.save(building2);
        buildings.add(building2);
        Building building3 = new Building();
        building3.setName("La Matare");
        building3 = buildingDao.save(building3);
        buildings.add(building3);

        for (Building building : buildings) {

            Building currentBuilding = building;
            int floorCount = (int) Math.floor(Math.random() * 6 + 2);
            ArrayList<Integer> roomCountPerFloor = new ArrayList<>();
            for (int floor=0;floor<floorCount;floor++){
                roomCountPerFloor.add((int) Math.floor(Math.random() * 5 + 3));
            }
            for (int floor = 0; floor < floorCount; floor++) {
                for (int roomNum = 0; roomNum < roomCountPerFloor.get(floor); roomNum++) {
                    Room room = new Room();
                    room.setBuilding(currentBuilding);
                    room.setFloor(floor);
                    room.setName("R_" + floor + "_" + roomNum);
                    room.setTargetTemperature(20d);
                    room.setCurrentTemperature(Math.floor(Math.random() * 15 + 5));
                    room = roomDao.save(room);
                    
                    for (int windowNum = 0; windowNum < Math.floor(Math.random() * 6 + 2); windowNum++) {
                        Window window = new Window();
                        window.setRoom(room);
                        window.setName("W_" + floor + "" + roomNum + "" + windowNum);
                        window.setStatus(Math.random() < 0.5 ? WindowStatus.OPEN : WindowStatus.CLOSED);
                        windowDao.save(window);
                    }
                    for (int heaterNum = 0; heaterNum < Math.floor(Math.random() * 6 + 2); heaterNum++) {
                        Heater heater = new Heater();
                        heater.setRoom(room);
                        heater.setName("H_" + floor + "" + roomNum + "" + heaterNum);
                        heater.setStatus(Math.random() < 0.5 ? Status.ON : Status.OFF);
                        heater.setPower((long) Math.floor((Math.random() * 1000 + 500)));
                        heaterDao.save(heater);
                    }
                }
            }

        }
    }
}
