package main.java.Payroll_calc;

import java.sql.*;
import main.java.pages.DBconnection;   

public class Gain_sum {
    
    public static double f_gain() {
        String sql = "SELECT sal + avantages AS total_gain FROM EMP WHERE EMPNO = 7369";
        double total_gain = 0.0;
        try {
            Connection conn = new DBconnection().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                total_gain = rs.getInt("total_gain");
            }

            conn.commit();
            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total_gain;
    }
}
