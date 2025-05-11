package org.example.models;

import org.example.models.enums.types.*;
import org.example.models.enums.*;

import java.util.*;


public class CraftRecipe {
    private String nameOfCraft;
    private int sellPrice;
    private ArrayList<ShopItemTypes> ingredients;
    private Map<Skill, SkillLevel> source;
}