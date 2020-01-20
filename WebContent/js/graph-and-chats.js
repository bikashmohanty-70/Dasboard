let canvasChart = document.getElementById('canvasChart').getContext('2d');

//Global Optiions
Chart.defaults.global.defaultFontFamily = 'sans-serif';
Chart.defaults.global.defaultFontSize = 14;
Chart.defaults.global.defaultFontColor = '#777'
//Bar Chart
let population = new Chart(canvasChart, {
  type: 'bar',
  data:{
    labels:['Bhubaneswar', 'Cuttack', 'Hyderabad', 'Mumbai', 'Delhi'],
    datasets:[{
      label: 'Population',
      data:[
        500000,
        600000,
        800000,
        660000,
        750500
      ],
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
      text: 'Population in Differnet Area'
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
