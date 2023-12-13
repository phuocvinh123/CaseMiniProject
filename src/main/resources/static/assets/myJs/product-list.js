const page = {
    url: {
        getAllProductList:"http://localhost:8080/api/product-list"
    },
    elements: {},
    loadData: {},
    commands: {}
}


const productList = $("#product-list tbody")
const createProduct=$("#createProduct");

createProduct.on("click",async ()=>{
    const title=$("#title").val();
    const price =parseInt($("#price").val());
    const color = $("#color").find('option:selected').val();
    const category = $("#category").find('option:selected').val();
    const company = $("#company").find('option:selected').val();
    const img=$("#output").val()

    const obj={
        title,
        price,
        color,
        category,
        company,
        img
    }
    $.ajax({
        url: page.url.getAllProductList,
        contentType: 'application/json',
        method: 'POST',
        data: JSON.stringify(obj),
    }).done((data) => {
        const str = renderProductList(data)
        productList.prepend(str);
       toastr.success("thêm mới thành công")
    })
        .fail(function (jqXHR, textStatus, errorThrown) {
        console.log("lỗi")
    });

})

let loadFile = function(event) {
    let reader = new FileReader();
    reader.onload = function(){
        let output = document.getElementById('output');
        output.src = reader.result;
    };
    reader.readAsDataURL(event.target.files[0]);
};

page.loadData.getAllProductList =async  ()=>{
    const product=await fetchAllProductList();
    console.log(product)
    product.forEach((item) =>{
        const str= renderProductList(item);
        productList.append(str)
    })
}

function fetchAllProductList() {
    return $.ajax({
        url: page.url.getAllProductList,
        method: 'GET',
        dataType: 'json'
    });
}

function renderProductList(product){
    return`
    <tr>
                                <td class="text-start align-middle" style="min-width: 250px">
                                    <div class="d-flex align-items-center">
                                    <img src="${product.img}"  style="width: 50px;">
                                    <span class="ms-2">${product.title}</span>
                                    </div>
                                </td>
                                <td class="text-start align-middle">
                                <span class="badge px-2 py-1 border text-black"
                                   style="background-color: ${product.color.nameColor}">${product.color.nameColor}</span>
                                </td>
                                <td class="text-start align-middle">${product.category.nameCategory}</td>
                                <td class="text-start align-middle">${product.company.nameCompany}</td>
                                <td class="text-end align-middle">
                                    <div class="d-flex flex-column">
                                        <del>$${product.prevPrice}</del>
                                        <span>$${product.newPrice}</span></div>
                                </td>
                                <td class="text-center align-middle">
                                    <div class="d-flex flex-column align-items-center justify-content-center">
                                        <div class="d-flex align-items-center"><span class="me-1">${product.star}</span>
                                            <i class="fa-solid fa-star" style="    color: #ffff00cf;"></i>
                                        </div>
                                        <div><span class="me-1">${product.reviews}</span>
                                           <i class="fa-solid fa-eye" style="color: #188c18"></i>
                                        </div>
                                    </div>
                                </td>
                                <td class="text-center align-middle">
                                    <div class="d-flex align-items-center justify-content-center">
                                       <i class="fa-solid fa-pen-to-square" style="color: #188c18"></i>
                                       <i class="fa-solid fa-trash-can" style="color: red"></i>
                                    </div>
                                </td>
                            </tr>
    `
}




$(async () => {
    await page.loadData.getAllProductList()

})


