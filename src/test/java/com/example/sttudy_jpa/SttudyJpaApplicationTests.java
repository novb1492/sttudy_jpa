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
	void test(){
		QaTable qaTable=QaTable.aTable;
		QbTable qbTable=QbTable.bTable;
		//select a.*,b.* from test.atable a inner join  test.btable b on b.a_table_a_id=a.a_id where a.a_id=1
		List<aTable>aTables=jpaQueryFactory.selectFrom(qaTable).leftJoin(qbTable).fetchJoin().on(qbTable.aTable.aId.eq(qaTable.aId)).where(qaTable.aId.eq(Long.parseLong("1"))).fetch();
		System.out.println("select a.*,b.* from test.atable a inner join  test.btable b on b.a_table_a_id=a.a_id where a.a_id=1");
		System.out.println("a테이블값만: "+aTables.get(0).getAId());
		//join값 조회시 select로 조회 즉 필요할때 가져옴 ㅎㄷㄷ 하다 
		for(aTable a:aTables){
			List<bTable>btables=a.getBTables();
			for(bTable b:btables){
				System.out.println("b테이블값 조인하기: "+b.getReply());
			}
		}
		System.out.println("-----------------------------------------------------------------");

	}
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
		List<Tuple>aTables=jpaQueryFactory.select(qaTable,qbTable).from(qaTable).leftJoin(qbTable).on(qbTable.aTable.aId.eq(qaTable.aId)).where(qaTable.aId.eq(Long.parseLong("1"))).orderBy(qbTable.Id.desc()).fetch();
		System.out.println(aTables.get(0).get(qbTable).getReply());
	}

}
