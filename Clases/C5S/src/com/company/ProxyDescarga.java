package com.company;

public class ProxyDescarga implements IServicioDescarga{

    private Usuario usuario;
    private ServicioDescarga servicio;

    public ProxyDescarga(Usuario usuario, ServicioDescarga servicio) {
        this.usuario = usuario;
        this.servicio = servicio;
    }

    @Override
    public String descargar(String cancion) {
        if(this.usuario.getTipoUsuario().equals("Premium")){
            return this.servicio.descargar(cancion);
        } else{
            System.out.println("Usuario free, no tienes acceso.");
            return "Usuario free, no tienes acceso.";
        }
    }
}
