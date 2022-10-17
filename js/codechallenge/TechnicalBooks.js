// Class Syntax
/*
class Book {
  constructor(title, author, isbn, numOfCopies) {
    this._title = title;
    this._author = author;
    this._isbn = isbn;
    this._numOfCopies = numOfCopies;
  }

  get title() {
    return this._title;
  }

  get author() {
    return this._author;
  }

  get isbn() {
    return this._isbn;
  }

  get numOfCopies() {
    return this._numOfCopies;
  }

  getAvailability() {
    if (this._numOfCopies == 0) return "out of stock!";
    else if (this._numOfCopies < 10) return "low stock";
    else return "in stock";
  }

  sell(numSold = 1) {
    if (this._numOfCopies == 0) {
      throw new Error("the book is out of stock.");
    } else if (this._numOfCopies < numSold) {
      return "not enough number of copies to sell.";
    } else {
      this._numOfCopies -= numSold;
    }
  }

  restock(numCopies = 5) {
    this._numOfCopies += numCopies;
  }
}

class TechnicalBook extends Book {
    constructor(title, author, isbn, numCopies, edition) {
        super(title, author, isbn, numCopies);
        this._edition = edition;
    }

    getEdition() {
        return `The current version of this book is ${this._edition}.`;
    }
}
*/

function Book(title, author, isbn, numOfCopies) {
    this._title = title;
    this._author = author;
    this._isbn = isbn;
    this._numOfCopies = numOfCopies;
}

Book.prototype.getAvailability = function() {
    if (this._numOfCopies == 0) return "out of stock!";
    else if (this._numOfCopies < 10) return "low stock";
    else return `in stock: ${this._numOfCopies}`;
}

Book.prototype.sell = function(numSold=1) {
    if (this._numOfCopies == 0) {
      throw new Error("the book is out of stock.");
    } else if (this._numOfCopies < numSold) {
      return "not enough number of copies to sell.";
    } else {
      this._numOfCopies -= numSold;
    }
}


Book.prototype.restock = function(numOfCopies=5) {
    this._numOfCopies += numOfCopies;
}

const conan = new Book('conan', 'timothy', 123112, 5);
console.log(conan.getAvailability());
conan.restock();
console.log(conan.getAvailability());
conan.sell();
console.log(conan.getAvailability());
conan.restock(12);
console.log(conan.getAvailability());


function TechnicalBook(edition) {
    this._edition = edition;
}

TechnicalBook.prototype.getEdition = function() {
    return `This current edition of this book is ${this._edition}`;
}

TechnicalBook.prototype = 

/*
const crackingTheCodingInterview = new TechnicalBook(
    "Cracking The Coding Interview",
    "Gayle Lackmann McDowell",
    12091223,
    7,
    '2.3'
);

console.log(crackingTheCodingInterview.getAvailability());
console.log(crackingTheCodingInterview.getEdition());

*/


