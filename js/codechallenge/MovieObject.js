function Movie(title, director, genre, releaseYear, rating) {
    this._title = title;
    this._director = director;
    this._genre = genre;
    this._releaseYear = releaseYear;
    this._rating = rating;
}

Movie.prototype.getOverview = function() {
    return `${this._title}, a/an ${this._genre} film directed by ${this._director} was released in ${this._releaseYear}. It received a rating of ${this._rating}.`
}

const batman = new Movie('The Dark Knight', 'Christopher Nolan', 'Action', 2008, 83);
const spiderman = new Movie('Spider Man', 'Sam Raimi', 'Action', 2002, 87)
console.log(spiderman.getOverview());
console.log(batman.getOverview());
console.log(batman);
