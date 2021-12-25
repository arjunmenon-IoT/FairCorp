package com.emse.spring.faircorp;

import com.emse.spring.faircorp.dao.*;
import com.emse.spring.faircorp.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Properties;

@SpringBootTest
class FaircorpApplicationTests {

    @Autowired
    BuildingDao buildingDao;
    @Autowired
    RoomDao roomDao;
    @Autowired
    DoorDao doorDao;
    @Autowired
    WindowDao windowDao;
    @Autowired
    HeaterDao heaterDao;

    @Test
    void init() {
        Building emse = new Building();
        emse.setName("EMSE");
        emse = buildingDao.save(emse);

        Building currentBuilding = emse;
        int floorCount=4;
        int[] roomCountPerFloor = {2,4,4,4};
        for (int floor = 0; floor<floorCount; floor++){
            for (int roomNum=0;roomNum<roomCountPerFloor[floor];roomNum++){
                Room room = new Room();
                room.setBuilding(currentBuilding);
                room.setFloor(floor);
                room.setName("Room_"+floor+"_"+roomNum);
                room.setTargetTemperature(20d);
                room.setCurrentTemperature(Math.random()*15+5);
                room=roomDao.save(room);
                for (int doorNum=0;doorNum<Math.floor(Math.random()*3+1);doorNum++){
                    Door door = new Door();
                    door.setRoom(room);
                    door.setName("Door_"+floor+"_"+roomNum+"_"+doorNum);
                    door.setStatus(Math.random()<0.5?DoorStatus.OPEN:DoorStatus.CLOSED);
                    doorDao.save(door);
                }
                for (int windowNum=0;windowNum<Math.floor(Math.random()*6+2);windowNum++){
                    Window window = new Window();
                    window.setRoom(room);
                    window.setName("Window_"+floor+"_"+roomNum+"_"+windowNum);
                    window.setStatus(Math.random()<0.5?WindowStatus.OPEN:WindowStatus.CLOSED);
                    windowDao.save(window);
                }
                for (int heaterNum=0;heaterNum<Math.floor(Math.random()*6+2);heaterNum++){
                    Heater heater = new Heater();
                    heater.setRoom(room);
                    heater.setName("Heater_"+floor+"_"+roomNum+"_"+heaterNum);
                    heater.setStatus(Math.random()<0.5?Status.ON:Status.OFF);
                    heater.setPower((long) Math.floor((Math.random()*1000+500)));
                    heaterDao.save(heater);
                }
            }
        }

    }

}
