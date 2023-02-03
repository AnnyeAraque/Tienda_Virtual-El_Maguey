function loadData(){
    let request = sendRequest('productos/list', 'GET', '');
    let productos = document.getElementById("section-products");
    productos.innerHTML = "";
    request.onload = function(){
        let data = request.response;
        data.forEach((element, index) => {
            productos.innerHTML += `
            
            <li class="productos__seccion-item">
                <a href="vista-producto.html"><img class="producto__imagen" src="${element.ref_imagen}"></a>
                <p class="producto__descripcion">${element.info_producto}</p>
                <p class="producto__precio">${element.precio_producto}</p>
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

/* function loadCliente(idcliente){
    let request = sendRequest('cliente/list/'+idcliente, 'GET', '');
    let nodocumentoidentidad = document.getElementById('client_noDocumento');
    let nombre= document.getElementById('client_nombre');
    let apellido= document.getElementById('client_apellido');
    let telefono= document.getElementById('client_telefono');
    let correo= document.getElementById('client_correo');
    let id = document.getElementById('client_id');
    request.onload = function(){
        let data = request.response;
        id.value = data.idCliente;
        nodocumentoidentidad.value = data.noDocumentoIdentidad;
        nombre.value = data.nombre;
        apellido.value = data.apellido;
        telefono.value = data.telefono;
        correo.value = data.correo;
    }
    request.onerror = function(){
        alert('Error al recuperar los datos.')
    }
}

function deleteCliente(idcliente){
    let request = sendRequest('cliente/'+idcliente, 'DELETE', '');
    request.onload = function(){
        loadDatas();
    }
}

function saveCliente(){
    let id = document.getElementById('client_id').value;
    let nodocumentoidentidad = document.getElementById('client_noDocumento').value;
    let nombre= document.getElementById('client_nombre').value;
    let apellido= document.getElementById('client_apellido').value;
    let telefono= document.getElementById('client_telefono').value;
    let correo= document.getElementById('client_correo').value;
    let data = {
        'idCliente': id, 
        'noDocumentoIdentidad': nodocumentoidentidad, 
        'nombre': nombre, 
        'apellido': apellido, 
        'telefono': telefono, 
        'correo': correo
        } 
    let request = sendRequest('cliente/', id ? 'PUT' : 'POST', data);
    request.onload = function(){
        window.location = 'cliente.html';
    }
    request.onerror=function(){
        alert('Error al guardar');
    }
}
 * 
 */