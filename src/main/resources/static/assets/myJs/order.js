const page = {
    url: {
        getAllOrderList: "http://localhost:8080/api/order"
    },
    elements: {},
    loadData: {},
    commands: {}
}

const tbOrderList = $("#tbOrderList tbody");


function fetchAllOrderList() {
    return $.ajax({
        url: page.url.getAllOrderList,
        method: 'GET',
        dataType: 'json'
    });
}

page.loadData.getAllOrderList = async () => {
    const order = await fetchAllOrderList();
    console.log(order)
    order.forEach((item) => {
        const str = renderOrderList(item);
        tbOrderList.append(str);
    });
}

 function renderOrderList (order){
    return `
     <tr
<!--                                    <td class="text-end align-middle">Nov 29 2023</td>-->
                                    <td class="text-center align-middle">${order.totalProduct}</td>
                                    <td class="text-center align-middle">$${order.subTotal}</td>
                                    <td class="text-end align-middle">${order.shipping}</td>
                                    <td class="text-end align-middle">$${order.totalAmount}</td>
                                    <td class="text-end align-middle"><span class="badge bg-secondary">${order.status}</span></td>
                                    <td class="text-start align-middle">${order.customerInfo.fullName}</td>
                                    <td class="text-end align-middle ">
                                    <i class="fa-solid fa-ellipsis-vertical" ></i>
                                    
                                    <div class="hide">
                                    <div class="col-lg-5 border p-2 rounded">
                                    <div class="d-flex align-items-center justify-content-between border-bottom">
                                    <h5>Order details</h5>
                                    <span role="button" class="btn-close"></span>
                                    </div>
                                    <div class="my-2 border-bottom">
                                    <h6>Order Information</h6>
                                    <div class="d-flex justify-content-between mb-2">
                                    <span>Subtotal</span>
                                    <span class="fw-bolder">$${order.subTotal}</span>
                                    </div>
                                    <div class="d-flex justify-content-between mb-2">
                                    <span>Shipping</span>
                                    <span class="fw-bolder">${order.shipping}</span>
                                    </div>
                                    <div class="d-flex justify-content-between mb-2">
                                    <span>Total</span>
                                    <span class="fw-bolder">$${order.totalAmount}</span>
                                    </div>
                                    </div>
                                    <div class="my-2 border-bottom">
                                    <h6>Customer Information</h6>
                                    <div class="d-flex justify-content-between mb-2">
                                    <span>Fullname</span>
                                    <span class="fw-bolder">${order.customerInfo.fullName}</span>
                                    </div>
                                    <div class="d-flex justify-content-between mb-2">
                                    <span>Email</span>
                                    <span class="fw-bolder">${order.customerInfo.email}</span>
                                    </div>
                                    <div class="d-flex justify-content-between mb-2">
                                    <span>Mobile</span>
                                    <span class="fw-bolder">${order.customerInfo.mobile}</span>
                                    </div>
                                    <div class="d-flex justify-content-between mb-2">
                                    <span>Address</span>
                                    <span class="fw-bolder">${order.customerInfo.address}</span>
                                    </div>
                                    </div>
                                    <div class="my-2 border-bottom">
                                    <h6>Order details</h6>
                                    <table class="table table-striped">
                                    <tbody>
                                    <tr>
                                    <td style="width: 250px;">
                                    <div class="d-flex align-items-center">
                                    <img class="me-2" src="https://m.media-amazon.com/images/I/51+P9uAvb1L._AC_UY695_.jpg" style="width: 50px;">Nike Waffle One Sneaker</div>
                                    </td>
                                    <td class="text-end align-middle">1</td>
                                    <td class="text-end align-middle">$200</td>
                                    <td class="text-end align-middle fw-bolder">$200</td>
                                    </tr>
    `;
}

$(async () => {
    await page.loadData.getAllOrderList()

})