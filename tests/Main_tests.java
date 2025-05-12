package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scr.personas.Empleado;
import scr.main.*;
import scr.atracciones.*;
import scr.personas.*;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Main_test {
	
	private ArrayList<Atraccion> atracciones;
    private Administrador admin;
    private ArrayList<Empleado> empleados;

    @BeforeEach
    void setUp() {
        empleados = new ArrayList<>();
        atracciones = new ArrayList<>();
        admin = new Administrador(1, "Juan", "admin@gmail.com", "1234");
    }

    @Test
    void testAñadirYBuscarEmpleado() {
        // Crear empleado
        Empleado empleado = new Empleado(
                "Juan", "juan@mail.com", "1234",
                101, 5,
                new ArrayList<>(),
                true,
                true,
                new ArrayList<>(),
                new ArrayList<>()
        );
        
        empleados.add(empleado);
        Empleado resultado = Main.buscarEmpleado(empleados, 101);

        // Validaciones
        assertNotNull(resultado);
        assertEquals("Juan", resultado.getNombre());
        assertEquals(5, resultado.getLugarTrabajo());
        assertTrue(resultado.getEsCocinero());
    }

    @Test
    void testBuscarEmpleadoNoExistente() {
        Empleado resultado = Main.buscarEmpleado(empleados, 999);
        assertNull(resultado);
    }
    
    @Test
    void testEditarEmpleado() {
        Empleado empleado = new Empleado(
                "Ana", "ana@mail.com", "abcd",
                202, 3,
                new ArrayList<>(),
                false,
                false,
                new ArrayList<>(),
                new ArrayList<>()
        );
        empleados.add(empleado);

        // Editar datos
        empleado.setLugarDeTrabajo(10);
        empleado.setCocinero(true);

        ArrayList<String> nuevosPuestos = new ArrayList<>();
        nuevosPuestos.add("Admin");
        empleado.setPuesto(nuevosPuestos);

        // Validar cambios
        assertEquals(10, empleado.getLugarTrabajo());
        assertTrue(empleado.getEsCocinero());
        assertEquals(1, empleado.getPuesto().size());
        assertEquals("Admin", empleado.getPuesto().get(0));
    }

    @Test
    void testAñadirMecanica() {
        Mecanica m = new Mecanica(
                101, 30, 5, "Oro", 15, "Montaña Rusa",
                2.0, 1.0, 90.0, 30.0, "Alto"
        );
        admin.añadirAtraccion(atracciones, m);

        assertEquals(1, atracciones.size());
        assertTrue(atracciones.get(0) instanceof Mecanica);
        assertEquals("Montaña Rusa", atracciones.get(0).getdescripcion());
    }

    @Test
    void testAñadirCultural() {
        Cultural c = new Cultural(
                202, 50, 3, "Familiar", 10, "Show de Magia",
                true, 5, false
        );
        admin.añadirAtraccion(atracciones, c);

        assertEquals(1, atracciones.size());
        assertTrue(atracciones.get(0) instanceof Cultural);
        assertEquals("Show de Magia", atracciones.get(0).getdescripcion());
    }

    @Test
    void testEditarAtraccion() {
        Cultural c = new Cultural(
                202, 50, 3, "Familiar", 10, "Show de Magia",
                true, 5, false
        );
        admin.añadirAtraccion(atracciones, c);

        // Editar la atracción
        admin.editarAtraccion(c, 202, 80, 4, "Diamante", 20, "Show Renovado");

        assertEquals(80, c.getcapacidadMax());
        assertEquals(4, c.getminimoEmpleados());
        assertEquals("Diamante", c.gettipoExclusividad());
        assertEquals(20, c.gettiempoDisponibleEnDias());
        assertEquals("Show Renovado", c.getdescripcion());
    }

    @Test
    void testEliminarAtraccion() {
        Mecanica m = new Mecanica(
                101, 30, 5, "Oro", 15, "Montaña Rusa",
                2.0, 1.0, 90.0, 30.0, "Alto"
        );
        admin.añadirAtraccion(atracciones, m);

        assertEquals(1, atracciones.size());

        admin.removerAtraccion(atracciones, m);

        assertEquals(0, atracciones.size());
    }

    @Test
    void testBuscarAtraccion() {
        Mecanica m1 = new Mecanica(1, 20, 3, "Familiar", 10, "Carrousel", 1.5, 0.9, 80.0, 20.0, "Medio");
        Cultural c1 = new Cultural(2, 50, 2, "Oro", 5, "Teatro", false, 0, false);
        atracciones.add(m1);
        atracciones.add(c1);

        Atraccion encontrada = Main.buscarAtraccion(atracciones, 2);

        assertNotNull(encontrada);
        assertEquals(2, encontrada.getlugar());
        assertTrue(encontrada instanceof Cultural);
    }
}

