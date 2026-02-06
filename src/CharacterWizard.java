public class CharacterWizard extends Entity {
    public CharacterWizard() {
        super.setName("Gandalf");
        super.setLevel(3);
        super.setHeartPoints(220);
        super.setMana(100);

        super.setAttackPoints(10);
        super.setMagicAttackPoints(35);
    }

    @Override
    public void attack(Entity character) {
        int hitPoints = this.getAttackPoints() + this.getMagicAttackPoints();
        this.setMana(this.getMana() - 20);

        character.setHeartPoints(character.getHeartPoints() - hitPoints);
    }
}
