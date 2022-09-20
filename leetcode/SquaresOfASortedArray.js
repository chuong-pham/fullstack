let sortedSquares = function (nums) {
  let left = 0;
  let right = nums.length - 1;
  let count = nums.length - 1;
  while (count >= 0) {
    if (Math.abs(nums[left]) <= Math.abs(nums[right])) {
      nums[count--] = nums[right] ** 2;
      
    } else {
        let temp = nums[count];
        nums[count--] = nums[left] ** 2;
        nums[left] = temp;
    }
    right--;
  }
  return nums;
};


let nums = [-5, -3, -2, -1];

console.log(sortedSquares(nums));