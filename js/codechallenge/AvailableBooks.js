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
        if(this._numOfCopies == 0) 
            return 'out of stock!';
        else if(this._numOfCopies < 10) 
            return 'low stock';
        else   
            return 'in stock';
    }

    sell(numSold=1) {
        if(this._numOfCopies == 0) {
            throw new Error('the book is out of stock.');
        }else if(this._numOfCopies < numSold) {
            return 'not enough number of copies to sell.';
        }else {
            this._numOfCopies -= numSold;
        }
    }

    restock(numCopies=5) {
        this._numOfCopies += numCopies;
    }
}

const doraemon = new Book('doraemon', 'fujiko', '123abc', 1000);

console.log(doraemon.author);
console.log(doraemon.title);
console.log(doraemon.isbn);
console.log(doraemon.numOfCopies);
console.log(doraemon.getAvailability());

doraemon.sell();
console.log(doraemon.numOfCopies);

doraemon.restock();
console.log(doraemon.numOfCopies);

doraemon.sell(2000);
console.log(doraemon.numOfCopies);

console.log(doraemon.sell(2000));

