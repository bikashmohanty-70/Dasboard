<%@page import="java.sql.ResultSet"%>
<%@page import="com.bridgelabz.databaseactivexobject.*" %>
<%@ page import ="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  	<link rel="stylesheet" href="css\styleMain.css">

  	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.0/jquery.min.js"></script>
  	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.js"></script>
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  	<script src="https://kit.fontawesome.com/b99e675b6e.js"></script>
	
	<title>DashBoard</title>
</head>
<body>
	<%
		if(session.getAttribute("uname") == null)
			response.sendRedirect("admin.jsp");
	%>

	<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#"><img src="img\ChaperonCropped.png" class="img-responsive" alt="Responsive image"></a>
      </div>
      <div class="collapse navbar-collapse" id="myNavbar">
        <ul class="nav navbar-nav navbar-right">
          <li>
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" >${uname} <span class="caret"></span></a>
            <ul class="dropdown-menu">
              <li><a href="register.jsp"><span class="glyphicon glyphicon-user"></span> Profile</a></li>
              <li><a href="#"><span class="glyphicon glyphicon-cog"></span> Settings</a></li>
              <li><a href="#"><span class="glyphicon glyphicon-list"></span> Activity Log</a></li>
              <li><a href="#"><span class="glyphicon glyphicon-trash"></span> Delete a/c</a></li>
              <li role="separator" class="divider"></li>
              <li><a href="SignOut"><span class="glyphicon glyphicon-log-out"></span> Sign Out</a></li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
  </nav>

<div class="wrapper" id="wrapperClass">
  <div class="sidebar" id="sideMenu">
    <div id="toggle-btn" onclick="Menutoggler()">
      <span></span>
      <span></span>
      <span></span>
    </div>
    <img src="img\img_avatar.png" alt="">
    <!-- <h2>Sidebar</h2> -->
    <ul id="sideMenuBar">
      <li><a href="#"><i class="fas fa-home"></i>Home</a></li>
      <li><a href="#"><i class="fas fa-user"></i>Profile</a></li>
      <li class="dropdown" id="sideMenuBarDropDown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" ><i class="fas fa-address-card"></i>Registered Users <span class="caret"></span></a>
        <!-- <a href="#" ><i class="fas fa-address-card"></i>Registered Users</a> -->
        <ul class="dropdown-menu rightmenu" id="submenu" aria-labelledby="dropdownMenu3">
          <li id="reg_his"><a href="#registration" id="history">Registration History</a></li>
          <li><a href="#location">Location</a></li>
          <li><a href="#gender">Gender</a></li>
          <li><a href="#age">Age</a></li>
        </ul>
      </li>
      <li><a href="#" class="recent"><i class="fas fa-project-diagram"></i>Recent</a></li>
      <li><a href="#"><i class="fas fa-blog"></i>Blogs</a></li>
      <li><a href="#"><i class="fas fa-address-book"></i>Contact</a></li>
      <li><a href="#"><i class="fas fa-map-pin"></i>Map</a></li>
      <!-- <button type="button" name="button" id="showbtn">SHOW</button> -->
    </ul>
    <!-- <div class="social_media">
    <a href="#"><i class="fab fa-facebook-f"></i></a>
    <a href="#"><i class="fab fa-twitter"></i></a>
    <a href="#"><i class="fab fa-instagram"></i></a>
  </div> -->
</div>
<!-- <div class="main_content">
<div class="header">Welcome!! Have a nice day.</div> -->
<div class="container-fluid text-left body-container">
  <div class="row content">
    <div class="well" style="box-shadow: 1px 5px 10px #888888;">
      <marquee behavior="scroll" direction="left" onmouseover="this.stop();" onmouseout="this.start();"><h4 style="color: red;">4 users Unsubscribed Today.<a style="text-decoration: none; cursor: pointer">See Details.</a></h4></marquee>
      <p>Some text..</p>
    </div>
    <div class="row">
      <div class="col-sm-3">
        <div class="well">
          <div class="card">
            <div class="card-body card-to-vt">
              <h4 class="card-title">Total Visits</h4>
              <h5 class="card-subtitle mb-2 text-muted">Card subtitle</h5>
              <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
              <a href="#" class="card-link">Card link</a>
              <a href="#" class="card-link">Another link</a>
            </div>
          </div>
        </div>
      </div>
      <div class="col-sm-3">
        <div class="well">
          <div class="card">
            <div class="card-body card-to-pg">
              <h4 class="card-title">Total Page Views</h4>
              <h5 class="card-subtitle mb-2 text-muted">Card subtitle</h5>
              <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
              <a href="#" class="card-link">Card link</a>
              <a href="#" class="card-link">Another link</a>
            </div>
          </div>
        </div>
      </div>
      <div class="col-sm-3">
        <div class="well">
          <div class="card">
            <div class="card-body card-un-vi">
              <h4 class="card-title">Unique Visitor</h4>
              <h5 class="card-subtitle mb-2 text-muted">Card subtitle</h5>
              <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
              <a href="#" class="card-link">Card link</a>
              <a href="#" class="card-link">Another link</a>
            </div>
          </div>
        </div>
      </div>
      <div class="col-sm-3">
        <div class="well">
          <div class="card">
            <div class="card-body card-bo-rt">
              <h4 class="card-title">Bounce Rate</h4>
              <h5 class="card-subtitle mb-2 text-muted">Card subtitle</h5>
              <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
              <a href="#" class="card-link">Card link</a>
              <a href="#" class="card-link">Another link</a>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="row">
      <div class="col-sm-6">
        <div class="well" style="box-shadow: 1px 5px 8px #888888;">
          <canvas id="canvasChart"></canvas>
        </div>
      </div>
      <div class="col-sm-6">
        <div class="well" style="box-shadow: 1px 5px 8px #888888;">
          <canvas id="pieChart" style="overflow-x: auto;"></canvas>
        </div>
      </div>
    </div>

    <div class="well toggleer" id="tableDiv" style="box-shadow: 1px 5px 10px #888888; overflow-x: auto;">
      <h4 style="border-bottom: 1px solid gray;">Registered Users</h4>
      
      <table id="RegisterTable" aria-describedby="tableDiv">
        <tr>
          <th>Id</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Email</th>
          <th>Username</th>
          <th>Password</th>
          <th>Dob</th>
          <th>Gender</th>
          <th>City</th>
          <th>State</th>
          <th>Contact</th>
          <th>Pin</th>
        </tr>
        <%
        
        /* IConnectivity connectDatabase = new Databaseconnectivity();
        connectDatabase.connect(); */
        /* ResultSet resultset = connectDatabase.readCompleteTable(); */
        ResultSet resultset = (ResultSet) session.getAttribute("dataForTable");
        if(resultset == null)
        {
        	out.print("<script type='text/javascript'>alert('Could not establish connection to Database.. Server is Busy');");
        	out.print("</script>");
        }
        else
        {
        	while(resultset.next())
        	{
        %>
            	<tr>
                	<td><%=resultset.getString(1)%></td>
                	<td><%=resultset.getString(2)%></td>
                	<td><%=resultset.getString(3)%></td>
                	<td><%=resultset.getString(4)%></td>
                	<td><%=resultset.getString(5)%></td>
                	<td><%=resultset.getString(6)%></td>
                	<td><%=resultset.getString(7)%></td>
                	<td><%=resultset.getString(8)%></td>
                	<td><%=resultset.getString(9)%></td>
                	<td><%=resultset.getString(10)%></td>
                	<td><%=resultset.getString(11)%></td>
                	<td><%=resultset.getString(12)%></td>
           		</tr>
      <%
        	}
        }
       %>
      
      </table>
    </div>
    
    <!--Gender Section -->
    <!--******************************************************************** -->
    
    <div class="well toggleer" id="tableDiv" style="box-shadow: 1px 5px 10px #888888; overflow-x: auto;">
    
    	<h4 style="border-bottom: 1px solid gray; background-color: #4b4276; color: white;">Male Users</h4>
      
      <table id="RegisterTable" aria-describedby="tableDiv">
        <tr>
          <th>Id</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Email</th>
          <th>Username</th>
          <th>Password</th>
          <th>Dob</th>
          <th>Gender</th>
          <th>City</th>
          <th>State</th>
          <th>Contact</th>
          <th>Pin</th>
        </tr>
        <%
        
        /* IConnectivity connectDatabase = new Databaseconnectivity();
        connectDatabase.connect(); */
        /* ResultSet resultset = connectDatabase.readCompleteTable(); */
        ResultSet resultsetGender = (ResultSet) session.getAttribute("genderDataForTable");
        if(resultsetGender == null)
        {
        	out.print("<script type='text/javascript'>alert('Could not establish connection to Database.. Server is Busy');");
        	out.print("</script>");
        }
        else
        {
        	while(resultsetGender.next())
        	{
        %>
            	<tr>
                	<td><%=resultsetGender.getString(1)%></td>
                	<td><%=resultsetGender.getString(2)%></td>
                	<td><%=resultsetGender.getString(3)%></td>
                	<td><%=resultsetGender.getString(4)%></td>
                	<td><%=resultsetGender.getString(5)%></td>
                	<td><%=resultsetGender.getString(6)%></td>
                	<td><%=resultsetGender.getString(7)%></td>
                	<td><%=resultsetGender.getString(8)%></td>
                	<td><%=resultsetGender.getString(9)%></td>
                	<td><%=resultsetGender.getString(10)%></td>
                	<td><%=resultsetGender.getString(11)%></td>
                	<td><%=resultsetGender.getString(12)%></td>
           		</tr>
      <%
        	}
        }
       %>
      
      </table>
      <br>
      <!--**************************FEMALE****************************************** -->
      <h4 style="border-bottom: 1px solid gray; background-color: #4b4276 ; color: white;">Female Users</h4>
      
      <table id="RegisterTable" aria-describedby="tableDiv">
        <tr>
          <th>Id</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Email</th>
          <th>Username</th>
          <th>Password</th>
          <th>Dob</th>
          <th>Gender</th>
          <th>City</th>
          <th>State</th>
          <th>Contact</th>
          <th>Pin</th>
        </tr>
        <%
        
        /* IConnectivity connectDatabase = new Databaseconnectivity();
        connectDatabase.connect(); */
        /* ResultSet resultset = connectDatabase.readCompleteTable(); */
        ResultSet resultsetFemale = (ResultSet) session.getAttribute("FemalesDataForTable");
        if(resultsetFemale == null)
        {
        	out.print("<script type='text/javascript'>alert('Could not establish connection to Database.. Server is Busy');");
        	out.print("</script>");
        }
        else
        {
        	while(resultsetFemale.next())
        	{
        %>
            	<tr>
                	<td><%=resultsetFemale.getString(1)%></td>
                	<td><%=resultsetFemale.getString(2)%></td>
                	<td><%=resultsetFemale.getString(3)%></td>
                	<td><%=resultsetFemale.getString(4)%></td>
                	<td><%=resultsetFemale.getString(5)%></td>
                	<td><%=resultsetFemale.getString(6)%></td>
                	<td><%=resultsetFemale.getString(7)%></td>
                	<td><%=resultsetFemale.getString(8)%></td>
                	<td><%=resultsetFemale.getString(9)%></td>
                	<td><%=resultsetFemale.getString(10)%></td>
                	<td><%=resultsetFemale.getString(11)%></td>
                	<td><%=resultsetFemale.getString(12)%></td>
           		</tr>
      <%
        	}
        }
       %>
      
      </table>
    
    </div>
    
  </div>
</div>
</div>


<!-- <div class="well" id="output" style="box-shadow: 1px 5px 8px #888888;">

</div> -->

<!-- <footer class="container-fluid text-center">
<p>Footer Text</p>
</footer> -->
<!-- <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.0.min.js"></script> -->
<script type="text/javascript">
/*
Below Code Will not work on Chrome... Otherwise it works fine
*/

// $(document).ready(function(){
//   $("button").click(function(){
//     $("#output").load("TotalNumberOfMale&Female.html");
//   });
// });
// $( "#output" ).load( "TotalNumberOfMale&Female.html #target" );
</script>
<!-- <script type="text/javascript" src="js\graph-and-chats.js"></script> -->
<!-- <script type="text/javascript" src="js\Chart-Pie.js"></script> -->
<script type="text/javascript" src="js\script.js"></script>
<script type="text/javascript" src="js\BarChart.js"></script>
<script type="text/javascript" src="js\MaleFemalePieChart.js"></script>

</body>
</html>