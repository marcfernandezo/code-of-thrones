import java.util.List;

public class Characters {

    public static void init(List<Entity> charactersList) {
        charactersList.add(new CharacterWizard());
        charactersList.add(new CharacterWarrior());
        charactersList.add(new CharacterArcher());
    }
}