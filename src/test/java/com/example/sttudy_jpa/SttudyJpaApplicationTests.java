package com.example.sttudy_jpa;

import java.util.List;

import javax.persistence.EntityManager;
import com.example.deliveryRoomDao;
import com.querydsl.core.types.QList;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SttudyJpaApplicationTests {

	@Autowired
	private JPAQueryFactory jpaQueryFactory;

	@Test
	void contextLoads() {
	}
	@Test
	void test(){
		QdeliverRoomDetailVo QdeliverRoomDetailVo=com.example.sttudy_jpa.QdeliverRoomDetailVo.deliverRoomDetailVo;
		QdeliveryRoomVo qdeliveryRoomVo=QdeliveryRoomVo.deliveryRoomVo;
		
	  	List<deliverRoomDetailVo>list=jpaQueryFactory.select(QdeliverRoomDetailVo.mchtTrdNo,qdeliveryRoomVo.companyId).From(QdeliverRoomDetailVo).leftJoin(qdeliveryRoomVo).on(QdeliverRoomDetailVo.roomId.eq(qdeliveryRoomVo.roomId)).where(QdeliverRoomDetailVo.roomId.eq(22)).fetch();
		System.out.println(list.toString());
	}

}
