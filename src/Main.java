import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        List<Entity> characters = new ArrayList<>();

        boolean exit = false;

        while (!exit) {
            System.out.println("\n===== MENU DEL JUEGO =====");
            System.out.println("1. Crear personajes");
            System.out.println("2. Mostrar personajes");
            System.out.println("3. Combate: Mago vs Guerrero");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("\n🔹 Inicializando personajes...");
                    Characters.init(characters);
                    System.out.println("Personajes creados exitosamente!");
                    break;

                case 2:
                    if (characters.isEmpty()) {
                        System.out.println("No hay personajes. Crea primero los personajes.");
                    } else {
                        System.out.println("\n🔹 Información de personajes:");
                        for (Entity character : characters) {
                            System.out.println(character.getName() +
                                    " | Nivel: " + character.getLevel() +
                                    " | Vida: " + character.getHeartPoints() +
                                    " | Mana: " + character.getMana() +
                                    " | Rareza: " + character.getEntityTypeRarity());
                        }
                    }
                    break;

                case 3:
                    if (characters.size() < 2) {
                        System.out.println("Necesitas al menos 2 personajes para pelear.");
                    } else {
                        System.out.println("\n🔹 Comienza el combate...");
                        Game.main();
                    }
                    break;

                case 4:
                    System.out.println("Saliendo del juego...");
                    exit = true;
                    break;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }

        scanner.close();
    }
}
