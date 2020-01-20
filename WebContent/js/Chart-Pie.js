let pieChart = document.getElementById('pieChart').getContext('2d');


//Bar Chart
let maleFemale = new Chart(pieChart, {
  type: 'pie',
  data:{
    labels:['Male', 'Female', 'Others'],
    datasets:[{
      // label: 'Total Number of Male And Female',
      data:[
        139,
        97,
        22
      ],
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
