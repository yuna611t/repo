window.onload = function() {
    var targets = document.querySelectorAll('p.p01');
    for (var i = 0, l = targets.length; i < l; i++) {
        targets[i].style.color = 'red';
    }
    var target = document.querySelector('p.p01');
    target.style.color = 'blue';
};