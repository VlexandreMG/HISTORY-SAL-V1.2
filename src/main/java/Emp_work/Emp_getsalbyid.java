package main.java.Emp_work;

import java.sql.*;

import main.java.pages.DBconnection;

public class Emp_getsalbyid {

    public static int f_get(int empno) throws SQLException {
        int salary = 0;
        Connection conn = new DBconnection().getConnection();
        String sql = "SELECT sal FROM EMP WHERE EMPNO = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, empno);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            salary = rs.getInt("sal");
        }
        rs.close();
        pstmt.close();
        conn.close();
        return salary;
    }
}
