package com.emse.spring.faircorp.service;

import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;
import com.emse.spring.faircorp.model.Window;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class WindowService {

    @Autowired
    WindowDao windowDao;

    ArrayList<Window> getAllOpenWindows(){
        return (ArrayList<Window>) windowDao.findAllByStatus(WindowStatus.OPEN);
    }

    ArrayList<Window> getAllOpenWindowsByRoom(long id){
        return (ArrayList<Window>) windowDao.findAllByStatusAndRoom(WindowStatus.OPEN,id);
    }


}
