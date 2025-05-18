package org.example.models;

import org.example.models.enums.types.NPCType;

import java.util.ArrayList;

public class Quest {
    private final int id;
    private final int number;
    private final NPCType npc;
    private final Item request;
    private final int requestQuantity;
    private final Item reward;
    private final int rewardQuantity;
    private boolean completed;

    public Quest(int id, int number, NPCType npc, Item request, int requestQuantity, Item reward, int rewardQuantity) {
        this.id = id;
        this.number = number;
        this.npc = npc;
        this.request = request;
        this.requestQuantity = requestQuantity;
        this.reward = reward;
        this.rewardQuantity = rewardQuantity;
        this.completed = false;
    }

    public Quest(int number, Item request, int requestQuantity, Item reward, int rewardQuantity) {
        this.id = -1;
        this.number = number;
        this.npc = null;
        this.request = request;
        this.requestQuantity = requestQuantity;
        this.reward = reward;
        this.rewardQuantity = rewardQuantity;
    }

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public NPCType getNpc() {
        return npc;
    }

    public Item getRequest() {
        return request;
    }

    public int getRequestQuantity() {
        return requestQuantity;
    }

    public Item getReward() {
        return reward;
    }

    public int getRewardQuantity() {
        return rewardQuantity;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return id + ". " +
                " " + npc.getName() + ":\n" +
                "   Request: " + request + " (*" + requestQuantity + ")\n" +
                "   Reward: " + reward + " (*" + rewardQuantity + ")";
    }
}
