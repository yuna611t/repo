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

    var children = main.children;
    console.log(children);

    var nextSibling = firstElementChild.nextSibling;
    console.log(nextSibling);
    var nextElementSibling = firstElementChild.nextElementSibling;
    console.log(nextElementSibling);

    var previousSibling = lastElementChild.previousSibling;
    console.log(previousSibling);
    var previousElementSibling = lastElementChild.previousElementSibling;
    console.log(previousElementSibling);
}