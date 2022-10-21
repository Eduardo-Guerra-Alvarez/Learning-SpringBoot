// Call the dataTables jQuery plugin
$(document).ready(function() {
});

async function loginUsuario() {

        const response = await fetch("api/login", {
            method: "POST",
            body: JSON.stringify({
                email: document.getElementById('email').value,
                password: document.getElementById('password').value,
            }),
            headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
            }
        })

        const usuario = await response.json();
        if(usuario.message === "successfull") {
            window.location.href = "usuarios.html"
        } else {
            alert("Credenciales Incorrectas")
        }
}

