package com.example.sttudy_jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "dtable")
@Entity
public class dTable {
    @Id
    @OneToOne(fetch = FetchType.LAZY)
    private cTable cTable;

    @Column(name = "testa")
    private String testa;
}
