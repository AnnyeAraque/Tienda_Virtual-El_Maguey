function saveUsuario(){
    let id = document.getElementById('id_usuario').value;
    let nombres = document.getElementById('nombres').value;
    let apellidos = document.getElementById('apellidos').value;
    let email= document.getElementById('email').value;
    let password= passwordSame(document.getElementById('password1').value, document.getElementById('password2').value);
    let data = {
        'idUsuario': id, 
        'nombres': nombres, 
        'apellidos': apellidos, 
        'email': email, 
        'password': password
        } 
    
    let request = sendRequest('/usuarios/', id ? 'PUT' : 'POST', data);
    request.onload = function(){
        window.location = 'index.html';
    }
    request.onerror=function(){
        alert('Error al guardar');
    }
}

function passwordSame(p1, p2) {
    if (p1 !== p2) {
       return alert('Passwords are not same');
    } else{
        return p1;
    }
}

function loadUserLogin(){
    let request = sendRequest('/usuarios/list', 'GET', '');
    console.log(request.response);
    let email = document.getElementById('usuario').value;
    let password = document.getElementById('password').value;
    request.onload = function (){
        let data = request.response;
        data.forEach((element, index) => {
            if (element.email === email && element.password === password){
                window.location = "index.html";
                
            } else{
                alert('Usuario no registrado');
            }
            
        });
    };
}

