package main.java.History_work;

import java.sql.*;

import main.java.Emp_work.Emp_getsalbyid;
import main.java.pages.DBconnection;

public class History_insert {
    
    public static void f_insert(int empno ,java.sql.Date date, int valeur , int idRubrique) throws SQLException {

        int sal = Emp_getsalbyid.f_get(empno);
        java.sql.Date dateNull = History_select.f_select(empno);
        java.sql.Date updatedDate = History_update.f_update(empno, date);

        Connection conn = new DBconnection().getConnection();
        System.out.println(conn);

        if ((sal != valeur) && 
            (dateNull == null) &&
            (updatedDate != date)) {

        History_select.f_select(empno);
        History_update.f_update(empno, date);

        String sql = "INSERT INTO HISTORY (EMPNO, DATE_REF, VALEUR, ID_RUBRIQUE) VALUES (?, NUll, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs2 = pstmt.executeQuery(sql);

        while (rs2.next()) {
            pstmt.setInt(1, empno);
            pstmt.setInt(2, valeur);
            pstmt.setInt(3, idRubrique);
        }

        conn.commit();
        rs2.close();
        pstmt.close();
        conn.close();

        } else if (sal == valeur) {
            System.out.println("Le salaire est identique, insertion non effectuée.");
        }
    }
 
}
