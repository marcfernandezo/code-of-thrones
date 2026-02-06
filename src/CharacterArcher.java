public class CharacterArcher extends Entity {
    public CharacterArcher() {
        super.setName("Gem");
        super.setLevel(4);
        super.setHeartPoints(250);
        super.setMana(80);

        super.setEntityTypeRarity(Entity.randomEntityTypeRarity());

        super.setAttackPoints(30);
        super.setMagicAttackPoints(9);
    }

    @Override
    public void attack(Entity character) {
        int hitPoints = this.getAttackPoints() + this.getMagicAttackPoints();
        this.setMana(this.getMana() - 20);

        character.setHeartPoints(character.getHeartPoints() - hitPoints);
    }
}