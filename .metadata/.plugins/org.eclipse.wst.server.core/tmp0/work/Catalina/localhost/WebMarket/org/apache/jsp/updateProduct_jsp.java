/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.22
 * Generated at: 2019-08-30 06:08:43 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.sql.*;

public final class updateProduct_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/dbconn.jsp", Long.valueOf(1567135665433L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"./resources/css/bootstrap.min.css\"/>\r\n");
      out.write("\t<title>상품 수정</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "menu.jsp", out, false);
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"jumbotron\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<h1 class=\"display-3\">상품 수정</h1>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\r\n");

	Connection conn = null;

	try {
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // ë§ëì§ íì¸í  ê²
		String user = "madang";
		String password = "madang";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, user, password);
		
	} catch (SQLException ex) {
		out.println("ë°ì´í°ë² ì´ì¤ ì°ê²°ì´ ì¤í¨íìµëë¤.<br>");
		out.println("SQLException: " + ex.getMessage());
	}

      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t");

		String productId = request.getParameter("id");
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from product where p_id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, productId);
		rs = pstmt.executeQuery();
		if (rs.next()) {
	
      out.write("\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t<div class=\"col-md-5\">\r\n");
      out.write("\t\t\t\t<img src=\"./resources/images/");
      out.print(rs.getString("p_filename") );
      out.write("\" alt=\"image\" style=\"width: 100%\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"col-md-7\">\r\n");
      out.write("\t\t\t\t<form name=\"newProduct\" action=\"./processUpdateProduct.jsp\" class=\"form-horizontal\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group row\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"col-sm-2\">상품 코드</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-3\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" id=\"productId\" name=\"productId\" class=\"form-control\" value='");
      out.print(rs.getString("p_id"));
      out.write("'>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group row\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"col-sm-2\">상품명</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-3\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" id=\"name\" name=\"name\" class=\"form-control\" value='");
      out.print(rs.getString("p_name"));
      out.write("'>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group row\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"col-sm-2\">가격</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-3\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" id=\"unitPrice\" name=\"unitPrice\" class=\"form-control\" value='");
      out.print(rs.getInt("p_unitPrice"));
      out.write("'>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group row\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"col-sm-2\">상세 설명</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-5\">\r\n");
      out.write("\t\t\t\t\t\t\t<textarea name=\"description\" cols=\"50\" rows=\"2\" class=\"form-control\">");
      out.print(rs.getString("p_description"));
      out.write("</textarea>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group row\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"col-sm-2\">제조사</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-3\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"manufacturer\" class=\"form-control\" value='");
      out.print(rs.getString("p_manufacturer"));
      out.write("'>\t<!-- id값 없는 게 맞나? -->\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group row\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"col-sm-2\">분류</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-3\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"category\" class=\"form-control\" value='");
      out.print(rs.getString("p_category"));
      out.write("'>\t<!-- id값 없는 게 맞나? -->\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group row\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"col-sm-2\">재고 수</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-3\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" id=\"unitsInStock\" name=\"unitsInStock\" class=\"form-control\" value='");
      out.print(rs.getLong("p_unitsInStock"));
      out.write("'>\t<!-- Long 써도 되나? -->\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group row\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"col-sm-2\">상태</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-5\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"radio\" name=\"condition\" value=\"New\">신규 제품\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"radio\" name=\"condition\" value=\"Old\">중고 제품\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"radio\" name=\"condition\" value=\"Refurbished\">재생 제품\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group row\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"col-sm-2\">이미지</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-5\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"file\" name=\"productImage\" class=\"form-control\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group row\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-offset-2 col-sm-10\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"submit\" class=\"btn btn-primary\" value=\"등록\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t");

		}
		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();
	
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}