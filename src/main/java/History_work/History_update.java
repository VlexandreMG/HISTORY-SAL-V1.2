package main.java.History_work;

import java.sql.*;

import main.java.pages.DBconnection;

public class History_update {
    public static java.sql.Date f_update(int empno, java.sql.Date date){
        String sql = "UPDATE HISTORY SET DATE_REF = ? WHERE EMPNO = ?";
        
        try {
            Connection conn = new DBconnection().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDate(1, date);
            pstmt.setInt(2, empno);

            pstmt.executeUpdate();
            
            conn.commit();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }
}
