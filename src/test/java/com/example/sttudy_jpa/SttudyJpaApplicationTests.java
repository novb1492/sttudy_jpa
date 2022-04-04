package com.example.sttudy_jpa;

import java.util.List;

import javax.persistence.EntityManager;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class SttudyJpaApplicationTests {

	@Autowired
	private JPAQueryFactory jpaQueryFactory;

	@Test
	void contextLoads() {
	}
	@Test
	//@Transactional
	void test(){
		QaTable qaTable=QaTable.aTable;
		QbTable qbTable=QbTable.bTable;
		List<aTable>aTables=jpaQueryFactory.selectFrom(qaTable).innerJoin(qbTable).on(qaTable.aId.eq(qbTable.bId)).where(qaTable.aId.eq(Long.parseLong("1"))).fetch();
		System.out.println("a테이블값만: "+aTables.get(0).getAId());
		//System.out.println("b테이블값 조인하기: "+aTables.get(0).getBTables().get(0).getBId());
	}

}
