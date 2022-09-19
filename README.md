# Utzza : 웃짜😄
<pre><code> 📆 2022.04 - 2022.09 </code></pre>


### *💫 짤방 모음 웹 애플리케이션*
  
> _**짤방**이란 이미지 형태로 된 밈으로 인터넷 상의 이미지나 움직이는 Gif 파일을 의미합니다.  
> 웃짜는 짤방을 **키워드별로 검색**하여 편리하게 **조회 · 저장**할 수 있도록 개발한 **웹 애플리케이션** 입니다.  
> 10-20대들이 인터넷 커뮤니티나 SNS에서 많이 사용하는 짤을 한 곳에 모아  
> 필요할 때 **상황에 맞는 짤**을 사용할 수 있도록 하는 것을 목표로 했습니다._  
<br/>

<img src="https://user-images.githubusercontent.com/84697687/189930060-df98eed8-8ec5-49b6-90a4-d37ed0584961.png" width="800" height="431"/>
🔗 <a href="https://utzza.herokuapp.com/">Utzza</a>
<br/><br/>

## 🔧 사용 기술
* ### Front-end
<img src="https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white"> <img src="https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=CSS3&logoColor=white"> <img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=white"> <img src="https://img.shields.io/badge/Thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white"> <img src="https://img.shields.io/badge/jquery-0769AD?style=for-the-badge&logo=jquery&logoColor=white">
* ### Back-end
<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> <img src="https://img.shields.io/badge/Springboot-6DB33F?style=for-the-badge&logo=Springboot&logoColor=white"> <img src="https://img.shields.io/badge/SpringSecurity-6DB33F?style=for-the-badge&logo=SpringSecurity&logoColor=white">
* ### DB
<img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white"> <img src="https://img.shields.io/badge/MyBatis-black?style=for-the-badge&logo=mybatis&logoColor=white">
* ### Server & Storage
<img src="https://img.shields.io/badge/Heroku-430098?style=for-the-badge&logo=heroku&logoColor=white"> <img src="https://img.shields.io/badge/Cloudinary-3448C5?style=for-the-badge&logo=&logoColor=white">
<br/><br/>

## ⚙ 구현 기능
### 1. 메인 페이지
조회수가 많은 순서대로 짤의 목록을 보여줍니다. 각 짤에는 키워드가 등록되어 있어 같은 키워드의 짤 목록으로 쉽게 이동할 수 있습니다.
### 2. 회원 관리
회원가입 및 로그인, 로그아웃이 가능하고 로그인 시 로그인 상태 유지 여부를 체크하면 세션이 완료되기 전까지 로그인 상태가 유지됩니다. 마이페이지에서 비밀번호를 변경할 수 있고 로그인한 회원만 자유게시판에 글과 댓글을 작성할 수 있습니다. 회원 관리 기능은 Spring Security를 통해 구현하였습니다.
### 3. 이미지 조회
상단의 검색창에 키워드를 입력하여 원하는 짤을 찾아볼 수 있습니다. 또한, 테마별 짤, 상황별 짤 메뉴를 통해서 항목별로 분류되어있는 짤을 확인할 수 있습니다.
### 4. 이미지 저장
짤을 클릭하면 이미지의 원본과 키워드 전체를 볼 수 있는 페이지로 이동합니다. 이미지 하단의 저장 버튼을 클릭하면 나의 PC에 짤을 쉽게 저장할 수 있습니다.
### 5. 이미지 등록
등록하고자 하는 짤을 첨부하고 그에 맞는 분류코드와 키워드를 입력할 수 있습니다.
### 6. 게시판
관리자만 작성할 수 있는 공지사항 게시판과 회원들이 이용할 수 있는 자유게시판으로 나누어져 있습니다. 기본적으로 CRUD가 가능한 게시판으로 자유게시판은 댓글도 작성할 수 있도록 했습니다.
<br/><br/>

## ✏ 배운 점 & 아쉬운 점
* DB, Server, 화면을 포함한 웹 애플리케이션 전체를 혼자서 개발하는 것은 쉬운 일이 아니었습니다. 하지만 그 과정에서 각 분야나 웹 애플리케이션의 전체적인 사이클을 이해하는데 좋은 경험이 되었습니다. 
* 이미지를 검색할 때 이미지에 등록되어있는 키워드로만 검색을 해야 원하는 이미지가 나오는 점이 아쉽습니다. 검색어 추천 기능을 추가하여 검색의 효율성을 높이거나 딥러닝 기반의 이미지 분류 기술을 활용하여 체계적인 이미지 검색이 가능하도록 개발하면 더 좋은 서비스가 될 것이라고 생각합니다.

