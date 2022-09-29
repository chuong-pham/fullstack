const examplePromise = () => {
  return new Promise((resolve, reject) => {
    if (true) {
      setTimeout(() => resolve("success"), 3000);
    } else {
      setTimeout(() => resolve("failed"), 5000);
    }
  });
};

examplePromise()
.then(resolvedValue => {
    console.log(resolvedValue);
})
.catch(rejectedReason => {
    console.log(rejectedReason);
}) 