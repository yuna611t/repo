var checkBMI = function(height, weight) {
    var bmi = weight / (height * height);
    console.log('BMI : ' + bmi);

    if (bmi >= 25) {
        console.log('Too fat');
    } else if (bmi < 18.5) {
        console.log('Too skiny');
    } else {
        console.log('Standard');
    }
}

checkBMI(1.76, 62)