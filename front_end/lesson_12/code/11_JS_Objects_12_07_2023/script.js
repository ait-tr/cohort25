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
            console.log(this.items);
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
const productsStats = document.getElementById('productsStats');

// Обработчик события клика по элементу 
add.onclick = addHandler;
stats.onclick = statsHandler;

function statsHandler() {
    // Количество позиций
    // Итог: стоимость
    // кол-во товаров
    // Максимальная цена товара
    // Минимальная цена товара
    // Средняя цена

    const minPrice = shoppingCart.items.sort((a, b) => a.productPrice - b.productPrice)[0].productPrice;
    const maxPrice = shoppingCart.items.sort((a, b) => b.productPrice - a.productPrice)[0].productPrice;
    const totalCost = shoppingCart.totalCost;
    const totalQuantity = shoppingCart.items.reduce((acc, item) => acc + item.productQuantity, 0);
    console.log(minPrice, maxPrice, totalCost, totalQuantity);

    productsStats.innerHTML = 
        `
            <p>Min Price: ${minPrice}</p>
            <p>Max Price: ${maxPrice}</p>
            <p>totalCost: ${totalCost}</p>
            <p>totalQuantity: ${totalQuantity}</p>
        `
    // const avgPrice = shoppingCart.items.reduce((acc, item) => acc + item.productPrice, 0) / shoppingCart.items.length;
}

function addHandler() {
    const item = {
        productName: productNameValue.value,
        productPrice: +price.value,
        productQuantity: +quantity.value
    }
    shoppingCart.addItem(item);

    // Стираем текстовое содержание input
    productNameValue.value = '';
    price.value = '';
    quantity.value = '';

    // Даём пустое значение для всей вложенности HTML-элементов внутри данного элемента
    productsList.innerHTML = '';

    shoppingCart.items.forEach(e => {
        // создал новый элемент li
        const li = document.createElement('li');

        // Дали этому элементу текстовый контент
        li.textContent = `Product name: ${e.productName}, Product price: ${e.productPrice}, 
        Product quantity: ${e.productQuantity}`;

        // Добавляем элемент внутрь productsList
        productsList.append(li);
    })
}


// item = {
//     productName: '',
//     productPrice: 0,
//     productQuantity: 0,
// }