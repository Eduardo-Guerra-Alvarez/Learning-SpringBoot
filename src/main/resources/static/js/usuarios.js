// Call the dataTables jQuery plugin
$(document).ready(function() {
    cargarUsuarios();
  $('#usuarios').DataTable();
});

async function cargarUsuarios() {
    const response = await fetch("api/usuarios", {
        method: "GET",
        headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
        }
    })

    const usuarios = await response.json();

    let usuariosHTML = "";
    for(let usuario of usuarios) {
        usuariosHTML += `<tr>
                           <td>${usuario.id}</td>
                           <td>${usuario.nombre} ${usuario.apellido}</td>
                           <td>${usuario.email}</td>
                           <td>${usuario.telefono}</td>
                           <td>
                               <a href="#" onclick=eliminarUsuario(${usuario.id}) class="btn btn-danger btn-circle btn-sm">
                                   <i class="fas fa-trash"></i>
                               </a>
                           </td>
                       </tr>`
    }

    document.querySelector("#usuarios tbody").outerHTML = usuariosHTML;
}

async function eliminarUsuario(id) {
    const response = await fetch("api/usuarios/" + id, {
            method: "DELETE",
            headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
            }
        })
        cargarUsuarios();
        alert("Usuario Eliminado");

}
