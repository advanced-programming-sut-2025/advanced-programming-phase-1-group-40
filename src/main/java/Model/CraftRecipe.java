package models;

import models.enums.Skill;
import models.enums.SkillLevel;
import models.enums.types.GoodsType;
import java.util.*;


public class CraftRecipe {
    private String nameOfCraft;
    private int sellPrice;
    private ArrayList<GoodsType> ingredients;
    private Map<Skill, SkillLevel> source;

}