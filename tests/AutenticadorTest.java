package tests;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

import scr.atracciones.logica.Autenticador;
import scr.personas.Usuario;
import scr.personas.Administrador;

public class AutenticadorTest {

    @BeforeEach
    void prepararArchivos() throws IOException {
        // Empleado
        try (PrintWriter writer = new PrintWriter("empleadosP.txt")) {
            writer.println("ana;ana@mail.com;pass123");
        }

        // Cliente
        try (PrintWriter writer = new PrintWriter("clientesp")) {
            writer.println("maria;maria@mail.com;abc123");
        }

        // Administrador
        try (PrintWriter writer = new PrintWriter("adminsP.txt")) {
            writer.println("juan;juan@mail.com;adminpass;1");
        }
    }

    @Test
    void autenticarEmpleadoValido() {
        Usuario emp = Autenticador.autenticarE("ana", "ana@mail.com", "pass123");
        assertNotNull(emp);
        assertEquals("ana", emp.getNombre());
        assertEquals("ana@mail.com", emp.getCorreo());
    }

    @Test
    void autenticarClienteValido() {
        Usuario cli = Autenticador.autenticarC("maria", "maria@mail.com", "abc123");
        assertNotNull(cli);
        assertEquals("maria", cli.getNombre());
        assertEquals("maria@mail.com", cli.getCorreo());
    }

    @Test
    void autenticarAdminValido() {
        Administrador admin = Autenticador.autenticarA("juan", "juan@mail.com", "adminpass", "1");
        assertNotNull(admin);
        assertEquals("juan", admin.getNombre());
        assertEquals("juan@mail.com", admin.getCorreo());
        assertEquals("adminpass", admin.getContraseña());
        assertEquals(1, admin.getIdAdmin());
    }

    @Test
    void autenticarEmpleadoInvalido() {
        Usuario emp = Autenticador.autenticarE("noexiste", "fail@mail.com", "123");
        assertNull(emp);
    }

    @Test
    void autenticarClienteInvalido() {
        Usuario cli = Autenticador.autenticarC("x", "y@mail.com", "z");
        assertNull(cli);
    }

    @Test
    void autenticarAdminInvalido() {
        Administrador admin = Autenticador.autenticarA("nadie", "404@mail.com", "nopass", "0");
        assertNull(admin);
    }
}
