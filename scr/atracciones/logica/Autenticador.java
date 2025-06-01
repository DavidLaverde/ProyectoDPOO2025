package scr.atracciones.logica;

import scr.personas.Administrador;
import scr.personas.Cliente;
import scr.personas.Usuario;

import java.io.*;
import java.util.HashMap;

public class Autenticador {

    private static final String ARCHIVO_EMPLEADOS = "empleadosP.txt";
    private static final String ARCHIVO_ADMINS = "adminsP.txt";
    private static final String ARCHIVO_CLIENTES = "clientesp.txt"; // Asegúrate de que tenga extensión

    private static final HashMap<String, Usuario> clientesRegistrados = new HashMap<>();

    // ===============================
    // === MÉTODOS DE AUTENTICACIÓN ==
    // ===============================

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
            System.out.println("❌ Error al autenticar cliente: " + e.getMessage());
        }
        return null;
    }

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

    // ============================
    // === MÉTODOS PARA REGISTRO ==
    // ============================

    public static boolean registrarCliente(String nombre, String correo, String password) {
        // Verificar si ya existe por correo
        if (clienteYaExiste(correo)) {
            return false;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_CLIENTES, true))) {
            String linea = nombre + ";" + correo + ";" + password;
            bw.write(linea);
            bw.newLine();
            return true;
        } catch (IOException e) {
            System.out.println("❌ Error al registrar cliente: " + e.getMessage());
            return false;
        }
    }

    private static boolean clienteYaExiste(String correo) {
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_CLIENTES))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length >= 2 && partes[1].equalsIgnoreCase(correo)) {
                    return true;
                }
            }
        } catch (IOException e) {
            // Si no existe el archivo, se asume que no hay clientes
            return false;
        }
        return false;
    }
}
