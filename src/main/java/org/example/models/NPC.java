package org.example.models;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.farming.*;
import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;



import java.util.ArrayList;
import java.util.HashMap;

public class NPC {
    NPCType name;
    Role role;
    ArrayList<String> dialog;
    HashMap<Time, Position> schedule;

    public NPC(NPCType name, Role role, ArrayList<String> dialog, HashMap<Time, Position> schedule) {
        this.name = name;
        this.role = role;
        this.dialog = dialog;
        this.schedule = schedule;
    }

    public NPCType getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    public ArrayList<String> getDialog() {
        return dialog;
    }

    public HashMap<Time, Position> getSchedule() {
        return schedule;
    }

    public void addDialog(String sentence) {

    }
}
