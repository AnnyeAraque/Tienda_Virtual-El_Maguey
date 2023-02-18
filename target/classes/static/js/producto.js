function loadData(){
    let request = sendRequest('/productos/list', 'GET', '');
    let productos = document.getElementById("section-products");
    console.log(request);
    productos.innerHTML = "";
    request.onload = function(){
        let data = request.response;
        data.forEach((element, index) => {
            
            productos.innerHTML += `
            
            <li class="productos__seccion-item">
                <a href="vista-producto.html"><img class="producto__imagen" src="${element.refImagen}"></a>
                <p class="producto__descripcion">${element.infoProducto}</p>
                <p class="producto__precio">${element.precioProducto}</p>
            </li>
        `
        });
    }
    request.onerror = function(){
        productos.innerHTML = `
        <h1>ERROR</h1>
        `
    }
}
