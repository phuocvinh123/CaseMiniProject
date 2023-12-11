const page = {
    url: {
        getAllProduct: "http://localhost:8080/api/product",
        getAllCategory:"http://localhost:8080/api/product/category",
        getAllColor:"http://localhost:8080/api/product/color"
    },
    elements: {},
    loadData: {},
    commands: {}
}

$(async () => {
    await page.loadData.getAllProduct()

    $('input[name="category"], input[name="price"], input[name="color"] ,input[name="options-base"] ' ).on('change', function () {
        pageCurrent = 0;
        filterProducts();
    });

    $(`input[type="search"]`).on('input', filterProducts);

    $('.selectOption').on('change', function (){
        pageCurrent = 0
        filterProducts();
    })

})


const tbody = $("#bodyProduct");
const categoryBody = $("#categoryBody");
const tbColor = $("#tbColor");

let pageCurrent= 0;
// const buttons = document.querySelectorAll('.btn');

 function fetchAllCategory() {
    return $.ajax({
        url: page.url.getAllCategory,
        method: 'GET',
        dataType: 'json'
    });
}

function fetchAllColor() {
    return $.ajax({
        url: page.url.getAllColor,
        method: 'GET',
        dataType: 'json'
    });
}

async function fetchAllCartDetail() {
    const response = await fetch("http://localhost:8080/api/cart/cartDt");
    return await response.json();
}

page.loadData.getAllProduct = async () => {
    await filterProducts();
    const cart = await fetchAllCartDetail();
    $('.quantity-cart-detail').text(cart.length)
    // document.querySelector(".quantity-cart-detail").innerText = cart.length;

    await getAllColor()
    await getAllCategory()
};

const getAllCategory = async () => {
    const categories = await fetchAllCategory();
    categories.forEach((item) => {
        const str = renderCategory(item);
        categoryBody.append(str);
    });
}

const getAllColor = async () => {
    const colors = await fetchAllColor();
    colors.forEach((item) => {
        const str = renderColor(item);
        tbColor.append(str);
    });

}

function renderColor(color) {
    return `
    <div class="form-check py-1">
        <input class="form-check-input" type="radio" name="color" id="color_${color.id}" value="${color.nameColor}"
            style="background-color: ${color.nameColor}"/>
        <label for="color_${color.id}" role="button" class="form-check-label">${color.nameColor}</label>
    </div>`;
}

function renderCategory(category) {
    return `
    <div class="form-check py-1">
        <input class="form-check-input" type="radio" name="category" id="category_${category.id}" value="${category.nameCategory}" />
        <label for="category_${category.id}" class="form-check-label">${category.nameCategory}</label>
    </div>`;
}

function renderProduct(product) {
    const starRating = getStarRating(product.star);
    return `
      <div class="col-md-3 mb-4">
        <div class="card d-flex align-items-center pt-2" >
          <img src="${product.img}"  class="card-img-top" alt="${product.title}" width="20" height="100">
          <div class="card-body">
            <h5 class="card-title">${product.title}</h5>
            <p class="card-star"><span class="star-rating">${starRating}</span> (${product.reviews} reviews)</p>
            <div class="d-flex align-items-center justify-content-between">
            <div>
            <del class="line-through me-2"> $${product.prevPrice}</del>
            <span>$${product.newPrice}</span>
            </div>
            <a href="#" class="icon"  id="cartIcon" onclick="addToCart(${product.id})"><i class="fa-solid fa-cart-arrow-down"></i></a>
            </div>
          </div>
        </div>
      </div>
    `;
}

function addToCart(idProduct) {
    const obj = {
        idProduct
    }
    fetch("http://localhost:8080/api/cart/create", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(obj)
    })
        .then(function (response) {
            if (response.ok) {

                alert("Product added to cart.")
                getAllProduct();
                // console.log("Product added to cart.");
            } else {

                alert("Failed to add product to cart.");
            }
        })
        .catch(function (error) {
            // Xử lý lỗi trong trường hợp có lỗi xảy ra trong quá trình gọi API
            console.error("API call error:", error);
        });
}

function getStarRating(stars) {
    const maxStars = 5;
    const fullStar = "★";
    // const halfStar = '☆';

    const fullStarsCount = Math.floor(stars);
    const hasHalfStar = stars % 1 !== 0;
    let starRating = "";
    for (let i = 0; i < fullStarsCount; i++) {
        starRating += fullStar;
    }
    if (hasHalfStar) {
        starRating += "";
    }
    for (let i = 0; i < maxStars - Math.ceil(stars); i++) {
        starRating += "";
    }
    return starRating;
}



function filterProducts() {
    const searchInput = $('input[type="search"]').val();
    const category = $('input[name="category"]:checked').val().toLowerCase();
    const color = $('input[name="color"]:checked').val().toLowerCase();
    const options = $('input[name="options-base"]:checked').val().toLowerCase();
    const priceInput = $('input[name="price"]:checked').val();
    const priceValues = priceInput.split(',');
    const maxPrice = priceValues[1];
    const minPrice = priceValues[0];
    const strField = $('#selected-sortField').find(":selected").val()
    const strSort = $('#selected-sortDirection').find(":selected").val()

    $.ajax({
        url: "http://localhost:8080/api/filter",
        contentType: 'application/json',
        method: 'GET',
        data: {
            search: searchInput,
            category: category,
            company: options,
            color: color,
            maxPrice: maxPrice,
            minPrice: minPrice,
            page: pageCurrent,
            size: 8,
            sortField : strField,
            direction : strSort
        },
    }).done(function (filteredProducts) {
        tbody.empty();

        filteredProducts.content.forEach(item => {
            const str = renderProduct(item);
            tbody.append(str);
        });

        renderPagination(filteredProducts.totalPages)

    }).fail(function (jqXHR, textStatus, errorThrown) {
        console.log("lỗi")
    });
}

function renderPagination( totalPages){
    const page=$("#page");
    page.empty()
 for (let i= 0 ;i<totalPages;i++){
     const  strRenderPage=`<li class="page-item btn-get-page"><a class="page-link ${i === pageCurrent ? 'active' : ''}">${i+1}</a></li>`
     page.append(strRenderPage)
 }

    $('.btn-get-page').on("click", function (){
        pageCurrent = parseInt(this.querySelector('.page-link').innerText) - 1
        console.log(pageCurrent)
        filterProducts()
    })

}
















