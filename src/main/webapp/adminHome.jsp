<%-- 
    Document   : adminHome
    Created on : 24 avr. 2017, 11:56:44
    Author     : jerome.lombard
--%>

        <title>Blog Codeus Papam</title>
    </head>
    <body>
        
        <c:if test="${not empty pseudo}">
            <c:redirect url="/admin/edit"/>
        </c:if>

        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="navbar-header">
                <a class="navbar-brand" href="<c:url value="/admin/accueil"/>">Blog Codeus Papam</a>
            </div>
        </nav>
        
        <form method="post" class="form-horizontal">
            <fieldset>
                
         
            <div class="col-md-4 col-md-offset-1">
                    <h1>Login</h1>
                </div>
                <div class="col-md-2 col-md-offset-5 <c:out value="${stateErrorLogin}" default = "hidden"/>">
                    <div class="alert alert-danger">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">x</a>
                        <strong>Accés non autorisé!</strong>
                    </div>
                </div>

            <!-- Login input-->
            <div class="form-group">
              <div class="col-md-4 col-md-offset-4">
                <div class="input-group">
                  <span class="input-group-addon">Pseudo / Email</span>
                  <input id="prependedtext" name="login" class="form-control" placeholder="pseudo ou mail" type="text">
                </div>
                <p class="help-block"></p>
              </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <div class="col-md-4 col-md-offset-4">
                    <div class="input-group">
                        <span class="input-group-addon">Mot de passe</span>
                        <input id="passwordinput" name="password" type="password" placeholder="mot de passe" class="form-control input-md">
                    </div>
                    <span class="help-block"></span>
                </div>
            </div>

            <!-- Login -->
            <div class="form-group">
                <div class="col-md-4 col-md-offset-4">
                    <button type="submit" name="save" class="btn btn-success">Enregistrement</button>
                </div>
            </div>

            </fieldset>
        </form>

        
    </body>
</html>
