package main.java.History_work;

import java.sql.*;
import main.java.pages.*;

public class History_select {
    
    public static java.sql.Date f_select(int empno) {
        java.sql.Date dateRef = null;
        try {
            String sql = "SELECT DATE_REF FROM HISTORY WHERE EMPNO = ? AND WHERE DATE_REF IS NULL";
            Connection conn = new DBconnection().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, empno);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                dateRef = rs.getDate("DATE_REF");
            }

            conn.commit();
            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateRef;
    }    
}
