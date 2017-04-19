import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by coldplay on 17-4-18.
 */
@WebServlet(name = "SignAbout")
public class SignAbout extends HttpServlet {
    private static final long serialVersionUID = 1L;
    // this is the username from sign in

    static final String JDBC_DRIVE = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/coldplay";

    static final String USER = "root";
    static final String PASS = "liaozhou1998";

    static boolean flag = false;

    public SignAbout() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String method = request.getParameter("method");

        Connection conn = null;
        Statement stmt = null;

        response.setContentType("text/html;charset=UTF-8");

        // 登录用户
        if (method == "signin") {
            try {
                Class.forName(JDBC_DRIVE);

                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = conn.createStatement();

                String sql = "SELECT * FROM user WHERE username='" + username + "';'";
                ResultSet rs = stmt.executeQuery(sql);

                if (rs.wasNull()) {

                } else {
                    while (rs.next()) {
                        if (rs.getString("password") == password) {
                            flag = true;
                            break;
                        }
                    }
                }

                stmt.close();
                conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (stmt != null) stmt.close();
                } catch (SQLException se) {
                    // nothing
                }
                try {
                    if (conn != null) conn.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }

            PrintWriter out = response.getWriter();
            // 登录成功
            if (flag) {
                request.setAttribute("username", username);

                if (username == "root") {
                    request.getServletContext().getRequestDispatcher("handlers_root.jsp").forward(request, response);
                } else {
                    request.getServletContext().getRequestDispatcher("handlers_root.jsp").forward(request, response);
                }
            }
            else {
                out.print("<center>" +
                        "<h1>登录失败！用户名或密码错误</h1>" +
                        "<br>" +
                        "<a href=\"signin.jsp\">登录</a>" +
                        "<br>" +
                        "<a href=\"signup.jsp\">注册</a>" +
                        "</center>");
            }
        }
        // 注册用户
        else {
            String address = request.getParameter("address");
            String phonenum = request.getParameter("phonenum");

            try {
                Class.forName(JDBC_DRIVE);

                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = conn.createStatement();

                String sql = "INSERT INTO user VALUE('" + username + "', '" + password + "', '" + address + "', '" + phonenum + "');";
                stmt.execute(sql);

                stmt.close();
                conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (stmt != null) stmt.close();
                } catch (SQLException se) {
                    // nothing
                }
                try {
                    if (conn != null) conn.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
    }
}
