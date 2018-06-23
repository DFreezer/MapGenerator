package sample;

public enum Tile {

    GRASS(0),
    DIRT(1),
    OCEAN(2),
    SAND(3),
    GRASS_DIRT_T(11),
    GRASS_DIRT_R(12),
    GRASS_DIRT_B(13),
    GRASS_DIRT_L(14),
    GRASS_DIRT_TR(15),
    GRASS_DIRT_TL(16),
    GRASS_DIRT_BR(17),
    GRASS_DIRT_BL(18),
    DIRT_GRASS_TR(19),
    DIRT_GRASS_TL(20),
    DIRT_GRASS_BR(21),
    DIRT_GRASS_BL(22),
    SAND_GRASS_T(23),
    SAND_GRASS_R(24),
    SAND_GRASS_B(25),
    SAND_GRASS_L(26),
    SAND_GRASS_TR(27),
    SAND_GRASS_TL(28),
    SAND_GRASS_BR(29),
    SAND_GRASS_BL(30),
    GRASS_SAND_TR(31),
    GRASS_SAND_TL(32),
    GRASS_SAND_BR(33),
    GRASS_SAND_BL(34);

    private int value;

    Tile(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
