1.query dsl 오류해결  
-https://www.inflearn.com/questions/355723  
2.q파일 만들기  
-vscode에서는   .\gradlew build 해야 q파일이 생긴다  

3.연관관계 jpa사용시 (manyToOne등)  lazy로 가져올때  
- could not initialize proxy - no Session 발생  
1.함수 위에 Transactional  
or
2.application.properties에spring.jpa.properties.hibernate.enable_lazy_load_no_trans=true  
추가한다   

4.Cannot add or update a child row (a foreign key constraint fails)
1.oneToMany=내 값을 설정한다  
ex)@JoinColumn(name = "a_id")  본인값  
2.manyToOne=외부 값을 설정한다  
ex)@JoinColumn(name = "a_id")  외부값  



