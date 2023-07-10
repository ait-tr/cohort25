const library = [];
let inputDate = prompt('Enter book data separate by ";"');

while (inputDate) {
    // inputDate = '123456789;Gold Fish;A.S.Pushkin;1820'.split(';') => [123456789, Gold Fish, A.S.Pushkin, 1820]
    // TODO (inputDate.split(';') => [])
    inputDate = prompt('Enter book data separate by ";"');
}

printLibrary();

function printLibrary(library) {
    // TODO
}

function findBook(library, isbn) {
    // TODO
}

function Book(isbn, title, author, year) {
    this.isbn = isbn;
    this.title = title;
    this.author = author;
    this.year = year;
    this.toString = function () {
        return `ISBN: ${this.isbn}, Title: ${this.title}, Author: ${this.author}, Year: ${this.year},`
    }
}