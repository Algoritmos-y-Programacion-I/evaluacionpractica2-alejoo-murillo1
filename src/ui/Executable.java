package ui;

import java.util.Scanner;
import model.Controller;

public class Executable {

    private Controller control;
    private Scanner reader;

    public Executable() {

        control = new Controller();
        reader = new Scanner(System.in);
        control.precargarPilares();

    }

    public static void main(String[] args) {

        Executable exe = new Executable();
        exe.menu();
        
    }
    
    /** 
     * Descripcion: Despliega el menu principal de funcionalidades al usuario
    */
    public void menu() {

        boolean flag = true;

        do {

            System.out.println("\nBienvenido a Icesi Sostenible!");
            System.out.println("\nMENU PRINCIPAL");
            System.out.println("----------------------");
            System.out.println("1) Registrar un Proyecto en un Pillar");
            System.out.println("2) Consultar Proyectos por Pilar");
            System.out.println("0) Salir");
            int option = reader.nextInt();

            switch (option) {
                case 1:
                    registerProject();
                    break;
                case 2:
                    showProjectsByPillar();
                    break;
                case 0:
                    System.out.println("Gracias por usar nuestros servicios. Adios!");
                    flag = false;
                    break;

                default:
                    System.out.println("Opcion invalida, intente nuevamente");
                    break;
            }

        } while (flag);

    }

    /** 
     * Descripcion: Solicita al usuario la informacion necesaria para registrar un Project 
     * en un Pillar en el sistema
    */
    public void registerProject() {

        reader.nextLine();
        // String id, String name, String description,boolean status

        System.out.println("\n Pilar al que desea asociar el proyecto. (1. Biodiversidad, 2. Agua, 3. Tratamiento Basuras, 4. Tratamiento Energia)");
        int typePillar = reader.nextInt();

        reader.nextLine();

        if(typePillar == 1 || typePillar == 2 || typePillar == 3 || typePillar == 4){

            System.out.println("\n Digite el id del proyecto.");
            String id = reader.nextLine();

            System.out.println("\n Escriba el nombre del proyecto.");
            String name = reader.nextLine();

            System.out.println("\n Escriba una corta descripción del proyecto.");
            String description = reader.nextLine();

            System.out.println("\n El proyecto está activo? (Si - true / No - false)");
            boolean status = reader.nextBoolean();

            if(control.registerProjectInPillar(typePillar, id, name, description, status)){
                System.out.println("\nProyecto guardado exitosamente.");
            }
        } else{
            registerProject();
        }
            
    }

    /** 
     * Descripcion: Muestra al usuario los Projects registrados en un Pillar 
    */
    public void showProjectsByPillar() {
        System.out.println("\n Pilar del que desea consultar los proyectos: ");
        int pilar = reader.nextInt();

        System.out.println(control.queryProjectsByPillar(pilar));
    }

}