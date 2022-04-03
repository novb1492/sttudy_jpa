package com.example.sttudy_jpa;

import javax.persistence.EntityManager;

import com.querydsl.jpa.impl.JPAQueryFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class config {
    @Autowired
    private EntityManager em;

    @Bean
    public JPAQueryFactory jpaQueryFactory() {
       return new JPAQueryFactory(em);
    }
}
