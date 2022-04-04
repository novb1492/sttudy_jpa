package com.example.sttudy_jpa;

import java.util.List;

import javax.persistence.EntityManager;

import com.querydsl.core.Tuple;
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
	@Autowired
	private aDao aDao;



	@Test
	void test2(){
		QaTable qaTable=QaTable.aTable;
		QbTable qbTable=QbTable.bTable;
		List<aTable>aTables=jpaQueryFactory.selectFrom(qaTable).leftJoin(qbTable).fetchJoin().on(qaTable.aId.eq(qbTable.aTable.aId)).where(qaTable.aId.eq(Long.parseLong("1"))).fetch();
		for(aTable a:aTables){
			List<bTable>bTables=a.getBTables();
			for(bTable b:bTables){
				//System.out.println(b.getReply());
			}
		}
	}
	@Test
	void test3(){
		QaTable qaTable=QaTable.aTable;
		System.out.println("select *from atable where aid=?");
		System.out.println(jpaQueryFactory.selectFrom(qaTable).where(qaTable.aId.eq(Long.parseLong("1"))).fetch().get(0).getText());
		System.out.println("----------------------------------");
	}
	@Test
	//@Transactional
	void test4(){
		QaTable qaTable=QaTable.aTable;		
		System.out.println("update atable set text=? where a_id=?");
		List<aTable>aTables=jpaQueryFactory.selectFrom(qaTable).where(qaTable.aId.eq(Long.parseLong("1"))).fetch();
		for(aTable a:aTables){
			a.setText("updateText");
		}
		System.out.println("--------------------------------------------------");
	}
	@Test
	void test5(){
		QaTable qaTable=QaTable.aTable;
		QbTable qbTable=QbTable.bTable;
		List<Tuple>tuples=jpaQueryFactory.select(qaTable,qbTable).from(qaTable).leftJoin(qbTable).on(qbTable.aTable.aId.eq(qaTable.aId))
		.where(qaTable.aId.eq(Long.parseLong("1"))).orderBy(qbTable.Id.desc()).offset(getStart(2, 2)-1).limit(2).fetch();
		//넣는 객체대로 get/set메소드가 생김 실화임?
		for(Tuple t:tuples){
			System.out.println(t.get(qaTable).getText());
			System.out.println(t.get(qbTable).getReply());
		}
	}
	public  int getStart(int page,int pageSize) {
        return (page-1)*pageSize+1;//+1 이있는 이유는 1페이질때 대응하기 위해이다  
    }

}
