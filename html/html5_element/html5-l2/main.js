window.onload = function() {
    var main = document.getElementById('main');
    console.log(main);

    var p = document.getElementsByTagName('p');
    console.log(p);

    var parent = main.parentNode;
    console.log(parent);

    var firstChild = main.firstChild;
    console.log(firstChild);
    var firstElementChild = main.firstElementChild;
    console.log(firstElementChild);

    var lastChild = main.lastChild;
    console.log(lastChild);
    var lastElementChild = main.lastElementChild;
    console.log(lastElementChild);


}