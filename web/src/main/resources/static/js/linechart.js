const chartData = {
  datasets: [{
    label: 'Mood',
    fill: false,
    borderColor: 'rgb(75, 192, 192)',
    pointRadius: 5,
    tension: 0.2
  }]
};

const config = {
  type: 'line',
  data: chartData,
  responsive: false,
  scales: {
    y: {
      max: 1,
      min: 0,
    }
  }
};

function draw(data, labels) {
  chartData.labels = labels;
  chartData.datasets[0]['data'] = data;

  var context = document
  .getElementById('chart')
  .getContext('2d');

  new Chart(context, config);
}

(function() {
  draw(scores, labels);
})();

