package models.enums.types;
import models.enums.environment.Season;
import java.util.List;

public enum GoodsType {
    COPPER_ORE("Copper Ore", "A common ore that can be smelted into bars.", 75, -1, ShopType.BLACKSMITH, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    IRON_ORE("Iron Ore", "A fairly common ore that can be smelted into bars.", 150, -1, ShopType.BLACKSMITH, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    COAL("Coal", "A combustible rock that is useful for crafting and smelting.", 150, -1, ShopType.BLACKSMITH, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    GOLD_ORE("Gold Ore", "A precious ore that can be smelted into bars.", 400, -1, ShopType.BLACKSMITH, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    HAY("Hay", "Dried grass used as animal food.", 50, -1, ShopType.MARNIE_RANCH, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    MILK_PAIL("Milk Pail", "Gather milk from your animals.", 1000, 1, ShopType.MARNIE_RANCH, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    SHEARS("Shears", "Use this to collect wool from sheep", 1000, 1, ShopType.MARNIE_RANCH, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    BEER("Beer", "Drink in moderation.", 400, -1, ShopType.THE_STARDROP_SALLON, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    SALAD("Salad", "A healthy garden salad.", 220, -1, ShopType.THE_STARDROP_SALLON, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    BREAD("Bread", "A crusty baguette.", 120, -1, ShopType.THE_STARDROP_SALLON, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    SPAGHETTI("Spaghetti", "An old favorite.", 240, -1, ShopType.THE_STARDROP_SALLON, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    PIZZA("Pizza", "It's popular for all the right reasons.", 600, -1, ShopType.THE_STARDROP_SALLON, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    COFFEE("Coffee", "It smells delicious. This is sure to give you a boost.", 300, -1, ShopType.THE_STARDROP_SALLON, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    HASHBROWNS_RECIPE("Hashbrowns Recipe", "A recipe to make Hashbrowns", 50, 1, ShopType.THE_STARDROP_SALLON, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    OMELET_RECIPE("Omelet Recipe", "A recipe to make Omelet", 100, 1, ShopType.THE_STARDROP_SALLON, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    PANCAKES_RECIPE("Pancakes Recipe", "A recipe to make Pancakes", 100, 1, ShopType.THE_STARDROP_SALLON, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    BREAD_RECIPE("Bread Recipe", "A recipe to make Bread", 100, 1, ShopType.THE_STARDROP_SALLON, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    TORTILLA_RECIPE("Tortilla Recipe", "A recipe to make Tortilla", 100, 1, ShopType.THE_STARDROP_SALLON, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    PIZZA_RECIPE("Pizza Recipe", "A recipe to make Pizza", 150, 1, ShopType.THE_STARDROP_SALLON, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    MAKI_ROLL_RECIPE("Maki Roll Recipe", "A recipe to make Maki Roll", 300, 1, ShopType.THE_STARDROP_SALLON, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    TRIPLE_SHOT_ESPRESSO_RECIPE("Triple Shot Espresso Recipe", "A recipe to make Triple Shot Espresso", 5000, 1, ShopType.THE_STARDROP_SALLON, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    COOKIE_RECIPE("Cookie Recipe", "A recipe to make Cookie", 300, 1, ShopType.THE_STARDROP_SALLON, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    WOOD("Wood", "A sturdy, yet flexible plant material with a wide variety of uses.", 10, -1, ShopType.CARPENTER_SHOP, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    STONE("Stone", "A common material with many uses in crafting and building.", 20, -1, ShopType.CARPENTER_SHOP, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    JOJA_COLA("Joja Cola", "The flagship product of Joja corporation.", 75, -1, ShopType.JOJAMART, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    ANCIENT_SEED("Ancient Seed", "Could these still grow?", 500, 1, ShopType.JOJAMART, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    GRASS_STARTER("Grass Starter", "Place this on your farm to start a new patch of grass.", 125, -1, ShopType.JOJAMART, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    SUGAR("Sugar", "Adds sweetness to pastries and candies. Too much can be unhealthy.", 125, -1, ShopType.JOJAMART, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    WHEAT_FLOUR("Wheat Flour", "A common cooking ingredient made from crushed wheat seeds.", 125, -1, ShopType.JOJAMART, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    RICE_JOJA("Rice", "A basic grain often served under vegetables.", 250, -1, ShopType.JOJAMART, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    PARSNIP_SEEDS("Parsnip Seeds", "Plant these in the spring. Takes 4 days to mature.", 25, 5, ShopType.JOJAMART, List.of(Season.SPRING)),
    BEAN_STARTER("Bean Starter", "Plant these in the spring. Takes 10 days to mature, but keeps producing after that. Grows on a trellis.", 75, 5, ShopType.JOJAMART, List.of(Season.SPRING)),
    CAULIFLOWER_SEEDS("Cauliflower Seeds", "Plant these in the spring. Takes 12 days to produce a large cauliflower.", 100, 5, ShopType.JOJAMART, List.of(Season.SPRING)),
    POTATO_SEEDS("Potato Seeds", "Plant these in the spring. Takes 6 days to mature, and has a chance of yielding multiple potatoes.", 62, 5, ShopType.JOJAMART, List.of(Season.SPRING)),
    STRAWBERRY_SEEDS("Strawberry Seeds", "Plant these in spring. Takes 8 days to mature, and keeps producing strawberries.", 100, 5, ShopType.JOJAMART, List.of(Season.SPRING)),
    TULIP_BULB("Tulip Bulb", "Plant in spring. Takes 6 days to produce a colorful flower. Assorted colors.", 25, 5, ShopType.JOJAMART, List.of(Season.SPRING)),
    KALE_SEEDS("Kale Seeds", "Plant these in the spring. Takes 6 days to mature. Harvest with the scythe.", 87, 5, ShopType.JOJAMART, List.of(Season.SPRING)),
    COFFEE_BEANS("Coffee Beans", "Plant in summer or spring. Takes 10 days to grow, then produces coffee beans every other day.", 200, 1, ShopType.JOJAMART, List.of(Season.SPRING)),
    CARROT_SEEDS("Carrot Seeds", "Plant in the spring. Takes 3 days to grow.", 5, 10, ShopType.JOJAMART, List.of(Season.SPRING)),
    RHUBARB_SEEDS("Rhubarb Seeds", "Plant these in the spring. Takes 13 days to mature.", 100, 5, ShopType.JOJAMART, List.of(Season.SPRING)),
    JAZZ_SEEDS("Jazz Seeds", "Plant in spring. Takes 7 days to produce a blue puffball flower.", 37, 5, ShopType.JOJAMART, List.of(Season.SPRING)),
    TOMATO_SEEDS("Tomato Seeds", "Plant these in the summer. Takes 11 days to mature, and continues to produce after first harvest.", 62, 5, ShopType.JOJAMART, List.of(Season.SUMMER)),
    PEPPER_SEEDS("Pepper Seeds", "Plant these in the summer. Takes 5 days to mature, and continues to produce after first harvest.", 50, 5, ShopType.JOJAMART, List.of(Season.SUMMER)),
    WHEAT_SEEDS("Wheat Seeds", "Plant these in the summer or fall. Takes 4 days to mature. Harvest with the scythe.", 12, 10, ShopType.JOJAMART, List.of(Season.SUMMER)),
    SUMMER_SQUASH_SEEDS("Summer Squash Seeds", "Plant in the summer. Takes 6 days to grow, and continues to produce after first harvest.", 10, 10, ShopType.JOJAMART, List.of(Season.SUMMER)),
    RADISH_SEEDS("Radish Seeds", "Plant these in the summer. Takes 6 days to mature.", 50, 5, ShopType.JOJAMART, List.of(Season.SUMMER)),
    MELON_SEEDS("Melon Seeds", "Plant these in the summer. Takes 12 days to mature.", 100, 5, ShopType.JOJAMART, List.of(Season.SUMMER)),
    HOPS_STARTER("Hops Starter", "Plant these in the summer. Takes 11 days to grow, but keeps producing after that. Grows on a trellis.", 75, 5, ShopType.JOJAMART, List.of(Season.SUMMER)),
    POPPY_SEEDS("Poppy Seeds", "Plant in summer. Produces a bright red flower in 7 days.", 125, 5, ShopType.JOJAMART, List.of(Season.SUMMER)),
    SPANGLE_SEEDS("Spangle Seeds", "Plant in summer. Takes 8 days to produce a vibrant tropical flower. Assorted colors.", 62, 5, ShopType.JOJAMART, List.of(Season.SUMMER)),
    STARFRUIT_SEEDS("Starfruit Seeds", "Plant these in the summer. Takes 13 days to mature.", 400, 5, ShopType.JOJAMART, List.of(Season.SUMMER)),
    SUNFLOWER_SEEDS("Sunflower Seeds", "Plant in summer or fall. Takes 8 days to produce a large sunflower. Yields more seeds at harvest.", 125, 5, ShopType.JOJAMART, List.of(Season.SUMMER)),
    CORN_SEEDS("Corn Seeds", "Plant these in the summer or fall. Takes 14 days to mature, and continues to produce after first harvest.", 187, 5, ShopType.JOJAMART, List.of(Season.FALL)),
    EGGPLANT_SEEDS("Eggplant Seeds", "Plant these in the fall. Takes 5 days to mature, and continues to produce after first harvest.", 25, 5, ShopType.JOJAMART, List.of(Season.FALL)),
    PUMPKIN_SEEDS("Pumpkin Seeds", "Plant these in the fall. Takes 13 days to mature.", 125, 5, ShopType.JOJAMART,List.of(Season.FALL)),
    BROCCOLI_SEEDS("Broccoli Seeds", "Plant in the fall. Takes 8 days to mature, and continues to produce after first harvest.", 15, 5, ShopType.JOJAMART, List.of(Season.FALL)),
    AMARANTH_SEEDS("Amaranth Seeds", "Plant these in the fall. Takes 7 days to grow. Harvest with the scythe.", 87, 5, ShopType.JOJAMART, List.of(Season.FALL)),
    GRAPE_STARTER("Grape Starter", "Plant these in the fall. Takes 10 days to grow, but keeps producing after that. Grows on a trellis.", 75, 5, ShopType.JOJAMART, List.of(Season.FALL)),
    BEET_SEEDS("Beet Seeds", "Plant these in the fall. Takes 6 days to mature.", 20, 5, ShopType.JOJAMART, List.of(Season.FALL)),
    YAM_SEEDS("Yam Seeds", "Plant these in the fall. Takes 10 days to mature.", 75, 5, ShopType.JOJAMART, List.of(Season.FALL)),
    BOK_CHOY_SEEDS("Bok Choy Seeds", "Plant these in the fall. Takes 4 days to mature.", 62, 5, ShopType.JOJAMART, List.of(Season.FALL)),
    CRANBERRY_SEEDS("Cranberry Seeds", "Plant these in the fall. Takes 7 days to mature, and continues to produce after first harvest.", 300, 5, ShopType.JOJAMART, List.of(Season.FALL)),
    FAIRY_SEEDS("Fairy Seeds", "Plant in fall. Takes 12 days to produce a mysterious flower. Assorted colors.", 250, 5, ShopType.JOJAMART, List.of(Season.FALL)),
    RARE_SEED("Rare Seed", "Sow in fall. Takes all season to grow.", 1000, 1, ShopType.JOJAMART, List.of(Season.FALL)),
    WHAT_SEEDS("Wheat Seeds", "Plant these in the summer or fall. Takes 4 days to mature. Harvest with the scythe.", 12, 5, ShopType.JOJAMART, List.of(Season.FALL)),
    POWDERMELON_SEEDS("Powdermelon Seeds", "This special melon grows in the winter. Takes 7 days to grow.", 20, 10, ShopType.JOJAMART, List.of(Season.WINTER)),
    RICE("Rice", "A basic grain often served under vegetables.", 200, -1, ShopType.PIERRE_GENERAL_STORE, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    WHEAT_FLOUR_PIERRE("Wheat Flour", "A common cooking ingredient made from crushed wheat seeds.", 100, -1, ShopType.PIERRE_GENERAL_STORE, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    BOUQUET("Bouquet", "A gift that shows your romantic interest. (Unlocked after reaching level 2 friendship with a player)", 1000, 2, ShopType.PIERRE_GENERAL_STORE, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    WEDDING_RING("Wedding Ring", "Used to ask for another farmer's hand in marriage. (Unlocked after reaching level 3 friendship with a player)", 10000, 2, ShopType.PIERRE_GENERAL_STORE, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    DEHYDRATOR_RECIPE("Dehydrator (Recipe)", "A recipe to make Dehydrator.", 10000, 1, ShopType.PIERRE_GENERAL_STORE, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    GRASS_STARTER_RECIPE("Grass Starter (Recipe)", "A recipe to make Grass Starter.", 1000, 1, ShopType.PIERRE_GENERAL_STORE, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    SUGAR_PIERRE("Sugar", "Adds sweetness to pastries and candies. Too much can be unhealthy.", 100, -1, ShopType.PIERRE_GENERAL_STORE, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    OIL("Oil", "All-purpose cooking oil.", 200, -1, ShopType.PIERRE_GENERAL_STORE, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    VINEGAR("Vinegar", "An aged fermented liquid used in many cooking recipes.", 200, -1, ShopType.PIERRE_GENERAL_STORE, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    BASIC_FERTILIZER("Basic Fertilizer", "Improves soil quality a little, increasing your chance to grow quality crops. Mix into tilled soil.", 100, -1, ShopType.PIERRE_GENERAL_STORE, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    QUALITY_FERTILIZER("Quality Fertilizer", "Improves soil quality, increasing your chance to grow quality crops. Mix into tilled soil.", 150, -1, ShopType.PIERRE_GENERAL_STORE, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    GRASS_STARTER_PIERRE("Grass Starter", "Place this on your farm to start a new patch of grass.", 100, -1, ShopType.PIERRE_GENERAL_STORE, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    SPEED_GRO("Speed-Gro", "Stimulates leaf production. Guaranteed to increase growth rate by at least 10%. Mix into tilled soil.", 100, -1, ShopType.PIERRE_GENERAL_STORE, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    DELUXE_SPEED_GRO("Deluxe Speed-Gro", "Stimulates leaf production. Guaranteed to increase growth rate by at least 25%. Mix into tilled soil.", 150, -1, ShopType.PIERRE_GENERAL_STORE, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    APPLE_SAPLING("Apple Sapling", "Takes 28 days to produce a mature Apple tree. Bears fruit in the fall. Only grows if the 8 surrounding tiles are empty.", 4000, -1, ShopType.PIERRE_GENERAL_STORE, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    APRICOT_SAPLING("Apricot Sapling", "Takes 28 days to produce a mature Apricot tree. Bears fruit in the spring. Only grows if the 8 surrounding tiles are empty.", 2000, -1, ShopType.PIERRE_GENERAL_STORE, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    CHERRY_SAPLING("Cherry Sapling", "Takes 28 days to produce a mature Cherry tree. Bears fruit in the spring. Only grows if the 8 surrounding tiles are empty.", 3400, -1, ShopType.PIERRE_GENERAL_STORE, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    ORANGE_SAPLING("Orange Sapling", "Takes 28 days to produce a mature Orange tree. Bears fruit in the summer. Only grows if the 8 surrounding tiles are empty.", 4000, -1, ShopType.PIERRE_GENERAL_STORE, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    PEACH_SAPLING("Peach Sapling", "Takes 28 days to produce a mature Peach tree. Bears fruit in the summer. Only grows if the 8 surrounding tiles are empty.", 6000, -1, ShopType.PIERRE_GENERAL_STORE, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    POMEGRANATE_SAPLING("Pomegranate Sapling", "Takes 28 days to produce a mature Pomegranate tree. Bears fruit in the fall. Only grows if the 8 surrounding tiles are empty.", 6000, -1, ShopType.PIERRE_GENERAL_STORE, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    BASIC_RETAINING_SOIL("Basic Retaining Soil", "This soil has a chance of staying watered overnight. Mix into tilled soil.", 100, -1, ShopType.PIERRE_GENERAL_STORE, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER)),
    QUALITY_RETAINING_SOIL("Quality Retaining Soil", "This soil has a good chance of staying watered overnight. Mix into tilled soil.", 150, -1, ShopType.PIERRE_GENERAL_STORE, List.of(Season.SPRING, Season.SUMMER, Season.FALL, Season.WINTER));

    private final String name;
    private final String description;
    private final int price;
    private final int dailyLimit;  // -1 for unlimited
    private final ShopType shopType;
    private final List<Season> seasonalStock;

    GoodsType(String name,
              String description,
              int price,
              int dailyLimit,
              ShopType shopType ,
              List<Season> seasonalStocks ) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.dailyLimit = dailyLimit;
        this.shopType = shopType;
        this.seasonalStock = seasonalStocks;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public int getDailyLimit() {
        return dailyLimit;
    }

    public ShopType getShopType() {
        return shopType;
    }

    public List<Season> getSeasonalStock() {
        return seasonalStock;
    }
}

