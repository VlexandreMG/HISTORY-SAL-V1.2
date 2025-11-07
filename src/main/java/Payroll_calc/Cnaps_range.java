package main.java.Payroll_calc;

import java.sql.*;
import main.java.pages.DBconnection;

public class Cnaps_range {

    public static double f_range(double percent) {
        String sql = "SELECT MINIMAL , MAXIMAL FROM CONF_CNAPS";
        double minimal = 0.0;
        double maximal = 0.0;
        
        try {
            Connection conn = new DBconnection().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                minimal = rs.getDouble("MINIMAL");
                maximal = rs.getDouble("MAXIMAL");
            }

            conn.commit();
            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

            if (percent < minimal) {
                return minimal;
            } else if (percent > maximal) {
                return maximal;
            } else if (percent >= minimal && percent <= maximal) {
                return percent;
            }   
        return percent;
    }
}
