//1. Function Expression
/* let add = function(x,y) {
    return x+y;
}
console.log(add(3,4)); */

//2. Higher Oder Function

/* function callTwice(func) {
    func();
    func();
}

function laugh() {
    console.log("HAHAHAHAHA");
}

callTwice(laugh);

let callOnce = function(func) {
    func();
};

let cry = function() {
    console.log("HUHUHUHU");
};

callOnce(cry); */

//3. Returning Functions
/* let makeMysteryFunc = function() {
    const rand = Math.floor(Math.random()*10) + 1;
    if(rand > 5) {
        return function() {
            console.log(`You won $${rand} dollars`);
        }
    }else {
        return function() {
            console.log(`You lost $${rand} dollars`);
        }
    }
};

let result = makeMysteryFunc();
result(); */

/* let makeBetweenFunc = function(num1, num2) {
    return function(num) {
        return num > num1 && num < num2;
    }
}
let myFunc = makeBetweenFunc(100,200);

console.log(myFunc(150));
console.log(myFunc(300)); */

//4. Defining Methods

/* const myMath = {
    PI: 3.14159,
    square: function(number) {
        return number*number;
    },

    cube(number) {
        return number*number*number;
    }
};

console.log(myMath.square(2));
console.log(myMath.cube(3)); */


//5. keyword 'this'

/* const person = {
    firstName: 'Chuong',
    lastName: 'Pham',
    fullName() {
        return this.firstName + " " + this.lastName;
    }
}

console.log(person.fullName());
 */

//6. forEach and map

/* const names = ['chuong', 'minh', 'phuc', 'duy', 'huy'];

names.forEach(function(name) {
    console.log(`Hello ${name}`);
})

const numbers = [1,2,3,4,5,6,7,8,9];

const squared = numbers.map(function(n) {
    return n*n;
}) 

console.log(squared);

const cubed = numbers.map(n => n*n*n);
console.log(cubed); */

//7. setTimeout and setInterval
/* console.log("Hello there!");
setTimeout(() => console.log("hello"), 2000);

console.log("good bye!"); */

/* console.log("chuong dep trai");
setInterval(function() {
    console.log("aaaa")
}, 2000);
console.log("chuong dep trai"); */

//8. filter method

/* const numbers = [1,2,3,4,5,6,7,8,9];
const evens = numbers.filter(n => n%2 === 0);
console.log(evens);

const squaredOdds = numbers.filter(n => n%2 !== 0).map(n => n*n);
console.log(squaredOdds); */

//9. some and every
/* const numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9];
let n = numbers.some(x => x*x === 100);
console.log(n);

let k = numbers.every(x => x <10);
console.log(k); */

//10. reduce
/* const numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9];

const total = numbers.reduce((pre, cur) => pre+cur);
console.log(total);

const total2 = numbers.reduce((acc, cur) => (acc+cur),0);
console.log(total2); */

//11. Arrow function and this

/* const person = {
    firstName: 'Virgo',
    lastName: 'Mortensen',
    fullName: function() {
        return `${this.firstName} ${this.lastName}`;
    }
}

console.log(person.fullName());

const person2 = {
  firstName: "Chuong",
  lastName: "Pham",
  fullName() {
    return `${this.firstName} ${this.lastName}`;
  },
};

console.log(person2.fullName());

const person3 = {
  firstName: "Phuc",
  lastName: "Du",
  fullName: () => {
    return `${this.firstName} ${this.lastName}`
  }
};

console.log(person3.fullName()); */

/* const person4 = {
  firstName: "Huy",
  lastName: "Nguyen",
  fullName: function() {
        setTimeout(()=>
        console.log(`Hello ${this.firstName}, ${this.lastName}`), 2000)
  },
};

console.log(person4.fullName()); */


/* function rollDice(numSides) {
     if(numSides == undefined) {
        numSides = 6;
    }  

    return Math.floor(Math.random() * numSides) + 1;
}

console.log(rollDice()); */

/* const dataFromForm = {
    username: 'chuongpham',
    password: '123',
};

const myData = {...dataFromForm, id: 1000, isAdmin: false};

console.log(myData.username); */

function listItem() {
    for(let arg of arguments) {
        console.log(arg);
    }
}
const n = [1,2,3,4,5]
listItem(...n);