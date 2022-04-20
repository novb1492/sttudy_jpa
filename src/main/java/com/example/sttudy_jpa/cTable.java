package com.example.sttudy_jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ctable")
@Entity
public class cTable {
    @Id
    @OneToOne(fetch = FetchType.LAZY)
    private dTable dTable;

    @Column(name = "testa")
    private String testa;

}
