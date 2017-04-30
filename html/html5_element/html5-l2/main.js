window.onload = function() {
    var main = document.getElementById('main');
    
    var element = document.createElement('p');
    element.id = 'target';
    element.innerText = 'Click Me!';
    element.style.color = 'red';
    main.appendChild(element);

    var target = document.getElementById('target');
    target.addEventListener('click', function() {
        this.innerText = 'Clicked';
    });

};