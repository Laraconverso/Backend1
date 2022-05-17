import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PersonaTest {
    @Test
    public void probarMayrEdad(){
        //se crean las personas a probar
        Persona persona1 = new Persona("Delfina", 15);
        Persona persona2 = new Persona("Lara", 21);

        //Pruebas
        Assertions.assertTrue(persona2.esMayorDeEdad(), "La persona 2 es mayor de edad");
        Assertions.assertFalse(persona1.esMayorDeEdad(), "La persona 1 es menor de edad");
    }
}