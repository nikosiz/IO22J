const productCardTemplate = document.querySelector("[data-product-productCard-template]")
const productCardsContainer = document.querySelector("[data-product-productCards-container]")
const searchInput = document.querySelector("[data-search]")

let users = []

searchInput.addEventListener("input", e => {
    const value = e.target.value.toLowerCase()
    users.forEach(user => {
        const isVisible = user.name.toLowerCase().includes(value) ||
            user.phone.toLowerCase().includes(value) ||
            user.username.toLowerCase().includes(value) /*||
            user.website.toLowerCase().includes(value)*/
        user.element.classList.toggle("hide", !isVisible)
    })
})

fetch("https://jsonplaceholder.typicode.com/users")
    .then(res => res.json())
    .then(data => {
        //user z bazy users.json
        users = data.map(user => {
            const productCard = productCardTemplate.content.cloneNode(true).children[0]
            const prodName = productCard.querySelector("[data-name]")
            const prodPrice = productCard.querySelector("[data-price]")
            const prodShipPrice = productCard.querySelector("[data-ship-price]")
            const prodSeller = productCard.querySelector("[data-seller]")
            //const prodLink = productCard.querySelector("[data-link]")
            prodName.textContent = user.name
            prodPrice.textContent = user.id
            prodShipPrice.textContent = user.phone
            prodSeller.textContent = user.username
            //prodLink.textContent = user.website
            productCardsContainer.append(productCard)
            return {
                name: user.name,
                id: user.id,
                phone: user.phone,
                username: user.username,
                //website: user.website,
                element: productCard
            }
        })
    })