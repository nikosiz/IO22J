let carts = document.querySelectorAll('.add-to-cart');

let products = [{
    name: 'product-1', tag: 'product-1', price: 10, inCart: 0
}, {
    name: 'product-2', tag: 'product-2', price: 20, inCart: 0
}, {
    name: 'product-3', tag: 'product-3', price: 30, inCart: 0
}, {
    name: 'product-4', tag: 'product-4', price: 40, inCart: 0
},]

for (let i = 0; i < carts.length; i++) {
    carts[i].addEventListener('click', () => {
        cartCounter(products[i]);
        totalCost(products[i]);
    })
}

function onLoadCartNumbers() {
    let productNumbers = localStorage.getItem('cartCounter');

    if (productNumbers) {
        document.querySelector('.cart span').textContent = productNumbers;
    }
}

function cartCounter(product) {
    console.log("Clicked: ", product);
    let productNumbers = localStorage.getItem('cartCounter');
    productNumbers = parseInt(productNumbers);

    if (productNumbers) {
        localStorage.setItem('cartCounter', productNumbers + 1);
        document.querySelector('.cart span').textContent = productNumbers + 1;
    } else {
        localStorage.setItem('cartCounter', 1)
        document.querySelector('.cart span').textContent = 1;
    }

    setItems(product);
}

function setItems(product) {
    let cartItems = localStorage.getItem('productsInCart');
    cartItems = JSON.parse(cartItems);

    if (cartItems != null) {

        if (cartItems[product.tag] == undefined) {
            cartItems = {
                ...cartItems,
                [product.tag]: product
            }
        }
        cartItems[product.tag].inCart += 1;
    } else {
        product.inCart = 1;
        cartItems = {
            [product.tag]: product
        }
    }

    localStorage.setItem("productsInCart", JSON.stringify(cartItems));
}

function totalCost(product) {
    //console.log("The price is", product.price);
    let cartCost = localStorage.getItem('totalCost');

    if (cartCost != null) {
        cartCost = parseInt(cartCost);
        localStorage.setItem("totalCost", cartCost + product.price);
    } else {
        localStorage.setItem("totalCost", product.price);
    }
}

onLoadCartNumbers();