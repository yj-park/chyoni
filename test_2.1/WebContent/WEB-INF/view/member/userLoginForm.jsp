<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
	body {
	  background: #eee !important;
	}
	
	.wrapper {
	  margin-top: 80px;
	  margin-bottom: 80px;
	}
	
	.form-signin {
	  max-width: 380px;
	  padding: 15px 35px 45px;
	  margin: 0 auto;
	  background-color: #fff;
	  border: 1px solid rgba(0, 0, 0, 0.1);
	}
	.form-signin .form-signin-heading,
	.form-signin .checkbox {
	  margin-bottom: 30px;
	}
	.form-signin .checkbox {
	  font-weight: normal;
	}
	.form-signin .form-control {
	  position: relative;
	  font-size: 16px;
	  height: auto;
	  padding: 10px;
	  -webkit-box-sizing: border-box;
	  -moz-box-sizing: border-box;
	  box-sizing: border-box;
	}
	.form-signin .form-control:focus {
	  z-index: 2;
	}
	.form-signin input[type="text"] {
	  margin-bottom: -1px;
	  border-bottom-left-radius: 0;
	  border-bottom-right-radius: 0;
	}
	.form-signin input[type="password"] {
	  margin-bottom: 20px;
	  border-top-left-radius: 0;
	  border-top-right-radius: 0;
	}
	.checkbox > input {
		margin-top: 1px !important;
    	margin-bottom: 1px !important;
    }
    
    .checkbox {
    	width: 100px !important;
    	margin-left: -20 !important;
    	margin-left: 15px !important;
    }
</style>
</head>
<body>
	<div class="wrap">
	<c:import url="/jsp/include/topMenu2.jsp" />
	<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.2.js" charset="utf-8"></script>
		
	<div id="content" class="product">
		<div class="proList">
	    	<div class="option">
		    <div class="wrapper">
		    	<input type="hidden" name="msg" id="msg" value="${msg}" />
			    <form class="form-signin" id="frm" action="${pageContext.request.contextPath}/user/login" method="post" target="ifrm">  
			    	<input type="hidden" name="loginType" value="me" />     
				    <h2 class="form-signin-heading">로그인</h2>
				    <input type="text" class="form-control" id="id" name="id" placeholder="아이디 입력" required="아이디를 입력하세요." autofocus="" />
				    <input type="password" class="form-control" id="password" name="password" placeholder="비밀번호 입력" required=""/>      
				    <label class="checkbox">
				    <input type="checkbox" id="autoType" name="autoType" value="N"> 로그인 상태 유지
				    </label>
				    <button class="btn btn-lg btn-primary btn-block" id="btnLogin">로그인</button>
				    <br>
					<!-- 네이버아이디로로그인 버튼 노출 영역 -->
					SNS 계정으로 간편 로그인
					<br>
					<br>
					<div id="naver_id_login"></div>
					<!-- //네이버아이디로로그인 버튼 노출 영역 -->
			    </form>
		    </div>

<!-- 네이버아디디로로그인 초기화 Script -->
<script type="text/javascript">
	var naver_id_login = new naver_id_login("uhAftfrXFj4WLSj4v1Zi", "http://bit-hojohe.com:9090/mini1-team5/jsp/view/user/userCallback.jsp");
	var state = naver_id_login.getUniqState();
	naver_id_login.setButton("white", 1, 40);
	naver_id_login.setDomain(".bit-hojohe.com");
	naver_id_login.setState(state);
	naver_id_login.setPopup();
	naver_id_login.init_naver_id_login();
</script>
<!-- // 네이버아이디로로그인 초기화 Script -->
				
			
			</div>
		</div>
		
	</div>
	
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/user/userLoginForm.js"></script>
		
	<c:import url="/jsp/include/bottom2.jsp" />
	</div>
	<iframe style="display:none;" id="ifrm" name="ifrm"></iframe>
</body>
</html>