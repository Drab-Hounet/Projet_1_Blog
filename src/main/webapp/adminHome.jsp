<%-- 
    Document   : adminHome
    Created on : 24 avr. 2017, 11:56:44
    Author     : jerome.lombard
--%>

        <title>Blog Codeus Papam</title>
    </head>
    <body>
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="navbar-header">
                <a class="navbar-brand" href="<c:url value="/admin/accueil"/>">Blog Codeus Papam</a>
            </div>
        </nav>
        
        <form method="post" class="form-horizontal">
            <fieldset>
                
            <h1 class="col-md-10 col-md-offset-1">Login</h1>

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
