window.addEventListener('load', function () {
    const formulario = document.querySelector('#update_turnos_form');

    formulario.addEventListener('submit', function (event) {
        let turnoId = document.querySelector('#turno_id').value;

        const formData = {
            odontologo: document.querySelector('#odontologo').value,
            paciente: document.querySelector('#paciente').value,
            fecha: document.querySelector('#fecha').value,
        };

        const url = '/turnos';
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

function findBy(id) {
    const url = '/turnos'+"/"+id;
    const settings = {
        method: 'GET'
    }
    fetch(url,settings)
        .then(response => response.json())
        .then(data => {
            let turno = data;
            document.querySelector('#odontologo').value = turno.id;
            document.querySelector('#paciente').value = turno.paciente.id,
            document.querySelector('#fecha').value = turno.fecha,

            document.querySelector('#div_turnos_updating').style.display = "block";
        }).catch(error => {
        alert("Error: " + error);
    })
}