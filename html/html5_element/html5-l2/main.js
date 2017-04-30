// 関数宣言と関数の巻き上げ
console.log(add(1,2));

function add(a,b) {
    return a + b;
}


// 関数式
try {
    console.log(add2(1,2));
} catch (e) {
    console.log(e);
}

var add2 = function(a,b) {
    return a + b;
}