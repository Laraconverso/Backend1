window.addEventListener('load', function () {
    window.deleteBy = (id) => {
      if (window.confirm('Desea eliminar este odontologo?')) {
        const url = '/odontologos/'+ id;
        const settings = {
          method: 'DELETE',
        };

        fetch(url, settings).then((response) => {
          alert('usuario eliminado correctamente');
          location.reload();
        });
      }
    };
})