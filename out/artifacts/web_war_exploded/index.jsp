<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <title>Registration</title>
    <style>
      input[type=text], [type=password] {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
      }
      .registerbtn {
        background-color: #4CAF50;
        color: white;
        padding: 16px 20px;
        margin: 8px 0;
        border: none;
        cursor: pointer;
        width: 100%;
        opacity: 0.9;
      }
      .checker {
          background-color: #4CAF50;
          color: white;
          padding: 16px 20px;
          margin: 8px 0;
          border: none;
          cursor: pointer;
          width: 100%;
          opacity: 0.9;
      }
      div.container {
        border-radius: 5px;
        background-color: #f2f2f2;
        padding: 20px;
      }
    </style>
  </head>
  <body>
  <div class="container">
  <form name="home" action="servlet"  method="post">
      <h1>Register</h1>

      <label for="name"><b>Name</b></label>
      <input type="text" placeholder="Enter Your Name" name="name" id="name" required>

      <label for="psw"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="psw" id="psw" required>

      <button type="submit" class="registerbtn">Register</button>
      <button id=checker name="checker" type="button" class="checker">Search for a user</button>

  </form>
  </div>
  </body>
</html>