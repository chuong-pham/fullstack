let fiat = {
  make: "Fiat",
  model: "500",
  year: 1957,
  color: "Medium Blue",
  passengers: 2,
  convertible: false,
  mileage: 88000,
  started: false,
  start: function () {
    started = true;
  },
  stop: function () {
    started = false;
  },
  drive: function () {
    let started = false;
    if (started) {
      alert("Zoom zoom!");
    } else {
      alert("You need to start the engine first.");
    }
  },
};


console.log(fiat.drive());