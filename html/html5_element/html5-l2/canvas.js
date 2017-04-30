var canvas = document.querySelector('#sample');
var ctx = canvas.getContext('2d');

ctx.beginPath();
ctx.rect(10,20,50,100);
ctx.strokeStyle = '#F00';
ctx.fillStyle = '#000';
ctx.stroke();
ctx.fill();


var circle = document.querySelector('#sample2');
circle.addEventListener('click', function(){
    this.setAttribute('r', 45);
});
