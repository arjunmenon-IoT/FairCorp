package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HeaterDao extends JpaRepository<Heater,Long> {

    @Modifying
    @Query("delete from Heater h where h.room.id =:roomId")
    void deleteHeatersByRoomId(@Param("roomId") Long id);

    Optional<Heater> findHeaterByName(String name);


}
