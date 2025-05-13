package scr.atracciones.logica;

import scr.personas.Administrador;
import scr.personas.Usuario;

import java.io.BufferedReader;
import java.io.FileReader;

public class Autenticador {

    private static final String ARCHIVO_EMPLEADOS = "empleadosP.txt";
    private static final String ARCHIVO_ADMINS = "adminsP.txt";
    private static final String ARCHIVO_CLIENTES = "clientesp";

    // Autenticar empleado
    public static Usuario autenticarE(String usuario, String correo, String contrasena) {
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_EMPLEADOS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");

                if (partes.length >= 3) {
                    String nombre = partes[0];
                    String mail = partes[1];
                    String pass = partes[2];

                    if (usuario.equals(nombre) && correo.equals(mail) && contrasena.equals(pass)) {
                        return new Usuario(nombre, mail, pass);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("❌ Error al autenticar empleado: " + e.getMessage());
        }
        return null;
    }
    
    //Autenticar Clientes
    public static Usuario autenticarC(String usuario, String correo, String contrasena) {
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_CLIENTES))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");

                if (partes.length >= 3) {
                    String nombre = partes[0];
                    String mail = partes[1];
                    String pass = partes[2];

                    if (usuario.equals(nombre) && correo.equals(mail) && contrasena.equals(pass)) {
                        return new Usuario(nombre, mail, pass);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("❌ Error al autenticar empleado: " + e.getMessage());
        }
        return null;
    }

    // Autenticar administrador
    public static Administrador autenticarA(String usuario, String correo, String contrasena, String id) {
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_ADMINS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");

                if (partes.length >= 4) {
                    String nombre = partes[0];
                    String mail = partes[1];
                    String pass = partes[2];
                    String idA = partes[3];

                    if (usuario.equals(nombre) && correo.equals(mail) && contrasena.equals(pass) && id.equals(idA)) {
                        int idAdmin = Integer.parseInt(idA);
                        return new Administrador(nombre, mail, pass, idAdmin);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("❌ Error al autenticar administrador: " + e.getMessage());
        }
        return null;
    }
}
