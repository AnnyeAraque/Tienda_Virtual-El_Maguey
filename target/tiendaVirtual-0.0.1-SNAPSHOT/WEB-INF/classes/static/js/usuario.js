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


