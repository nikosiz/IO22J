var modal = document.getElementById("search-many-modal");
// Get the button that opens the modal
var btn = document.getElementById("search-modal-btn");

// Get the add field button
var addFieldBtn = document.getElementById("add-field-btn");

var fieldCount = 1;

// Add an event listener to the button
addFieldBtn.addEventListener("click", function (event) {
    event.preventDefault();

    if (fieldCount < 10) {

        // Create a new div element
        var fieldContainer = document.createElement("div");
        fieldContainer.classList.add("field-container");
        fieldContainer.id = "field-container";

        // Create a new input field
        var input = document.createElement("input");
        input.id = "search";
        input.name = "productsToSearch";
        input.placeholder = "Search...";
        input.type = "text";

        // Create a delete button for the input field
        var deleteBtn = document.createElement("button");
        deleteBtn.innerHTML = "Delete";
        deleteBtn.classList.add("delete-field-btn");

        // Append the input field and delete button to the container
        fieldContainer.appendChild(input);
        fieldContainer.appendChild(deleteBtn);
        var container = document.getElementById("input-fields-container");
        container.appendChild(fieldContainer);

        fieldCount++;
    }
});

document.addEventListener("DOMContentLoaded", function () {
    // Select the form element
    var form = document.querySelector("form")[1];
    // Add the submit event listener to the form
    form.addEventListener("submit", function (event) {
        event.preventDefault();
        var selectedOption = document.querySelector("input[name='sorting']:checked");
        selectedOption.classList.add("selected");
    });
});

var options = document.querySelectorAll("input[name='sorting']");
options.forEach(function (option) {
    option.addEventListener("change", function () {
        var selectedOption = document.querySelector("input[name='sorting']:checked");
        var allOptionLabels = document.querySelectorAll("label");
        allOptionLabels.forEach(function (label) {
            label.classList.remove("selected");
        });
        selectedOption.parentElement.classList.add("selected");
    });
});

var container = document.getElementById("input-fields-container");
container.addEventListener("click", function (event) {
    if (event.target.classList.contains("delete-field-btn")) {
        var field = event.target.parentNode;
        field.remove();
        fieldCount = fieldCount - 1;
    }
});

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close-modal")[0];

// When the user clicks on the button, open the modal
btn.onclick = function () {
    modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function () {
    modal.style.display = "none";
    fieldCount = fieldCount;
}

// When the user clicks anywhere outside the modal, close it
window.onclick = function (event) {
    if (event.target == modal) {
        modal.style.display = "none";
        fieldCount = fieldCount;
    }
}

function addToCart(name, price, shippingPrice, seller, thumbnailUrl, redirectUrl, email) {
    var token = $('#_csrf').attr('content');
    var header = $('#_csrf_header').attr('content');

    $.ajax("/cart/add", {
        url: "/cart/add",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify({
            "userEmail": email,
            "name": name,
            "price": price,
            "shippingPrice": shippingPrice,
            "seller": seller,
            "thumbnailUrl": thumbnailUrl,
            "redirectUrl": redirectUrl
        }),
        beforeSend: function (xhr) {
            xhr.setRequestHeader(header, token);
        },
        success: () => {
            console.log("dodano do koszyka bicz");
        }
    });
}
