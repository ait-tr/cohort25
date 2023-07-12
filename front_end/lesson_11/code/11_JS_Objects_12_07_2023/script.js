const shoppingCart = {
    items: [],
    totalCost: 0,
    addItem(item) {
        // find() позволяет найти элемент внутри массива
        // Принимает итерируемый элемент? и его индекс? а возвращает результат того условия,
        // под которое подходит искомый элемент
        const existingItem = this.items.find(e => e.productName === item.productName &&
                                                  e.productPrice === item.productPrice);
        if (existingItem) {
            existingItem.productQuantity += item.productQuantity;
        } else {
            this.items.push(item);
        };
        this.updateTotalCost();
    },
    updateTotalCost() {
        // reduce() позволяет делать однотипные действия для каждого элемента и складывать полученный результат в аккумулятор.
        // Принимает аккумулятор и каждый итерируемый элемент, а возвращает аккумулятор
        this.totalCost = this.items.reduce((acc, item) => acc + item.productQuantity * item.productPrice, 0);
    }
}

console.log(document);
// Получили ссылку на элементы с соответствующими id
const add = document.getElementById('buttonProductAdd');
const stats = document.getElementById('buttonProductsStats');

const productNameValue = document.getElementById('productName');
const price = document.getElementById('productPrice');
const quantity = document.getElementById('productQuantity');

const productsList = document.getElementById('productsList');


// Обработчик события клика по элементу 
add.onclick = addHandler;

function addHandler() {
    const item = {
        productName: productNameValue.value,
        productPrice: price.value,
        productQuantity: quantity.value
    }
    shoppingCart.addItem(item);

    // Даём пустое значение для всей вложенности HTML внутри данного элемент
    productsList.innerHTML = '';

    shoppingCart.items.forEach(e => {
        // создал новый элемент li
        const li = document.createElement('li');

        // Дали этому элементу контент
        li.textContent = `Product name: ${e.productName}, Product price: ${e.productPrice}, 
        Product quantity: ${e.productQuantity},`;

        // Добавляем элемент внутрь productsList
        productsList.append(li);
    })
}


// item = {
//     productName: '',
//     productPrice: 0,
//     productQuantity: 0,
// }