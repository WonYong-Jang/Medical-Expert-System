# Medical-Expert-System


### 메디컬 Expert 시스템을 위한 Drools와 JavaFX 기반의 사용자 인터페이스 설계 및 구현 (정보처리학회 추계학술대회 2017-11-04)

본 논문은 Medical Expert 시스템을 효율적으로 운영하기 위해서 Drools 와 JavaFX기반으로 한 사용자 인터페이스를 설계 및 구현을 한다. 본 Medical Expert System을 구축하기 위하여 Drools의 내부의 구조인 BlackBoard 아키텍처 스타일을 이해하고 JavaFX을 이용하여 Medical Expert 시스템을 설계 및 구현 하였다. 이 시스템의 진행 프로세스는, 설문지 및 환자 진단으로 인해 환자에 대한 증상정보들을 파악 후 미리 정해 둔 rule들에 적용시켜서 그 결과 값을 도출한다. 또한 본 시스템은 JavaFX에 scene builder 이용하여 인터페이스를 구성함으로써 기존의 Swing의 단점을 보완하고 장점을 부각시키도록 구현하였다.

### Drools 기반의 메디컬 Expert 시스템 아키텍처와 프로세스 연구 (정보처리학회 추계학술대회 2017-11-04)

본 논문은 병원에서 환자가 내원할 때 의사에게 환자 진단과 처방을 지원을 할 수 있는 메디컬 시스템에 대한 연구를 하였다. 메디컬 프로세스를 고려한 환자의 증상에 대한 파악과 진단, 처방에 이르기까지의 지원할 수 있는 병원의 증상 진단 지원 Expert System을 연구한다. 본 Expert System을 구축하기 위하여 오픈소스 프로젝트인 Drools를 사용하였다. 본 시스템은 시스템 운영 중, 병원에서 사용하는 증상 진단 지원 rule들을 용이하게 추가하며 사용할 수 있도록 하며, 사용한 Drools의 호환성 해결과 다양한 기능성을 사용하기 위해 Maven을 이용한 증상 진단 지원 Expert System을 설계하였다. 이 시스템의 전체 구성 시스템 아키텍처뿐만 아니라, 환자가 증상을 입력한 이후의 환자 증상, 진단, 처방에 이르기까지의 병원에서 일어나는 프로세스를 구현 및 연구를 하였다.

**관련 링크** ==> http://www.eiric.or.kr/community/post2.php?m=view&gubun=201707&num=11168&pg=16&seGubun=&seGubun1=&SnxGubun=%B1%B8%B5%CE&searchBy=&searchWord=

![1234567](https://user-images.githubusercontent.com/26623547/38420093-34964aa8-3992-11e8-8a3e-c00376b94ead.JPG)


### Drools를 이용한 Nginx와 Ajax기반의 Medical Expert System 개발 (정보처리학회 춘계학술대회 / 2018-5-12)

본 논문은 웹 기반의 Medical Expert System을 위하여, 오픈 소스 Drools 기반으로 Spring MVC 프레임워크와 Ajax를 이용하여 구현하였다. 클라이언트와 서버 간에 비동기적 통신으로 JSON 데이터를 주고받아 서버의 부담을 감소하였으며, 데이터베이스 접근은 기존의 복잡한 JDBC 단점을 보완하고자 Mybatis 프레임워크를 적용하여 RDBMS 의 성능을 향상시켰다. 또한, 웹 기반의 장점을 최대한 활용하여 사용자 수가 늘어남에 따라 서버 트래픽 문제를 해결하기 위하여 Nginx를 이용한 로드밸런싱 구조를 구축하여 서버의 가용성을 확대하였다. 본 Medical Expert 시스템의 처리 프로세스는 일반 사용자가 웹으로 접근하여 설문을 작성한 후 기본적인 진단 및 평가를 제공하여 주는 서비스를 제공한다.	

**팀 프로젝트 주소** ==> https://github.com/kookmin-sw/2018-cap1-4
**관련 링크**==> https://www.eiric.or.kr/community/post2.php?m=view&gubun=201803&num=14230&pg=1&seGubun=5&seGubun1=&SnxGubun=%B1%B8%B5%CE&searchBy=&searchWord=