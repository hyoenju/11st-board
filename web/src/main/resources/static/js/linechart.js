const labels = ['1일', '2일', '3일', '4일', '5일', '6일', '7일', '8일', '9일', '10일', '11일', '12일', '13일', '14일', '15일',
  '16일', '17일', '18일', '19일', '20일', '21일', '22일', '23일', '24일', '25일', '26일', '27일', '28일', '29일', '30일'
];
const data = {
  labels: labels,
  datasets: [{
    label: 'Mood',
    data: [0.13, 0.41, , 0.64, 0, 0.5, null, 0.13, null, null, 0.47, 0.12, 0.19, 0.1, 0.1, 0.1, 0.1,
      0.47, 0.1, 0.11, 0.25, 0.64, 0.29, 0.8, , 0.41, 0.07, , 0.5, 0.49
    ],
    fill: false,
    borderColor: 'rgb(75, 192, 192)',
    pointRadius: 5,
    tension: 0.2
  }]
};

const config = {
  type: 'line',
  data: data,
  responsive: false,
  scales: {
    y: {
      max: 1,
      min: 0,
    }
  }
};

var context = document
  .getElementById('chart')
  .getContext('2d');

var chart = new Chart(context, config);