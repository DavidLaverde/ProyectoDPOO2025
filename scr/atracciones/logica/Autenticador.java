package scr.atracciones.logica;

import scr.personas.Administrador;
import scr.personas.Cliente;
import scr.personas.Empleado;
import scr.personas.Usuario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class Autenticador {

    private static final String ARCHIVO_EMPLEADOS = "empleadosP.txt";

    public static Usuario autenticar(String usuario, String contrasena, String tipo) {
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_EMPLEADOS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length >= 4) {
                    String nombre = partes[0];
                    String user = partes[1];
                    String pass = partes[2];
                    String rol = partes[3];

                    if (usuario.equals(user) && contrasena.equals(pass) && rol.equalsIgnoreCase(tipo)) {
                        switch (rol.toLowerCase()) {
                            case "administrador": return new Administrador(nombre, user, pass);
                            case "empleado": return new Empleado(nombre, user, pass);
                            case "cliente": return new Cliente(nombre, user, pass);
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error al autenticar: " + e.getMessage());
        }
        return null;
    }
}
