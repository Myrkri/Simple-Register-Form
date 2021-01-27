
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Users</title>
    <style>
        input[type=text] {
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
        input[type=submit]:hover {
            background-color: #45a049;
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
    <form name="returner" method="get">
        <label for="name"><b>Name</b></label>
        <input type="text" placeholder="Enter Your Name" name="name" id="name">

        <button type="submit" class="registerbtn">Search</button>
    </form>
</div>
<p> User: ${user}</p>
<p> Password: ${password}</p>
</body>
</html>
