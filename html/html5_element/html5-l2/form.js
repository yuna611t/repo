window.onload = function() {
    var main = document.getElementById('main');

    var element = document.createElement('p');
    element.innerText = "Hello everyone!!";
    main.appendChild(element);


    var forms = document.forms;
    console.log(forms);
    for (var i = 0; i < forms.length; i++) {
        console.log(forms[i]);
    }

};