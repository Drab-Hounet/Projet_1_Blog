<%-- 
    Document   : adminWall
    Created on : 27 avr. 2017, 16:11:38
    Author     : joel.ponson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
        <title>Wall Admin</title>
    </head>
        
        <c:if test="${adminConnected != null}">
            <c:set var="pseudo" value="${adminConnected}" scope="application"/>
        </c:if>
        
        <c:if test="${empty pseudo}">
            <c:redirect url="/admin/accueil"/>
        </c:if>

        <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
            <div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header" >
                    <a class="navbar-brand" href="<c:url value="/admin/accueil"/>">Blog Codeus Papam</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" >
		    <ul class="nav navbar-nav navbar-right">
                        <li><a href="<c:url value="/admin/logout"/>"><c:out value="${pseudo}"/></a></li>		        
		    </ul>
		</div>
            </div>
	</nav>

        <div class="container">
          <div class="alert alert-success alert-dismissable ${displayAlertSuccess}">
            <a href="#" class="close" data-dismiss="alert" aria-label="close">x</a>
            <strong>Succés!</strong> Billet enregistré ! 
          </div>
 
          <div class="alert alert-danger alert-dismissable ${displayAlertFail}">
            <a href="#" class="close" data-dismiss="alert" aria-label="close">x</a>
            <strong>Erreur!</strong> Problème du serveur !
          </div>
        </div>

    
</html>