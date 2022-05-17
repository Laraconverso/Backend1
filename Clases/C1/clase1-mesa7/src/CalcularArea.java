

public class CalcularArea {

    private String nombre;
    private double valor;
    private final double pi= Math.PI;

    public CalcularArea(String nombre, double valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public String CalcularAreaCirculo(){
        if(this.valorMayorAcero()){
            return "el area del " + this.nombre + " es " + Math.round(pi*(Math.pow(this.valor, 2)));
        }else{
            return "el valor del radio debe ser mayor a cero";
        }
    }

    public String CalcularAreaCuadrado(){
        if(this.valorMayorAcero()){
            return "el area del " + this.nombre + " es " + Math.round(Math.pow(this.valor,2));
        }else{
            return "el valor del lado debe ser mayor a cero";
        }
    }

    public boolean valorMayorAcero(){
        return this.valor >0;
    }
}
