window.addEventListener('load', function () {
    window.deleteBy = (id) => {
      if (window.confirm('Desea eliminar este odontologo?')) {
        const url = '/turnos/'+ id;
        const settings = {
          method: 'DELETE',
        };

        fetch(url, settings).then((response) => {
          alert('turno eliminado correctamente');
          location.reload();
        });
      }
    };
})