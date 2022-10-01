function celsiusToFahrenheit(celsius) {
    return celsius * (9/5) + 32;
}

const celsiusInput = process.argv[2];
const fahrenheitValue = celsiusToFahrenheit(celsiusInput);

console.log(`${celsiusInput} degrees Celsius = ${fahrenheitValue} degrees Fahrenheit`);

