module.exports.celsiusToFahrenheit = function(celsius) {
    return celsius*(9/5)+32;
}

module.exports.fahrenheitToCelsius = fahrenheit => (fahrenheit - 32) * 5/9;