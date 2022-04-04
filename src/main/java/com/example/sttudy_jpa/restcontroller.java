package com.example.sttudy_jpa;

import java.util.List;

import com.querydsl.jpa.impl.JPAQueryFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class restcontroller {
    
	@Autowired
	private JPAQueryFactory jpaQueryFactory;
	@Autowired
	private service service;
    
    @RequestMapping("/")
	@Transactional
    public void test4(){
		QaTable qaTable=QaTable.aTable;		
		System.out.println("update atable set text=? where a_id=?");
		List<aTable>aTables=jpaQueryFactory.selectFrom(qaTable).where(qaTable.aId.eq(Long.parseLong("1"))).fetch();
		for(aTable a:aTables){
			List<bTable>bTables=a.getBTables();
			a.setText("updateText2");
			name(bTables);
		}
		System.out.println("--------------------------------------------------");
		//throw new RuntimeException("rollbackTest");
	}
	private void name(List<bTable>bTables) {
		for(bTable b:bTables){
			b.setReply("replyupdate23");
		}
	}
}
