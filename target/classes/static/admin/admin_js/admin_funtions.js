function loadDataProductos(){
    let request = sendRequest('/productos/list', 'GET', '');
    let productos = document.getElementById("products-table");
    productos.innerHTML = "";
    request.onload = function(){
        let data = request.response;
        data.forEach((element, index) => {
            
            productos.innerHTML += `
            
            <tr>
                <td>${element.idProducto}</td>
                <td>${element.nombreProducto}</td>
                <td>${element.infoProducto}</td>
                <td>${element.precioProducto}</td>
                <td>${element.refImagen}</td>
                <td>${(element.estadoCatalogo === 1 ? 'Disponible' : 'Agotado')}</td>
                <td>
                    <button type="button" class="btn btn-primary" onclick='window.location = "/admin/admin_form_producto.html?id=${element.idProducto}"'>Editar</button>
                    <button type="button" class="btn btn-danger" onclick='deleteProducto(${element.idProducto})'>Eliminar</button>
                </td>
            </tr>
        `
        });
    }
    request.onerror = function(){
        productos.innerHTML = `
        <h1>ERROR</h1>
        `
    }
}

function saveProducto(){
    let id = document.getElementById('product_id').value;
    let nombre = document.getElementById('product_nombre').value;
    let infoProduct = document.getElementById('product_info').value;
    let price= document.getElementById('product_price').value;
    let refImg= document.getElementById('product_ref_img').value;
    let estado= document.getElementById('product_disp').value;
    let data = {
        'idProducto': id, 
        'nombreProducto': nombre, 
        'infoProducto': infoProduct, 
        'precioProducto': price,
        'refImagen': refImg,
        'estadoCatalogo': estado
        } 
    
    let request = sendRequest('/productos/', id ? 'PUT' : 'POST', data);
    request.onload = function(){
        window.location = '/admin/admin_productos.html';
    }
    request.onerror=function(){
        alert('Error al guardar');
    }
}

function loadProducto(idproducto){
    let request = sendRequest('/productos/list/'+idproducto, 'GET', '');
    let nombre = document.getElementById('product_nombre');
    let infoProduct = document.getElementById('product_info');
    let price= document.getElementById('product_price');
    let refImg= document.getElementById('product_ref_img');
    let estado= document.getElementById('product_disp');
    let id = document.getElementById('product_id');
    request.onload = function(){
        let data = request.response;
        id.value = data.idProducto;
        nombre.value = data.nombreProducto;
        infoProduct.value = data.infoProducto;
        price.value = data.precioProducto;
        refImg.value = data.refImagen;
        estado.value = data.estadoCatalogo;
    }
    request.onerror = function(){
        alert('Error al recuperar los datos.')
    }
}

function deleteProducto(id){
    let request = sendRequest('/productos/'+id, 'DELETE', '');
    request.onload = function(){
        loadDataProductos();
    }
}

function adminInicio(){
    let user = "admin";
    let password = "admin";
    let userInsert = document.getElementById('admin_user').value;
    let passwordInsert = document.getElementById('admin_password').value;
    if (user === userInsert && password === passwordInsert){
        return window.location = '/admin/admin.html';
    } else{
        alert('Credentials are incorrect')
    }
}

function loadDataUsers(){
    let request = sendRequest('/usuarios/list', 'GET', '');
    let productos = document.getElementById("users-table");
    productos.innerHTML = "";
    request.onload = function(){
        let data = request.response;
        data.forEach((element, index) => {
            
            productos.innerHTML += `
            
            <tr>
                    <td>${element.idUsuario}</td>
                    <td>${element.nombres}</td>
                    <td>${element.apellidos}</td>
                    <td>${element.email}</td>
                    <td>${element.dirDomicilio}</td>
                    <td>${element.password}</td>
                    <td>
                        <button type="button" class="btn btn-danger">Eliminar</button>
                    </td>
            </tr>
        `
        });
    }
    request.onerror = function(){
        productos.innerHTML = `
        <h1>ERROR</h1>
        `
    }
}