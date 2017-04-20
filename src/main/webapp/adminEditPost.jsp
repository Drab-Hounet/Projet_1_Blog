<%-- 
    Document   : editPost
    Created on : 20 avr. 2017, 12:02:22
    Author     : jerome.lombard
--%>
        <title>edition billets</title>
    </head>
    <body>
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="navbar-header">
            <a class="navbar-brand" href="#">Blog Amadeus Papam</a>
            </div>
        </nav>


        <form method="post" action="" class="form-horizontal">
            <fieldset>
                <h1 class="col-md-10 col-md-offset-1    ">Création du billet</h1>
                <div class="form-group">
                    <div class="col-md-4 col-md-offset-4">
                        <div class="input-group">
                            <span class="input-group-addon">Titre</span>
                            <input id="prependedtext" name="prependedtext" class="form-control" placeholder="placeholder" type="text">
                        </div>
                        <p class="help-block"></p>
                    </div>
                </div>

                <!-- Textarea -->
                <div class="form-group">
                    <div class="col-md-4 col-md-offset-4">                     
                        <textarea rows="8" class="form-control" id="textarea" name="textarea"></textarea>
                    </div>
                </div>

                <!-- File Button --> 
                <div class="form-group">
                  <div class="col-md-4 col-md-offset-4">
                    <input  name="filebutton" class="input-file" type="file" accept="image/x-png,image/jpeg">
                  </div>
                </div>

                <!-- Button (Double) -->
                <div class="form-group">
                  <label class="col-md-4 control-label" for="button1id"></label>
                  <div class="col-md-8">
                    <button id="button1id" name="button1id" class="btn btn-success">Enregistrement</button>
                    <button id="button2id" name="button2id" class="btn btn-danger">Annuler</button>
                  </div>
                </div>
            </fieldset>
        </form>
    </body>
</html>
