const page = {
    url: {
        getAllOrderList:"http://localhost:8080/api/order"
    },
    elements: {},
    loadData: {},
    commands: {}
}

const tbOrderList = $("#tbOrderList");

function fetchAllOrderList(){
    return $.ajax({
        url: page.url.getAllOrderList,
        method: 'GET',
        dataType: 'json'
    });
}

page.loadData.getAllOrderList = async() =>{
    const order= await fetchAllOrderList();
    console.log(order)
      order.forEach((item) => {
        const str =  page.commands.renderOrderList(item);
        tbOrderList.append(str);
    });
}

page.commands.renderOrderList= async (order)=>{
    return`
     <tr>
<!--                                    <td class="text-end align-middle">Nov 29 2023</td>-->
                                    <td class="text-end align-middle">${order.totalProduct}</td>
                                    <td class="text-end align-middle">$${order.subTotal}</td>
                                    <td class="text-end align-middle">${order.shipping}</td>
                                    <td class="text-end align-middle">$${order.totalAmount}</td>
                                    <td class="text-end align-middle"><span class="badge bg-secondary">${order.status}</span></td>
                                    <td class="text-start align-middle">${order.customerInfo.fullName}</td>
                                    <td class="text-end align-middle"><i class="fa-solid fa-ellipsis-vertical"></i>

                                    </td>
                                </tr>
    `;
}

$(async () => {
   await page.loadData.getAllOrderList()

})