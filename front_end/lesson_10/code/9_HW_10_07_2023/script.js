const library = [];
let inputDate = prompt('Enter book data separate by ";"');

while (inputDate) {
    // inputDate = ';Gold Fish;A.S.Pushkin;1820'.split(';') => ['', 'Gold Fish', 'A.S.Pushkin', '1820']
    // TODO (inputDate.split(',') => [])
    const bookData = inputDate.split(";");
    // false получаем из других типов только в следующих случаях:
    // 0, (-0), false, null, undefined, NaN, ''
    if (
        bookData.length === 4 &&
        bookData[0] &&
        bookData[1] &&
        bookData[2] &&
        bookData[3] &&
        findBook(library, bookData[0]) === -1
    ) {
        const book = new Book(
            bookData[0],
            bookData[1],
            bookData[2],
            bookData[3]
        );
        library.push(book);
    }

    inputDate = prompt('Enter book data separate by ";"');
}

printLibrary(library);
console.log(findBook(library, 1));

function printLibrary(library) {
    for (let i = 0; i < library.length; i++) {
        console.log(library[i].toString());
    }
}

function findBook(library, isbn) {
    for (let i = 0; i < library.length; i++) {
        if (library[i].isbn == isbn) {
            return i;
        }
    }
    return -1;
}

function Book(isbn, title, author, year) {
    this.isbn = isbn;
    this.title = title;
    this.author = author;
    this.year = year;
    this.toString = function () {
        return `ISBN: ${this.isbn}, Title: ${this.title}, Author: ${this.author}, Year: ${this.year},`;
    };
}
