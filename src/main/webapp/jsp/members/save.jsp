<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="hello.hellospring.domain.member.Member" %>
<%@ page import="hello.hellospring.domain.member.MemberRepository" %>
<%

    MemberRepository memberRepository = MemberRepository.getInstance();

    System.out.println("memberSaveServlet.service");
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(username, age);
    memberRepository.save(member);
%>
<html>
    <head>
        <title>TITLE</title>
    </head>
    <body>
        <div>성공</div>
        <ul>
            <li>id=<%=member.getId()%></li>
            <li>username=<%=member.getUsername()%></li>
            <li>age=<%=member.getAge()%></li>
        </ul>
        <a href="/index.html">메인</a>
    </body>
</html>
