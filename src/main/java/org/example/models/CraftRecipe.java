package org.example.models;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.farming.*;
import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;

import java.util.*;


public class CraftRecipe {
    private String nameOfCraft;
    private int sellPrice;
    private ArrayList<GoodsType> ingredients;
    private Map<Skill, SkillLevel> source;

}