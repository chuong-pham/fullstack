function square(x) {
    return x*x;
}

console.log(square(2,true,"dog"));


function power(base, exponent=2) {
    let result = 1;
    for(let count=0; count < exponent; count++) {
        result *= base
    }
    return result;
}

console.log(power(3));