package org.example.models.enums.types;


import org.example.models.*;
import org.example.models.enums.enviroment.Season;
import org.example.models.enums.enviroment.Weather;


import java.util.ArrayList;
import java.util.HashMap;

public enum NPCType {
    CLINT(
            new HashMap<HashMap<Item, Integer>, HashMap<Item, Integer>>() {{
                put(new HashMap<Item, Integer>() {{
                        put(ShopItemTypes.IRON_ORE, 50);
                    }},
                        new HashMap<Item, Integer>() {{
                            put((ForagingMineralType.DIAMOND), 2);
                        }}
                );
            }},
            new ArrayList<Item>() {{
                add(ProcessedItemType.IRON_BAR);
                add(ProcessedItemType.GOLD_BAR);
            }},
            new HashMap<>() {{
                put("Morning. Need something upgraded? This hammer's seen more sunrises than I have.",
                        new Situation(10, Season.SPRING, Weather.SUNNY));
                put("Whew, it's already heating up. If you're looking to cool off, I can always forge you a stronger pickaxe for those deep mines.",
                        new Situation(10, Season.SUMMER, Weather.SUNNY));
                put("Feels like a good day to fire up the forge. Cool air helps temper the metal just right.",
                        new Situation(10, Season.FALL, Weather.RAINY));
                put("Snow’s piling up out there. Good thing I’ve got the furnace to keep me warm.",
                        new Situation(10, Season.WINTER, Weather.SNOWY));

                put("Nothing like the sound of rain on the roof while I'm working. Keeps the shop feeling peaceful.",
                        new Situation(14, Season.SPRING, Weather.RAINY));
                put("Thunderstorms make me nervous... Sparks flying around metal? Yeah, no thanks.",
                        new Situation(14, Season.SUMMER, Weather.STORMY));
                put("Just got in some new ore from the mines. Bet I could craft something special with it.",
                        new Situation(14, Season.FALL, Weather.RAINY));
                put("Cold air makes the metal brittle. Gotta be extra careful when working today.",
                        new Situation(14, Season.WINTER, Weather.SUNNY));

                put("It’s getting late. But a good blacksmith never stops improving his craft.",
                        new Situation(19, Season.SPRING, Weather.SUNNY));
                put("Even at night, the forge burns hotter than the summer air. No wonder I never sleep well.",
                        new Situation(19, Season.SUMMER, Weather.SUNNY));
                put("Wind’s howling through town. Might be time to reinforce some doors before winter hits.",
                        new Situation(19, Season.FALL, Weather.STORMY));
                put("I should probably close up shop, but there's always work to do. Guess I'll just keep forging.",
                        new Situation(19, Season.WINTER, Weather.SNOWY));
            }}
    ),
    MORRIS(
            new HashMap<>(), new ArrayList<>(),
            new HashMap<>() {{
                put("A beautiful spring morning! Perfect for a fresh start—perhaps with a Joja Membership?",
                        new Situation(10, Season.SPRING, Weather.SUNNY));
                put("Rain is good for crops, but also for business. Nothing like staying dry in JojaMart while you shop!",
                        new Situation(10, Season.SUMMER, Weather.RAINY));
                put("A storm is no excuse to slack on productivity! JojaCorp thrives in all weather conditions.",
                        new Situation(10, Season.FALL, Weather.STORMY));
                put("Cold outside? JojaMart is always warm and welcoming. Our heating system is state-of-the-art, of course.",
                        new Situation(10, Season.WINTER, Weather.SNOWY));

                put("Spring is a season of growth, and here at JojaCorp, we believe in continuous progress. Why settle for small-town tradition?",
                        new Situation(14, Season.SPRING, Weather.SUNNY));
                put("Ah, the sound of rain against the windows—it reminds me of the efficiency of JojaCorp’s water filtration systems.",
                        new Situation(14, Season.SUMMER, Weather.RAINY));
                put("JojaMart remains open in all conditions. Unlike some businesses, we don’t close when the skies get rough.",
                        new Situation(14, Season.FALL, Weather.STORMY));
                put("Snow may slow down the town, but at JojaCorp, we are always moving forward.",
                        new Situation(14, Season.WINTER, Weather.SNOWY));

                put("A sunset as golden as Joja’s vision for the future of commerce.",
                        new Situation(19, Season.SPRING, Weather.SUNNY));
                put("Dark clouds over Pelican Town, but bright prospects at JojaCorp. Always expanding, always improving.",
                        new Situation(19, Season.SUMMER, Weather.RAINY));
                put("The wind howls, but our profits soar. That’s the JojaCorp way.",
                        new Situation(19, Season.FALL, Weather.STORMY));
                put("A quiet winter night—the perfect time to reflect on the benefits of a corporate-backed community.",
                        new Situation(19, Season.WINTER, Weather.SNOWY));
            }}
    ),
    PIERRE(
            new HashMap<>(), new ArrayList<>(), new HashMap<>() {{
        put("Morning! Fresh produce today—better than anything you'd find at that soulless JojaMart!",
                new Situation(10, Season.SPRING, Weather.SUNNY));
        put("Rain’s good for the crops, but not for customers. Guess I’ll have to rely on my regulars.",
                new Situation(10, Season.SUMMER, Weather.RAINY));
        put("Storm outside? That’s nothing compared to the battle I fight against corporate chains every day.",
                new Situation(10, Season.FALL, Weather.STORMY));
        put("Snow slows business, but at least my shop is stocked with the essentials. No need for Joja nonsense!",
                new Situation(10, Season.WINTER, Weather.SNOWY));

        put("Afternoon rush! If you need seeds, don’t wait—once they’re gone, they’re gone.",
                new Situation(14, Season.SPRING, Weather.SUNNY));
        put("A rainy afternoon means fewer customers... Maybe I should offer discounts to loyal shoppers.",
                new Situation(14, Season.SUMMER, Weather.RAINY));
        put("This storm is brutal. Hope the farm stays intact—without local produce, I’d be out of business!",
                new Situation(14, Season.FALL, Weather.STORMY));
        put("Cold days make people hesitate to leave home, but a warm shop full of fresh food? That’s reason enough!",
                new Situation(14, Season.WINTER, Weather.SNOWY));

        put("Long day, huh? Running a shop isn’t easy, but it’s better than selling my soul to Joja.",
                new Situation(19, Season.SPRING, Weather.SUNNY));
        put("Evening rain sets the mood for a quiet shop... but I still have seeds if you need them!",
                new Situation(19, Season.SUMMER, Weather.RAINY));
        put("Storm’s rolling in, and I’m locking up soon. Stay safe—and shop locally.",
                new Situation(19, Season.FALL, Weather.STORMY));
        put("Late nights in winter are peaceful. Makes me reflect on how much I love running this shop.",
                new Situation(19, Season.WINTER, Weather.SNOWY));
    }}
    ),
    ROBIN(
            new HashMap<>(), new ArrayList<>(), new HashMap<>() {{
        put("Morning! Got any building projects in mind? Nothing like starting the day with fresh lumber!",
                new Situation(10, Season.SPRING, Weather.SUNNY));
        put("Rainy mornings are perfect for indoor projects. Ever thought about upgrading your house?",
                new Situation(10, Season.SUMMER, Weather.RAINY));
        put("Storms can be tough on buildings. If anything needs repairs, let me know!",
                new Situation(10, Season.FALL, Weather.STORMY));
        put("Snow makes everything look so peaceful. Almost makes me wish I had more time to just enjoy it.",
                new Situation(10, Season.WINTER, Weather.SNOWY));

        put("Afternoon already? I’ve been sawing wood all day—hope the shop isn’t too messy.",
                new Situation(14, Season.SPRING, Weather.SUNNY));
        put("Rain’s keeping me inside, but that means more time for blueprints and planning.",
                new Situation(14, Season.SUMMER, Weather.RAINY));
        put("These autumn storms make me grateful for solid craftsmanship. A well-built home makes all the difference.",
                new Situation(14, Season.FALL, Weather.STORMY));
        put("Cold afternoons make the shop feel cozy. A fireplace upgrade might be a smart investment.",
                new Situation(14, Season.WINTER, Weather.SNOWY));

        put("Long day, huh? I’ll probably keep working late—there’s always something to build or fix.",
                new Situation(19, Season.SPRING, Weather.SUNNY));
        put("Rainy evenings make me appreciate a sturdy roof. Good thing I know how to build one!",
                new Situation(19, Season.SUMMER, Weather.RAINY));
        put("Wind and rain? Just another reason to make sure your home is strong enough to handle it!",
                new Situation(19, Season.FALL, Weather.STORMY));
        put("A quiet winter night like this makes me appreciate all the hard work that goes into making a home feel safe.",
                new Situation(19, Season.WINTER, Weather.SNOWY));
    }}
    ),
    WILLY(
            new HashMap<>(), new ArrayList<>(), new HashMap<>() {{
        put("Mornin’! Good time to set sail—the fish are biting!", new Situation(10, Season.SPRING, Weather.SUNNY));
        put("Rain’s good for fishin’. They’re more active when the water’s movin’.", new Situation(10, Season.SUMMER, Weather.RAINY));
        put("Storm’s rollin’ in—dangerous waters. Best stay on land today.", new Situation(10, Season.FALL, Weather.STORMY));
        put("Cold wind off the ocean today. Might want to bundle up before headin’ to the docks.", new Situation(10, Season.WINTER, Weather.SNOWY));
    }}
    ),

    MARNIE(
            new HashMap<>(), new ArrayList<>(), new HashMap<>() {{
        put("Morning, dear! The animals are happy today. Must be the sunshine.", new Situation(10, Season.SPRING, Weather.SUNNY));
        put("Rainy days mean extra work cleaning the barn. But the animals don’t seem to mind.", new Situation(10, Season.SUMMER, Weather.RAINY));
        put("Storm’s brewing... better make sure the barn doors are shut tight.", new Situation(10, Season.FALL, Weather.STORMY));
        put("Snow makes the farm look magical! The animals love playing in it.", new Situation(10, Season.WINTER, Weather.SNOWY));
    }}
    ),

    GUS(
            new HashMap<>(), new ArrayList<>(),
            new HashMap<>() {{
                put("Good morning! Fresh coffee brewing—want a cup?", new Situation(10, Season.SPRING, Weather.SUNNY));
                put("Rainy days make the saloon feel extra cozy. Perfect for a warm meal.", new Situation(10, Season.SUMMER, Weather.RAINY));
                put("That storm outside makes me want to cook something hearty. How about some stew?", new Situation(10, Season.FALL, Weather.STORMY));
                put("Cold weather calls for hot drinks! I’ve got cider warming up.", new Situation(10, Season.WINTER, Weather.SNOWY));
            }}
    ),

    SEBASTIAN(
            new HashMap<>(), new ArrayList<>(), new HashMap<>() {{
        put("Morning? Ugh... I’m not awake yet.", new Situation(10, Season.SPRING, Weather.SUNNY));
        put("Rain is nice. Means I don’t have to make excuses to stay inside.", new Situation(10, Season.SUMMER, Weather.RAINY));
        put("Stormy weather’s kinda cool. Makes the whole town feel different.", new Situation(10, Season.FALL, Weather.STORMY));
        put("Snow’s piling up... Looks pretty, but I’d rather be in my room.", new Situation(10, Season.WINTER, Weather.SNOWY));
    }}
    ),

    ABIGAIL(
            new HashMap<>(), new ArrayList<>(),
            new HashMap<>() {{
                put("Morning! Feels like a great day for an adventure.", new Situation(10, Season.SPRING, Weather.SUNNY));
                put("Rain makes everything look mysterious. I kinda love it.", new Situation(10, Season.SUMMER, Weather.RAINY));
                put("Storm? I bet the spirits are restless today!", new Situation(10, Season.FALL, Weather.STORMY));
                put("I love walking through the snow at night. It feels otherworldly.", new Situation(10, Season.WINTER, Weather.SNOWY));
            }}
    ),

    HARVEY(
            new HashMap<>(), new ArrayList<>(),
            new HashMap<>() {{
                put("Good morning! Taking care of your health is just as important as taking care of your farm.", new Situation(10, Season.SPRING, Weather.SUNNY));
                put("Rainy days mean more colds. Be sure to stay dry!", new Situation(10, Season.SUMMER, Weather.RAINY));
                put("Stormy weather is dangerous—stay indoors if you can.", new Situation(10, Season.FALL, Weather.STORMY));
                put("The cold can be tough on the body. Stop by the clinic if you need anything.", new Situation(10, Season.WINTER, Weather.SNOWY));
            }}
    ),

    LEA(
            new HashMap<>(), new ArrayList<>(),
            new HashMap<>() {{
                put("Morning! A day like this makes me want to go outside and sketch nature.", new Situation(10, Season.SPRING, Weather.SUNNY));
                put("Rain is beautiful in its own way. I love how it makes everything glisten.", new Situation(10, Season.SUMMER, Weather.RAINY));
                put("The wind and rain make the world feel wild and untamed. It’s inspiring!", new Situation(10, Season.FALL, Weather.STORMY));
                put("Snowy days are my favorite for carving wood. The quiet helps me focus.", new Situation(10, Season.WINTER, Weather.SNOWY));
            }}
    );

    private final HashMap<HashMap<Item, Integer>, // requests
            HashMap<Item, Integer> // rewards
            > quests;
    private final ArrayList<Item> favorites;
    private final HashMap<String, Situation> dialog;

    NPCType(HashMap<HashMap<Item, Integer>, HashMap<Item, Integer>> quests, ArrayList<Item> favorites,
            HashMap<String, Situation> dialog) {
        this.quests = quests;
        this.favorites = favorites;
        this.dialog = dialog;
    }
    public HashMap<HashMap<Item, Integer>, // requests
            HashMap<Item, Integer> // rewards
            > getQuests() {
        return quests;
    }

    public ArrayList<Item> getFavorites() {
        return favorites;
    }

    public HashMap<String, Situation> getDialog() {
        return dialog;
    }

    public String getName() {
        return this.toString().toLowerCase();
    }

    public String getDialogBySituation(Situation situation) {
        ArrayList<String> strings = new ArrayList<>(dialog.keySet());
        ArrayList<Situation> situations = new ArrayList<>(dialog.values());

        for (Situation s: situations) {
            if (s.equals(situation)) {
                return strings.get(situations.indexOf(s));
            }
        }

        return null;
    }
}
