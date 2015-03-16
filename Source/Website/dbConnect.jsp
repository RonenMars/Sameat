<%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %> <html>
<head>
<title>JDBC Connection example</title>
</head>

<body>
<h1>JDBC Connection example</h1>

<%
  try {
    java.sql.Connection con;
    Class.forName("org.gjt.mm.mysql.Driver");
    con = DriverManager.getConnection("jdbc:mysql://light-era.net:3307/rfwuryzg_sameatDB", "rfwuryzg_samUN", "xVt2TByc7");
    out.println ("database successfully opened.");
  }
  catch(SQLException e) {
    out.println("SQLException caught: " +e.getMessage());
  }
%>

</body>
</html>