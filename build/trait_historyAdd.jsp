<%@ page import="main.java.History_work.*, java.sql.*, main.java.Emp_work.*" %>

<% 
    String empno = request.getParameter("empno");
    java.sql.Date date = java.sql.Date.valueOf(request.getParameter("date_ref"));
    String valeur = request.getParameter("valeur");
    String idRubrique = request.getParameter("idRubrique");

    int empno2 = Integer.parseInt(empno);
    int valeur2 = Integer.parseInt(valeur);
    int idRubrique2 = Integer.parseInt(idRubrique);

    try {
        History_insert.f_insert(empno2, date, valeur2, idRubrique2);
        out.println("Insertion réussie !");
    } catch (Exception e) {
        out.println("Erreur : " + e.getMessage());
    }
    Thread.sleep(2);
    response.sendRedirect("index.jsp");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h2>Ajout effectué !</h2>
</body>
</html>