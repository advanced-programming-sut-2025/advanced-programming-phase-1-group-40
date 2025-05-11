package org.example.models.enums.types;


import org.example.models.*;


import java.util.ArrayList;
import java.util.HashMap;

// public enum NPCType {
//     CLINT(
//             Role.BLACKSMITH,
//             new HashMap<HashMap<Item, Integer>, HashMap<Item, Integer>>() {{
//                 put(new HashMap<Item, Integer>() {{ put(Item.IRON_ORE, 50); }},
//                         new HashMap<Item, Integer>() {{ put(Item.DIAMOND, 2); }}
//                 );
//             }},
//             new ArrayList<Item>() {{ add(Item.IRON_BAR); add(Item.GOLD_BAR); }}
//     ),
//     MORRIS(Role.SHOPKEEPER),
//     PIERRE(Role.SHOPKEEPER),
//     ROBIN(Role.SHOPKEEPER),
//     WILLY(Role.SHOPKEEPER),
//     MARNIE(Role.SHOPKEEPER),
//     GUS(Role.SHOPKEEPER),
//     SEBASTIAN(Role.VILLAGER),
//     ABIGAIL(Role.VILLAGER),
//     HARVEY(Role.VILLAGER),
//     LEA(Role.VILLAGER);

public enum NPCType {
    CLINT(
            Role.BLACKSMITH,
            new HashMap<HashMap<Item, Integer>, HashMap<Item, Integer>>() {{
                put(new HashMap<Item, Integer>() {{ put(ShopItemTypes.IRON_ORE, 50); }},
                        new HashMap<Item, Integer>() {{ put(StoneType.DIAMOND, 2); }}
                );
            }},
            new ArrayList<Item>() {{ add(ProcessedItemType.IRON_BAR); add(ProcessedItemType.GOLD_BAR); }}
    ),
    MORRIS(Role.SHOPKEEPER, new HashMap<>(), new ArrayList<>()),
    PIERRE(Role.SHOPKEEPER, new HashMap<>(), new ArrayList<>()),
    ROBIN(Role.SHOPKEEPER, new HashMap<>(), new ArrayList<>()),
    WILLY(Role.SHOPKEEPER, new HashMap<>(), new ArrayList<>()),
    MARNIE(Role.SHOPKEEPER, new HashMap<>(), new ArrayList<>()),
    GUS(Role.SHOPKEEPER, new HashMap<>(), new ArrayList<>()),
    SEBASTIAN(Role.VILLAGER, new HashMap<>(), new ArrayList<>()),
    ABIGAIL(Role.VILLAGER, new HashMap<>(), new ArrayList<>()),
    HARVEY(Role.VILLAGER, new HashMap<>(), new ArrayList<>()),
    LEA(Role.VILLAGER, new HashMap<>(), new ArrayList<>());

    Role role;
    HashMap<HashMap<Item, Integer>, // requests
            HashMap<Item, Integer> // rewards
            > quests;
    ArrayList<Item> favorites;

    NPCType(Role role, HashMap quests, ArrayList favorites) {
        this.role = role;
        this.quests = quests;
        this.favorites = favorites;
    }
}
