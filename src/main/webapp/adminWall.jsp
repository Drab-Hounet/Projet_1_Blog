<%-- 
    Document   : adminWall
    Created on : 27 avr. 2017, 16:11:38
    Author     : joel.ponson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
        <title>edition billets</title>
    </head>
    <body>
        
 
        
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

        <form method="post" action="edit" class="form-horizontal">
            <fieldset>
                <div class="col-md-4 col-md-offset-1">
                    <h1>Création du billet</h1>
                </div>
                <div class="col-md-2 col-md-offset-5 <c:out value="${stateConnected}" default = "hidden"/>">
                    <div class="alert alert-success">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">x</a>
                        <strong>Connecté!</strong>
                    </div>
                </div>
                    
                

                <div class="form-group">
                    <div class="col-md-4 col-md-offset-4">
                        <div class="input-group">
                            <span class="input-group-addon">Titre</span>
                            <input id="prependedtext" name="title" class="form-control" placeholder="titre" type="text">
                        </div>
                        <p class="help-block"></p>
                    </div>
                </div>

                <!-- Textarea -->
                <div class="form-group">
                    <div class="col-md-4 col-md-offset-4">                     
                        <textarea rows="8" class="form-control" id="textarea" name="content"></textarea>
                    </div>
                </div>

                <!-- File Button --> 
                <div class="form-group">
                  <div class="col-md-4 col-md-offset-4">
                    <input  name="pictureFile" class="input-file" type="file" accept="image/x-png,image/jpeg">
                  </div>
                </div>

                <!-- Button (Double) -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="button1id"></label>
                    <div class="col-md-8">
                        <button type="submit" name="save" class="btn btn-success">Enregistrement</button>
                        <button type="submit" name="cancel" class="btn btn-danger">Annuler</button>
                    </div>
                </div>
            </fieldset>
        </form>
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

    </body>
</html>