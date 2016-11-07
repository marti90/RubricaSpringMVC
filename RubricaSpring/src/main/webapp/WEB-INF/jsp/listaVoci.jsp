<%@page import="it.dragon.Voce"%>
<%@page import="it.dragon.dao.VoceDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>
			Rubrica
		</title>
	</head>
<body>
		<h1>
			<a href="formRegistrazione.jsp"> Registra Voce </a>
		</h1>
		<table class="table table-striped table-bordered bootstrap-datatable datatable responsive">
 			<thead>
    			<tr>
	   				<th>Nome</th>
	   				<th>Cognome</th>
	   				<th>Importo</th>
	   				<th>Data emissione</th>
	   				
	   			</tr>
 			</thead>
 			<tbody>
	   			<%
					VoceDAO vd = new VoceDAO();
					List<Voce> voci = vd._selectAll();
					for(Voce v : voci) {
				%>
				<tr>
	   				<td><%=v.getNome() %></td>
	   				<td><%=v.getCognome() %></td>
	   				<td><%=v.getTelefono() %></td>
   				</tr>
				<%		
					}
				%>
 			</tbody>
		</table>				
</body>
</html>