package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.io.*;

import scr.main.MainCliente;

public class MainClienteTest {

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
    void testMainClienteConCredencialesValidasYSalida() throws Exception {
        // Simular entrada: usuario, correo, contraseña, opción 0 para salir
        String simulatedInput = String.join("\n",
                "maria",           // nombre
                "maria@mail.com",  // correo
                "abc123",          // contraseña
                "0"                // salir del menú
        );
        ByteArrayInputStream testIn = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(testIn);

        // Crear el archivo clientesP.txt con la entrada correcta
        try (PrintWriter writer = new PrintWriter("clientesP.txt")) {
            writer.println("maria;maria@mail.com;abc123");
        }

        // Ejecutar main
        MainCliente.main(new String[]{});

        // Verificar salida
        String salida = outputStream.toString();

        assertTrue(salida.contains("¡Autenticación exitosa! Bienvenido, maria"));
        assertTrue(salida.contains("Menú de Cliente"));
        assertTrue(salida.contains("Cerrando sesión"));
    }
}
