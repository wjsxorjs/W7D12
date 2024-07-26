<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
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
    <h1>로그인 페이지</h1>
    <hr/>
    <div id="box">
        <form action="/reqLogin" method="post">
            <table summary="로그인테이블">
                <caption>로그인테이블</caption>
                <tbody>
                    <tr>
                        <th>아이디: </th>
                        <td>
                            <input type="text" name="m_id" id="m_id" />
                        </td>
                    </tr>
                    <tr>
                        <th>비밀번호: </th>
                        <td>
                            <input type="password" name="m_pw" id="m_pw" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="button" onclick="sendData(this.form)" id="btn" value="로그인"/>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>

    </div>


    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    <script>
        $(function(){
            <c:if test="${status eq 1}"> 
                alert("아이디 또는 비밀번호가 일치하지 않습니다.");
            </c:if>
        });

        function sendData(ff){
            let mid = $("#m_id").val();
            let mpw = $("#m_pw").val();

            if(mid.trim().length < 1){
                alert("아이디를 입력하세요.");
                $("#m_id").val("");
                $("#m_id").focus();
                return;
            }

            if(mpw.trim().length < 1){
                alert("비밀번호를 입력하세요.");
                $("#m_pw").val("");
                $("#m_pw").focus();
                return;
            }

            ff.submit();
        }
    </script>

</body>
</html>