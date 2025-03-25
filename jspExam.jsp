<%@page import="java.text.DecimalFormat"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "scott";
	String password = "tiger";

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	String sql = "SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO FROM EMP";%>
	<table width="800" border="1">
		<tr>
			<td>사원번호</td>
			<td>사원명</td>
			<td>직급</td>
			<td>상관번호</td>
			<td>입사일자</td>
			<td>급여</td>
			<td>커미션</td>
			<td>부서번호</td>
		</tr>
		<%
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				%>
					<tr>
						<!-- 사원번호 -->
						<td><%=rs.getInt("empno")%></td> 
						<!-- 사원명 -->
						<td><%=rs.getString("ename")%></td> 
						<!-- 직급 -->
						<td><%=rs.getString("job")%></td> 
						<!-- 상관번호 -->
						<td><%= rs.getString("mgr") %>
   						<!-- 입사일자 -->
						<td><%=rs.getString("hiredate")%></td> 
						<!-- 급여 -->
						<td> 
							<%
// 								소수점 0일때 제거
								DecimalFormat df = new DecimalFormat("#.##");
								Double sal = rs.getDouble("sal");
								out.print(df.format(sal));
							%>
						</td>
						<!-- 커미션 -->
						<td><%= rs.getString("comm") %>
						</td>
						<!-- 부서번호 -->
						<td><%=rs.getInt("deptno")%></td> 
					</tr>
				<%
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) conn.close();
			if (stmt != null) stmt.close();
			if (rs != null) rs.close();
		}
		%>
	</table>
</body>
</html>