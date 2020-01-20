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
		if (session.getAttribute("uname") == null)
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
              <li><a href="#"><span class="glyphicon glyphicon-log-out"></span> Sign Out</a></li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
  </nav>

<div class="wrapper">
  <div class="sidebar" id="sideMenu">
    <div id="toggle-btn" onclick="Menutoggler()">
      <span></span>
      <span></span>
      <span></span>
    </div>
    <img src="img\img_avatar.png" alt="">
    <!-- <h2>Sidebar</h2> -->
    <ul>
      <li><a href="#"><i class="fas fa-home"></i>Home</a></li>
      <li><a href="#"><i class="fas fa-user"></i>Profile</a></li>
      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" ><i class="fas fa-address-card"></i>Registered Users <span class="caret"></span></a>
        <!-- <a href="#" ><i class="fas fa-address-card"></i>Registered Users</a> -->
        <ul class="dropdown-menu rightmenu" aria-labelledby="dropdownMenu3">
          <li><a href="#" id="FetchedData">Registration History</a></li>
          <li><a href="#">Location</a></li>
          <li><a href="#">Gender</a></li>
          <li><a href="#">Age</a></li>
        </ul>
      </li>
      <li><a href="#"><i class="fas fa-project-diagram"></i>Recent</a></li>
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
      <h4>Dashboard</h4>
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
        <div class="well" id="vicky" style="box-shadow: 1px 5px 8px #888888;">
          <canvas id="canvasChart"></canvas>
        </div>
      </div>
      <div class="col-sm-6">
        <div class="well" style="box-shadow: 1px 5px 8px #888888;">
          <canvas id="pieChart" style="overflow-x: auto;"></canvas>
        </div>
      </div>
    </div>

    <div class="well" style="box-shadow: 1px 5px 10px #888888; overflow-x: auto;">
      <h4>Dashboard</h4>
      <table>
        <tr>
          <th>Id</th>
          <th>Firstname</th>
          <th>Lastname</th>
          <th>Email</th>
          <th>Username</th>
          <th>Password</th>
          <th>Gender</th>
          <th>Dob</th>
          <th>State</th>
          <th>Country</th>
          <th>Pin</th>
          <th>Contact</th>
        </tr>
        <tr>
          <td>1</td>
          <td>Peter</td>
          <td>Griffin</td>
          <td>peter.griffin@gmail.com</td>
          <td>PeterG12</td>
          <td>Griffin@123</td>
          <td>M</td>
          <td>27/07/1992</td>
          <td>California</td>
          <td>united States</td>
          <td>90201</td>
          <td>1132652119</td>
        </tr>
        <tr>
          <td>2</td>
          <td>Peter</td>
          <td>Griffin</td>
          <td>peter.griffin@gmail.com</td>
          <td>PeterG12</td>
          <td>Griffin@123</td>
          <td>M</td>
          <td>27/07/1992</td>
          <td>California</td>
          <td>united States</td>
          <td>90201</td>
          <td>1132652119</td>
        </tr>
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
<script type="text/javascript" src="js\graph-and-chats.js"></script>
<script type="text/javascript" src="js\Chart-Pie.js"></script>
<script type="text/javascript" src="js\script.js"></script>

</body>
</html>