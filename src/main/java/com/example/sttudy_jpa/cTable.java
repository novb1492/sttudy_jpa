package com.example.sttudy_jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "ctable")
@Entity
public class cTable {
    
    @Id
    @Column(name = "c_id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cId;

    @Column(name = "email",nullable = true)
    private String email;
}
