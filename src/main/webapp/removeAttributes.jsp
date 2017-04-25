<%-- 
    Document   : removeAttributes
    Created on : 25 avr. 2017, 13:32:04
    Author     : jerome.lombard
--%>


        <title>Déconnexion</title>
    </head>
    <body>
        <c:remove var="pseudo" scope="application" />
        
        <div class="container-fluid">
            <div class="col-md-11 col-md-offset-1">
                <h1>Vous êtes déconnecté !</h1>
            </div>
            <div class="col-md-2 col-md-offset-5">
                <a href="<c:url value="/admin/accueil"/>" class="btn btn-block btn-default"><span class="glyphicon glyphicon-arrow-left"></span> retour</a>

            </div>
        </div>
    </body>
</html>
