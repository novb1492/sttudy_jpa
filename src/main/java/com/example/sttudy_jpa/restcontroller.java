package com.example.sttudy_jpa;

import java.util.List;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.example.sttudy_jpa.QaTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class restcontroller {
    
	@Autowired
	private JPAQueryFactory jpaQueryFactory;
    
    @RequestMapping("/")
	@Transactional
    public void test4(){
		com.example.sttudy_jpa.QaTable qaTable=com.example.sttudy_jpa.QaTable.aTable;		
		System.out.println("update atable set text=? where a_id=?");
		List<aTable>aTables=jpaQueryFactory.selectFrom(qaTable).where(qaTable.aId.eq(Long.parseLong("1"))).fetch();
		for(aTable a:aTables){
			a.setText("updateText");
		}
		System.out.println("--------------------------------------------------");

	}
}
