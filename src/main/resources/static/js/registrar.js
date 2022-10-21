// Call the dataTables jQuery plugin
$(document).ready(function() {
});

async function registrarUsuario() {
    if(document.getElementById('password1').value != document.getElementById('password2').value) {
        alert("Contraseña no coincide");
        return;
    }
    const response = await fetch("api/usuarios", {
        method: "POST",
        body: JSON.stringify({
            nombre: document.getElementById('nombre').value,
            apellido: document.getElementById('apellido').value,
            email: document.getElementById('email').value,
            password: document.getElementById('password1').value,
        }),
        headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
        }
    })

    alert("Usuario creado con exito");
    windows.location.href = "login.html";
}

