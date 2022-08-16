let car = {
  make: "toyota",
  model: "camry",
  year: 2006,
  wheels: 4
};

delete car.wheels;
console.log(car);

for(let prop in car) {
  console.log(prop + ": " + car[prop]);
}

