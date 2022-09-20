let findNumbers = function (nums) {
  let count = 0;
  for (let num of nums) {
    let numDigits = 0;
    while (num != 0) {
      num = Math.floor(num/10);
      numDigits++;
    }
    if (numDigits % 2 === 0) {
      count++;
    }
  }
  return count;
};

let nums = [555, 901, 482, 1771];

console.log(findNumbers(nums));