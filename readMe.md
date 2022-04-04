1.query dsl 오류해결  
-https://www.inflearn.com/questions/355723  
2.q파일 만들기  
-vscode에서는   .\gradlew build 해야 q파일이 생긴다  
3.연관관계 jpa사용시 (manyToOne등)  lazy로 가져올때  
-함수 위에 Transactional  붙혀줘야 한다  
안그러면 could not initialize proxy - no Session 발생  
