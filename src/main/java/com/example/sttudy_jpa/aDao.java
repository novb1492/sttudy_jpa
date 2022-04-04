package com.example.sttudy_jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface aDao extends JpaRepository<aTable,Long> {
    
    @Modifying
    @Transactional
    @Query(value = "update atable set text=? where a_id=?",nativeQuery = true)
    void updateTextById(String text,Long id);
}
