$(document).ready(function(){
  $.ajax({
    url: "PieChartServlet",
    method: "GET",
    success: function(data) {
      console.log(data);
      var gender = [];
      var maleFemaleUsers = [];

      for(var i in data) {
    	  gender.push(data[i].gender);
    	  maleFemaleUsers.push(data[i].totalMFUsers);
      }

//      var chartdata = {
//        labels: state,
//        datasets : [
//          {
//            label: 'Total users from different Region',
//            backgroundColor: 'rgba(200, 200, 200, 0.75)',
//            borderColor: 'rgba(200, 200, 200, 0.75)',
//            hoverBackgroundColor: 'rgba(200, 200, 200, 1)',
//            hoverBorderColor: 'rgba(200, 200, 200, 1)',
//            data: totalUsers
//          }
//        ]
//      };
//
//      var ctx = $("#mycanvas");
//
//      var barGraph = new Chart(ctx, {
//        type: 'bar',
//        data: chartdata
//      });
      let pieChart = document.getElementById('pieChart').getContext('2d');


    //Bar Chart
    let maleFemale = new Chart(pieChart, {
      type: 'pie',
      data:{
        labels:['Male', 'Female', 'Others'],
        datasets:[{
          // label: 'Total Number of Male And Female',
          data:maleFemaleUsers,
          backgroundColor:[
            'rgba(54, 162, 235, 0.6)',
            '#FECEA8',
            '#FF847C'
          ],
          borderWidth:1,
          borderColor:'#FFF',
          hoverBorderWidth:2,
          hoverBorderColor: '#000'

        }]
      },
      options:{
        labels: {
          render: 'percentage',
          fontColor: ['green', 'white', 'red'],
          precision: 2
        },

        title:{
          display: true,
          position: "top",
          text: 'Total Number of Male And Female'
        },
        legend:{
          display: true,
          position: "bottom",
        },
        responsive: true,
        maintainAspectRatio: true 
      },

    });

    },
    error: function(data) {
      console.log(data);
    }
  });
});