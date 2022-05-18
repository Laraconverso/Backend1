# Backend I

Estado: Cursando

# Notas de clases y mesas

## Clase 1

Notas de material

- ***Que es backend1?***
    
    Es la parte del sitio o aplicación con la que los usuarios no tienen contacto, sin embargo, resulta una parte fundamental de cualquier aplicación. Si está leyendo este texto, por ejemplo, es una señal de que la comunicación con el servidor fue exitosa y esto probablemente se deba al buen trabajo del programador back-end.
    
- ***Introducción a JUnit***
    
    Nos permite generalizar lo que sucede en cada test, utilizando las siguientes anotaciones.
    
    ```java
    import org.juint.jupiter.api.Test*;
    
    import static org.junit.jupiter.api.Assertions.*;
    
    class AssertionsTest{
    
    	@Test
    
    	void standardAssertions(){
    
    		assertEquals(2,2); *//--> evalua si son iguales*
    
    		assertTrue(edad == 2, "Son iguales los numeros?"); *//-->evalua si es verdadera la cuestion*
    
    	 }
    
    }
    
    @Rule public ExpectedException thrown= ExpectedException.none();
    
    @Test
    
    public void myTest(){
    
    	thrown.expect(Exception.class);
    
    	thrown.expectMessage("Init Golf must be >= 0");
    
    	rodgers = *new* Pirate("Dread Pirate Rodgers", -100);
    
    }
    ```
    
    Con los test de integración nos aseguramos que los diferentes flujos de código funcionan correctamente.
    
    Tests unitarios y de integración, necesitamos saber si nuestro sistema cumple con las especificaciones o mejorar una parte de código.
    
    ![Captura de Pantalla 2022-05-16 a la(s) 01.22.35.png](Backend%20I%205c88e9bc8b164c06811f1ce0858d6da5/Captura_de_Pantalla_2022-05-16_a_la(s)_01.22.35.png)
    
    - Assertions
        - assertArrayEquals
        - assertEquals
        - assertTrue and assertFalse
        - assertNull and assertNotNull
        - assertSame and assertNotSame
        - assertAll
        - assertNotEquals
        - assertIterableEquals
        - assertThrows
        - assertTimeout and assertTimeoutPreemptively
        - assertLinesMatch
- ***Tests Unitarios***
- ***JUnit***

Notas de clase

```java
//Primero importamos los test 
y creamos una clase con ...Test
y hacemos 
@Test 
public void probarMayrEdad(){
        //se crean las personas a probar
        Persona persona1 = new Persona("Delfina", 15);
        Persona persona2 = new Persona("Lara", 21);

        //Pruebas
        Assertions.assertTrue(persona2.esMayorDeEdad(), "La persona 2 es mayor de edad");
        Assertions.assertFalse(persona1.esMayorDeEdad(), "La persona 1 es menor de edad");
    }
```

## Clase 2

Notas de material

- ***Patrón Template Method***
    
    ![Backend%20I%205c88e9bc8b164c06811f1ce0858d6da5/Untitled.png](Backend%20I%205c88e9bc8b164c06811f1ce0858d6da5/Untitled.png)
    
    ![Backend%20I%205c88e9bc8b164c06811f1ce0858d6da5/Untitled%201.png](Backend%20I%205c88e9bc8b164c06811f1ce0858d6da5/Untitled%201.png)
    
    ### Ventajas
    
    - Los clientes pueden sobrescribir ciertas partes de un algoritmo grande para que le safecten menos los cambios que tienen lugar en otras partes
    - Se puede colocar código duplicado dentro de una superclase
    
    ### Desventajas
    
    - Posee un alto grado de dependencia en la interfaz de la fachada
    - Algunos clientes pueden verse limitados por el esqueleto proporcionado por el algoritmo
    
    ### Ejemplo
    
    [Backend%20I%205c88e9bc8b164c06811f1ce0858d6da5/Ejemplo_de_Patrn_Template_Method.pdf](Backend%20I%205c88e9bc8b164c06811f1ce0858d6da5/Ejemplo_de_Patrn_Template_Method.pdf)
    
    [cocinero.zip](Backend%20I%205c88e9bc8b164c06811f1ce0858d6da5/cocinero.zip)
    

Notas de clase

## Clase 3 - Integradora I

Notas de clase

## Clase 4

Notas de material

- ***Patrón cadena de responsabilidad***
    
    ![Backend%20I%205c88e9bc8b164c06811f1ce0858d6da5/Untitled%202.png](Backend%20I%205c88e9bc8b164c06811f1ce0858d6da5/Untitled%202.png)
    
    ![Backend%20I%205c88e9bc8b164c06811f1ce0858d6da5/Untitled%203.png](Backend%20I%205c88e9bc8b164c06811f1ce0858d6da5/Untitled%203.png)
    
    ### Ventajas
    
    - Mayor flexibilidad para procesar las peticiones del cliente. Es posible agregar objetos que sepan resolver nuevas responsabilidades o modificar las actuales sin afectar al cliente.
    - Menor acoplamiento. Permite que un objeto envíe una petición y sepa que va a ser tratada, pero tanto el emisor como el receptor no conocen nada del otro.
    
    ### Desventajas
    
    - Puede ser complejo implementar la cadena, y si no está bien configurada, puede que no se cubran todas las peticiones.
    
    ### Ejemplo
    
    [Backend%20I%205c88e9bc8b164c06811f1ce0858d6da5/Ejemplo_Cadena_de_Responsabilidad.pdf](Backend%20I%205c88e9bc8b164c06811f1ce0858d6da5/Ejemplo_Cadena_de_Responsabilidad.pdf)
    
    [creditos.zip](Backend%20I%205c88e9bc8b164c06811f1ce0858d6da5/creditos.zip)
    

Notas de clase

## Clase 5

Notas de material

- ***Patrón Proxy***

Notas de clase

## Clase 6 - Integradora II

Notas de clase

## Clase 7

Notas de material

Notas de clase