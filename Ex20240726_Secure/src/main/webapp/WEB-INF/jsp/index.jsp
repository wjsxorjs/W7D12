<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
<style>
    #search{
        margin-bottom: 15px;
    }

    #t1{
        border: 1px solid black;
        border-collapse: collapse;
    }

    #t1 tbody{
        text-align: center;
    }

    #t1 th{
        border: 1px solid black;
        background-color: rgb(200, 200, 200);
        padding: 2px 10px;
    }

    #t1 td{
        border: 1px solid black;
        padding: 5px 10px;
    }
</style>
</head>
<body>
    <h1>메인페이지</h1>
    <hr/>
    <div id="box">
        <c:if test="${sessionScope.mvo ne null}">
            <a href="/mem_logout">로그아웃</a>
            <a href="/bbs">게시판</a>
        </c:if>
        <c:if test="${sessionScope.mvo eq null}">
            <a href="/login">로그인</a>
            <a href="/reg">회원가입</a>
        </c:if>

    </div>

</body>
</html>