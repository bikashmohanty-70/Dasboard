$(document).ready(function(){
  $.ajax({
    url: "ChartServlet",
    method: "GET",
    success: function(data) {
      console.log(data);
      var state = [];
      var totalUsers = [];

      for(var i in data) {
    	  state.push(data[i].State);
    	  totalUsers.push(data[i].totalUsers);
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
      let canvasChart = document.getElementById('canvasChart').getContext('2d');

    //Global Optiions
    Chart.defaults.global.defaultFontFamily = 'sans-serif';
    Chart.defaults.global.defaultFontSize = 12;
    Chart.defaults.global.defaultFontColor = '#777'
    //Bar Chart
    let population = new Chart(canvasChart, {
      type: 'bar',
      data:{
        labels:state,
        datasets:[{
          label: 'Total Users',
          data:totalUsers,
          backgroundColor:[
            'rgba(255, 99, 132, 0.6)',
            'rgba(54, 162, 235, 0.6)',
            'rgba(255, 206, 86, 0.6)',
            'rgba(75, 192, 192, 0.6)',
            'rgba(153, 102, 255, 0.6)'
          ],
          borderWidth:1,
          borderColor:'#777',
          hoverBorderWidth:3,
          hoverBorderColor: '#000'

        }]
      },
      options:{
        responsive: true,
        maintainAspectRatio: true,
        title:{
          display: true,
          position: 'top',
          text: 'Users From Different Region'
        },
        legend:{
          display: false
        },
        scales: {
          xAxes: [{
            categoryPercentage: 1,
            barPercentage: 0.4,
            gridLines:{
              display: false
            }
          }],
          yAxes: [{
            ticks: {
              beginAtZero: true
            }
          }]
        }
      }

    });
    },
    error: function(data) {
      console.log(data);
    }
  });
});