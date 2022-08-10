//Example1
function howMany(...args) {
  return "You have passed " + args.length + " arguments.";
}
console.log(howMany(0, 1, 2));
console.log(howMany("string", null, [1, 2, 3], {}));

//Example2
const sum = (...args) =>
  args.reduce((accumulator, element) => accumulator + element, 0);

console.log(sum(1, 2, 3));
