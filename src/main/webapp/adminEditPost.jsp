<%-- 
    Document   : editPost
    Created on : 20 avr. 2017, 12:02:22
    Author     : jerome.lombard
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <title>ADMIN EDITION BILLETS</title>
    </head>
    <body>
        <form class="form-horizontal">
        <fieldset>

        <!-- Form Name -->
        <legend>Création du billet</legend>

        <!-- Prepended text-->
        <div class="form-group">
          <label class="col-md-4 control-label" for="prependedtext">Prepended Text</label>
          <div class="col-md-4">
            <div class="input-group">
              <span class="input-group-addon">prepend</span>
              <input id="prependedtext" name="prependedtext" class="form-control" placeholder="placeholder" type="text">
            </div>
            <p class="help-block">help</p>
          </div>
        </div>

        <!-- Textarea -->
        <div class="form-group">
          <label class="col-md-4 control-label" for="textarea">Text Area</label>
          <div class="col-md-4">                     
            <textarea class="form-control" id="textarea" name="textarea">default text</textarea>
          </div>
        </div>

        <!-- File Button --> 
        <div class="form-group">
          <label class="col-md-4 control-label" for="filebutton">File Button</label>
          <div class="col-md-4">
            <input id="filebutton" name="filebutton" class="input-file" type="file">
          </div>
        </div>

        <!-- Button (Double) -->
        <div class="form-group">
          <label class="col-md-4 control-label" for="button1id">Double Button</label>
          <div class="col-md-8">
            <button id="button1id" name="button1id" class="btn btn-success">Good Button</button>
            <button id="button2id" name="button2id" class="btn btn-danger">Scary Button</button>
          </div>
        </div>

        </fieldset>
        </form>
    </body>
</html>
