/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bimestre2tarea1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author USUARIOPC
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Persona {
    private String nombre;
    private String apellido;
    private String username;

    public Persona(String nombre, String apellido, String username) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Apellido: " + apellido + ", Username: " + username;
    }
}

class InstitucionEducativa {
    private String nombre;
    private String siglas;

    public InstitucionEducativa(String nombre, String siglas) {
        this.nombre = nombre;
        this.siglas = siglas;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Siglas: " + siglas;
    }
}

class Prestamo {
    protected Persona beneficiario;
    protected int tiempoPrestamoMeses;
    protected String ciudadPrestamo;

    public Prestamo(Persona beneficiario, int tiempoPrestamoMeses, String ciudadPrestamo) {
        this.beneficiario = beneficiario;
        this.tiempoPrestamoMeses = tiempoPrestamoMeses;
        this.ciudadPrestamo = ciudadPrestamo.toLowerCase();
    }

    @Override
    public String toString() {
        return "Beneficiario: " + beneficiario + ", Tiempo de préstamo (meses): " + tiempoPrestamoMeses
                + ", Ciudad del préstamo: " + ciudadPrestamo;
    }
}

class PrestamoAutomovil extends Prestamo {
    private String tipoAutomovil;
    private String marcaAutomovil;
    private Persona garante1;
    private double valorAutomovil;
    private double valorMensualPago;

    public PrestamoAutomovil(Persona beneficiario, int tiempoPrestamoMeses, String ciudadPrestamo,
                             String tipoAutomovil, String marcaAutomovil, Persona garante1, double valorAutomovil) {
        super(beneficiario, tiempoPrestamoMeses, ciudadPrestamo);
        this.tipoAutomovil = tipoAutomovil;
        this.marcaAutomovil = marcaAutomovil;
        this.garante1 = garante1;
        this.valorAutomovil = valorAutomovil;
        this.valorMensualPago = valorAutomovil / tiempoPrestamoMeses;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo de automóvil: " + tipoAutomovil + ", Marca de automóvil: " + marcaAutomovil
                + ", Garante 1: " + garante1 + ", Valor de automóvil: " + valorAutomovil
                + ", Valor mensual de pago: " + valorMensualPago;
    }
}

class PrestamoEducativo extends Prestamo {
    private String nivelEstudio;
    private InstitucionEducativa centroEducativo;
    private double valorCarrera;
    private double valorMensualPago;

    public PrestamoEducativo(Persona beneficiario, int tiempoPrestamoMeses, String ciudadPrestamo,
                             String nivelEstudio, InstitucionEducativa centroEducativo, double valorCarrera) {
        super(beneficiario, tiempoPrestamoMeses, ciudadPrestamo);
        this.nivelEstudio = nivelEstudio;
        this.centroEducativo = centroEducativo;
        this.valorCarrera = valorCarrera;
        this.valorMensualPago = (valorCarrera / tiempoPrestamoMeses) - (0.1 * (valorCarrera / tiempoPrestamoMeses));
    }

    @Override
    public String toString() {
        return super.toString() + ", Nivel de estudio: " + nivelEstudio + ", Centro educativo: " + centroEducativo
                + ", Valor de la carrera: " + valorCarrera + ", Valor mensual de pago: " + valorMensualPago;
    }
}

public class Ejecutor {
    public static void main(String[] args) {
        List<Prestamo> prestamos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("Ingrese el tipo de préstamo que desea crear:");
            System.out.println("1. Préstamo de Automóvil");
            System.out.println("2. Préstamo Educativo");
            System.out.println("3. Salir");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    PrestamoAutomovil prestamoAutomovil = crearPrestamoAutomovil(scanner);
                    prestamos.add(prestamoAutomovil);
                    break;
                case 2:
                    PrestamoEducativo prestamoEducativo = crearPrestamoEducativo(scanner);
                    prestamos.add(prestamoEducativo);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 3);

        System.out.println("Lista de préstamos generados:");
        for (Prestamo prestamo : prestamos) {
            System.out.println(prestamo);
        }
    }

    public static PrestamoAutomovil crearPrestamoAutomovil(Scanner scanner) {
        System.out.println("Ingrese los datos del préstamo de automóvil:");

        System.out.print("Nombre del beneficiario: ");
        String nombre = scanner.next();

        System.out.print("Apellido del beneficiario: ");
        String apellido = scanner.next();

        System.out.print("Username del beneficiario: ");
        String username = scanner.next();

        Persona beneficiario = new Persona(nombre, apellido, username);

        System.out.print("Tiempo de préstamo en meses: ");
        int tiempoPrestamoMeses = scanner.nextInt();

        System.out.print("Ciudad del préstamo: ");
        String ciudadPrestamo = scanner.next();

        System.out.print("Tipo de automóvil: ");
        String tipoAutomovil = scanner.next();

        System.out.print("Marca de automóvil: ");
        String marcaAutomovil = scanner.next();

        System.out.print("Nombre del garante 1: ");
        String garante1Nombre = scanner.next();

        System.out.print("Apellido del garante 1: ");
        String garante1Apellido = scanner.next();

        System.out.print("Username del garante 1: ");
        String garante1Username = scanner.next();

        Persona garante1 = new Persona(garante1Nombre, garante1Apellido, garante1Username);

        System.out.print("Valor del automóvil: ");
        double valorAutomovil = scanner.nextDouble();

        return new PrestamoAutomovil(beneficiario, tiempoPrestamoMeses, ciudadPrestamo,
                tipoAutomovil, marcaAutomovil, garante1, valorAutomovil);
    }

    public static PrestamoEducativo crearPrestamoEducativo(Scanner scanner) {
        System.out.println("Ingrese los datos del préstamo educativo:");

        System.out.print("Nombre del beneficiario: ");
        String nombre = scanner.next();

        System.out.print("Apellido del beneficiario: ");
        String apellido = scanner.next();

        System.out.print("Username del beneficiario: ");
        String username = scanner.next();

        Persona beneficiario = new Persona(nombre, apellido, username);

        System.out.print("Tiempo de préstamo en meses: ");
        int tiempoPrestamoMeses = scanner.nextInt();

        System.out.print("Ciudad del préstamo: ");
        String ciudadPrestamo = scanner.next();

        System.out.print("Nivel de estudio: ");
        String nivelEstudio = scanner.next();

        System.out.print("Nombre del centro educativo: ");
        String nombreCentroEducativo = scanner.next();

        System.out.print("Siglas del centro educativo: ");
        String siglasCentroEducativo = scanner.next();

        InstitucionEducativa centroEducativo = new InstitucionEducativa(nombreCentroEducativo, siglasCentroEducativo);

        System.out.print("Valor de la carrera: ");
        double valorCarrera = scanner.nextDouble();

        return new PrestamoEducativo(beneficiario, tiempoPrestamoMeses, ciudadPrestamo,
                nivelEstudio, centroEducativo, valorCarrera);
    }
}
