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

let sumar = document.getElementById("mas");
let restar = document.getElementById("menos");
let contador = document.getElementById("contador");
let prevValue;


function calcular() {
  var value = contador.value;
  var isValid = /^[1-9][0-9]*$/.test(value);

  if (!isValid) {
          contador.value = prevValue;
        } else {
          prevValue = value;
        }
}

      sumar.onclick = function() {
        contador.value = Number(contador.value) + 1;
        calcular();
      };

      restar.onclick = function() {
        contador.value = Number(contador.value) - 1;
        calcular();
      };

      contador.onchange = function() {
        calcular();
      };

      contador.onkeyup = function() {
        if (contador.value === "") {
          return;
        }
        calcular();
      };

      calcular();
