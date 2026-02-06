public class Entity {
    private String name;
    private int level;
    private int heartPoints;
    private int mana;

    private EntityType entityTypeRarity;

    private int attackPoints;
    private int magicAttackPoints;

    public Entity(
            String name, int level, int heartPoints, int mana, int attackPoints,
            int magicAttackPoints, EntityType entityTypeRarity
    ) {
        this.name = name;
        this.level = level;
        this.heartPoints = heartPoints;
        this.mana = mana;

        this.entityTypeRarity = entityTypeRarity;

        this.attackPoints = attackPoints;
        this.magicAttackPoints = magicAttackPoints;
    }

    public Entity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHeartPoints() {
        return heartPoints;
    }

    public void setHeartPoints(int heartPoints) {
        this.heartPoints = heartPoints;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public int getMagicAttackPoints() {
        return magicAttackPoints;
    }

    public void setMagicAttackPoints(int magicAttackPoints) {
        this.magicAttackPoints = magicAttackPoints;
    }

    public EntityType getEntityTypeRarity() {
        return entityTypeRarity;
    }

    public void setEntityTypeRarity(EntityType rarity) {
        this.entityTypeRarity = rarity;
    }

    public int getTotalAttackHits() {
        double multiplier = switch (entityTypeRarity) {
            case COMMON -> 1.0;
            case RARE -> 1.3;
            case EPIC -> 1.6;
            case LEGENDARY -> 2.0;
        };

        return (int) ((attackPoints + magicAttackPoints) * multiplier);
    }

    public void attack(Entity character) {
        this.mana -= 20;
        character.heartPoints -= getTotalAttackHits();
    }
}
