window.addEventListener('load', function () {


    //Buscamos y obtenemos el formulario donde estan
    //los datos que el usuario pudo haber modificado del odontolohgo
    const formulario = document.querySelector('#update_pacientes_form');

    formulario.addEventListener('submit', function (event) {
        let pacienteId = document.querySelector('#paciente_id').value;

        //creamos un JSON que tendrá los datos del paciente
        //a diferencia de un paciente nuevo en este caso enviamos el id
        //para poder identificarlo y modificarlo para no cargarlo como nuevo
        const formData = {
            id: document.querySelector('#paciente_id').value,
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            matricula: document.querySelector('#matricula').value,

        };

        //invocamos utilizando la función fetch la API pacientes con el método PUT que modificará
        //al paciente que enviaremos en formato JSON
        const url = '/pacientes';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
        fetch(url,settings)
            .then(response => response.json())

    })
})

//Es la funcion que se invoca cuando se hace click sobre el id de un pacientes del listado
//se encarga de llenar el formulario con los datos del paciente
//que se desea modificar
function findBy(id) {
    const url = '/pacientes'+"/"+id;
    const settings = {
        method: 'GET'
    }
    fetch(url,settings)
        .then(response => response.json())
        .then(data => {
            let paciente = data;
            document.querySelector('#paciente_id').value = paciente.id;
            document.querySelector('#nombre').value = paciente.nombre;
            document.querySelector('#apellido').value = paciente.apellido;
            document.querySelector('#matricula').value = paciente.matricula;
            //el formulario por default esta oculto y al editar se habilita
            document.querySelector('#div_paciente_updating').style.display = "block";
        }).catch(error => {
        alert("Error: " + error);
    })
}