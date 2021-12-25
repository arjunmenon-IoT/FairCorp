package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WindowDao extends JpaRepository<Window,Long>{

    List<Window> findAllByStatus(WindowStatus windowStatus);
    @Query("select w from Window w where w.status = ?1 and w.room.id = ?2")
    List<Window> findAllByStatusAndRoom(WindowStatus windowStatus, long id);
}
