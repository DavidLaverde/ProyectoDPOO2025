package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.io.*;

import scr.main.MainEmpleado;

public class MainEmpleadoTest {

    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUpStreams() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    void testMainEmpleadoConCredencialesValidasYSalida() throws Exception {
        // Simula la entrada del empleado: usuario, correo, contraseña, opción 0
        String simulatedInput = String.join("\n",
                "ana",             // nombre
                "ana@mail.com",    // correo
                "pass123",         // contraseña
                "0"                // salir del menú
        );
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Crea el archivo empleadosP.txt con un empleado válido
        try (PrintWriter writer = new PrintWriter("empleadosP.txt")) {
            writer.println("ana;ana@mail.com;pass123");
        }

        // Ejecutar main
        MainEmpleado.main(new String[]{});

        // Verifica la salida
        String salida = outputStream.toString();
        assertTrue(salida.contains("¡Autenticación exitosa! Bienvenido, ana"));
        assertTrue(salida.contains("Menú de Empleado"));
        assertTrue(salida.contains("Cerrando sesión"));
    }
}
