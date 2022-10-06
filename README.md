# Utzza : 웃짜😄
<pre><code>👤 개인 프로젝트
📆 2022.04 - 2022.09 
</code></pre>


### *💫 짤방 모음 웹 애플리케이션*
  
> _**짤방 또는 짤**은 이미지 형태로 된 Meme으로 인터넷 상의 이미지나 움직이는 Gif 파일을 의미합니다.  
> 웃짜는 짤을 **키워드별로 검색**하여 편리하게 **조회 · 저장**할 수 있도록 개발한 **웹 애플리케이션** 입니다.  
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
<img src="https://user-images.githubusercontent.com/84697687/193759005-bd741b7c-c78a-4861-8893-f2ba51d26fb3.PNG" width="700" height="341"/>

- 조회수가 많은 순서대로 짤의 리스트를 출력합니다.  
- 각 짤에는 키워드가 등록되어 있어 같은 키워드의 짤 리스트로 쉽게 이동이 가능합니다.  
- 더보기 버튼을 클릭하여 더 많은 짤을 비동기적으로 불러올 수 있습니다.  
<br/><br/>

### 2. 회원 관리  
<img src="https://user-images.githubusercontent.com/84697687/193752461-5c33b28d-c676-42bc-9395-5b8f18a87803.png" width="700" height="341"/>
<img src="https://user-images.githubusercontent.com/84697687/193753801-4ff24cbd-ae60-48ad-95fb-73a6f1f308c6.png" width="700" height="341"/>
<img src="https://user-images.githubusercontent.com/84697687/193753810-52189928-dd04-4366-883b-09c38eb620fc.png" width="700" height="341"/>

- 회원가입 및 로그인, 로그아웃 기능을 제공합니다.  
- 로그인 시 로그인 상태 유지 여부를 체크하면 세션이 완료되기 전까지 로그인 상태를 유지할 수 있습니다.  
- 마이페이지를 통해 비밀번호를 변경할 수 있습니다.  
- 로그인한 회원에게만 자유게시판에 글과 댓글을 작성할 수 있는 권한이 주어집니다.  
- Spring Security를 통해 회원 관리 기능을 구현했습니다.
<br/><br/>

### 3. 이미지 조회
<img src="https://user-images.githubusercontent.com/84697687/193754670-7c069149-7988-40f8-848e-21d2d653215a.png" width="700" height="341"/>
<img src="https://user-images.githubusercontent.com/84697687/193754679-efa00d3c-b23f-4128-b7d0-df33df8240bd.png" width="700" height="341"/>

- 상단의 검색창에 키워드를 입력하여 원하는 짤을 검색할 수 있습니다.
- 테마별 짤, 상황별 짤 메뉴를 통해서 항목별로 분류되어있는 짤을 볼 수 있습니다.
<br/><br/>

### 4. 이미지 저장
<img src="https://user-images.githubusercontent.com/84697687/193755044-f2a5d6bc-24cd-4b25-b674-98e6baf0e7d4.PNG" width="700" height="341"/>

- 짤을 클릭하면 이미지의 원본과 키워드 전체를 볼 수 있습니다. 
- 이미지 하단의 저장 버튼을 클릭하면 나의 PC에 짤을 쉽게 저장할 수 있습니다.
<br/><br/>

### 5. 이미지 등록
<img src="https://user-images.githubusercontent.com/84697687/193755085-da5f12db-140e-4fd8-9791-4e98e9f1ba9a.png" width="700" height="341"/>

- 등록하고자 하는 짤을 첨부하고 그에 맞는 분류항목과 키워드를 입력하여 짤을 직접 등록할 수 있습니다.
<br/><br/>

### 6. 게시판
<img src="https://user-images.githubusercontent.com/84697687/193755213-4d82cb9e-4015-4704-b4a9-26e075d2e824.png" width="700" height="341"/>
<img src="https://user-images.githubusercontent.com/84697687/193755294-497429c3-242d-40fe-a99c-b6ab8978a164.png" width="700" height="341"/>

- 관리자만 작성할 수 있는 공지사항 게시판과 회원들이 이용할 수 있는 자유게시판으로 나누어져있습니다.
- 기본적으로 CRUD가 가능한 게시판으로 자유게시판은 댓글을 작성할 수 있습니다.
<br/><br/>

## 🗃 ERD 설계
<img src="https://user-images.githubusercontent.com/84697687/193048171-dded2043-81e9-4aff-892d-4ad71934e5b9.png" width="446" height="400"/>
<br/>

## 💦 어려웠던 점
- 더보기 버튼을 통해 짤의 리스트를 **비동기적**으로 불러올 때 리스트 데이터의 구조가 복잡하여 view단에 값을 넘겨주는 것이 어려웠습니다. 이미지 리스트의 데이터는 각각 객체의 형태로 이루어져 있고 그 객체 내에는 배열 데이터가 포함되어 있으므로 구조가 복잡했습니다. 이를 해결하기 위해 **JSONArray와 JSONObject**를 사용하여 원하는 json 데이터의 형태로 만들었고, view단에서는 ajax의 each 함수를 통해 값을 뿌려주었습니다.
```java
@ResponseBody
@GetMapping("…")
public String moreList(…) {
    …
    JSONArray jary = new JSONArray();
    if (list.isEmpty()) {
        jary.put("none");
    } else {
        for (Image img : list) {
            JSONObject json = new JSONObject();
            JSONArray titleArr = new JSONArray();
            for (String t : img.getTitle()) {
                titleArr.put(t);
            }
            json.put("id", img.getId());
            json.put("title", titleArr);
            json.put("imgPath", img.getImgPath());
            json.put("hit", img.getHit());
            jary.put(json);
        }
    }
    return jary.toString();
}
```
<br/>

## ✏ 배운 점 & 아쉬운 점
* DB, Server, 화면을 포함한 웹 애플리케이션 전체를 혼자서 개발하며 어려움이 많았습니다. 하지만 그 과정에서 각각의 역할이나 웹 애플리케이션의 전체적인 사이클을 이해하는데 좋은 경험이 되었습니다. 
* 이미지를 검색할 때 이미지에 등록되어있는 키워드로만 검색을 해야 원하는 이미지가 나오는 점이 아쉽습니다. 검색어 추천 기능을 추가하여 검색의 효율성을 높이거나 딥러닝 기반의 이미지 분류 기술을 활용하여 체계적인 이미지 검색이 가능하도록 개발하면 더 좋은 서비스가 될 것이라고 생각합니다.

