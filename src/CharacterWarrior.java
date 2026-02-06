public class CharacterWarrior extends Entity {
    public CharacterWarrior() {
        super.setName("Zed");
        super.setLevel(5);
        super.setHeartPoints(350);
        super.setMana(150);

        super.setEntityTypeRarity(Entity.randomEntityTypeRarity());

        super.setAttackPoints(38);
        super.setMagicAttackPoints(5);
    }

    @Override
    public void attack(Entity character) {
        int hitPoints = this.getAttackPoints() + this.getMagicAttackPoints();
        this.setMana(this.getMana() - 20);

        character.setHeartPoints(character.getHeartPoints() - hitPoints);
    }
}