package main.java.Payroll_calc;

import java.sql.*;
import main.java.pages.DBconnection;

public class Cnaps_percent {
    
    public static double f_percent(double gain) {
        String sql = "SELECT PERCENTAGEU FROM CONF_CNAPS";
        double percentage = 0.0;
        try {
            Connection conn = new DBconnection().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                percentage = rs.getDouble("PERCENTAGEU");
            }

            conn.commit();
            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gain * (percentage / 100);
    }
}
