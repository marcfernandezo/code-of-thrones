import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    public static void main() throws InterruptedException {
        Random random = new Random();

        System.out.println("🔹 Inicializando personajes...");

        List<Entity> characters = new ArrayList<>();
        Characters.init(characters);

        // Mostrar stats iniciales
        for (Entity character : characters) {
            System.out.println(character.getName() + " | Nivel: " + character.getLevel() +
                    " | Vida: " + character.getHeartPoints() +
                    " | Mana: " + character.getMana() +
                    " | Rareza: " + character.getEntityTypeRarity());
            Thread.sleep(500); // Pausa para efecto visual
        }

        System.out.println("\n🔹 Comienza el combate...");
        Thread.sleep(500);

        int index1 = random.nextInt(characters.size());
        Entity player1 = characters.get(index1);

        int index2;
        do {
            index2 = random.nextInt(characters.size());
        } while (index2 == index1);

        Entity player2 = characters.get(index2);

        int turn = 1;

        while (player1.getHeartPoints() > 0 && player2.getHeartPoints() > 0) {

            System.out.println("\n=== Turno " + turn + " ===");
            Thread.sleep(500);

            // Turno de player1
            System.out.println(player1.getName() + " ataca a " + player2.getName() + "!");
            Thread.sleep(400);
            System.out.println(player1.getName() + " mana antes del ataque: " + player1.getMana());
            Thread.sleep(400);

            player1.attack(player2);

            System.out.println(player1.getName() + " mana ahora: " + player1.getMana());
            Thread.sleep(400);
            System.out.println(player2.getName() + " puntos de vida ahora: " + player2.getHeartPoints());
            Thread.sleep(400);

            if (player2.getHeartPoints() <= 0) {
                System.out.println(player2.getName() + " ha sido derrotado! 💀");
                break;
            }

            // Turno de player2
            System.out.println(player2.getName() + " ataca a " + player1.getName() + "!");
            Thread.sleep(400);
            System.out.println(player2.getName() + " mana antes del ataque: " + player2.getMana());
            Thread.sleep(400);

            player2.attack(player1);

            System.out.println(player2.getName() + " mana ahora: " + player2.getMana());
            Thread.sleep(400);
            System.out.println(player1.getName() + " puntos de vida ahora: " + player1.getHeartPoints());
            Thread.sleep(400);

            if (player1.getHeartPoints() <= 0) {
                System.out.println(player1.getName() + " ha sido derrotado! 💀");
                break;
            }

            turn++;
        }

        System.out.println("\n🔹 Combate terminado!");
    }
}
