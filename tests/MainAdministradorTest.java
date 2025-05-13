package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.*;

import scr.main.MainAdministrador;

public class MainAdministradorTest {

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
    void testMainConCredencialesValidasYSalida() throws Exception {
        // Simular entrada del usuario (usuario, correo, contraseña, id, opción 0 para salir)
        String simulatedInput = String.join("\n",
                "juan",            // usuario
                "juan@mail.com",   // correo
                "1234",            // contraseña
                "1",               // id
                "0"                // salir del menú
        );
        ByteArrayInputStream testIn = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(testIn);

        // Prepara archivo adminsP.txt con ese usuario
        try (PrintWriter writer = new PrintWriter("adminsP.txt")) {
            writer.println("juan;juan@mail.com;1234;1");
        }

        // Ejecutar main
        MainAdministrador.main(new String[]{});

        String salida = outputStream.toString();

        // Verificar que reconoce al admin y muestra menú
        assertTrue(salida.contains("¡Autenticación exitosa! Bienvenido, juan"));
        assertTrue(salida.contains("Menú de Administrador"));
        assertTrue(salida.contains("Cerrando sesión"));
    }
}
