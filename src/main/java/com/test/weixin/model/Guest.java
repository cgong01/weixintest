package com.test.weixin.model;


public class Guest {

    public Guest() {
    }

    public Guest(String name, String joinWedding, String numOfFriend, String sideOfFriend) {
        this.name = name;
        this.joinWedding = joinWedding;
        this.numOfFriend = numOfFriend;
        this.sideOfFriend = sideOfFriend;
    }

    private int recordId;

    private String name;

    private String joinWedding;

    private String numOfFriend;

    private String sideOfFriend;

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJoinWedding() {
        return joinWedding;
    }

    public void setJoinWedding(String joinWedding) {
        this.joinWedding = joinWedding;
    }

    public String getNumOfFriend() {
        return numOfFriend;
    }

    public void setNumOfFriend(String numOfFriend) {
        this.numOfFriend = numOfFriend;
    }

    public String getSideOfFriend() {
        return sideOfFriend;
    }

    public void setSideOfFriend(String sideOfFriend) {
        this.sideOfFriend = sideOfFriend;
    }


    @Override
    public String toString() {
        return "Guest{" +
                "recordId=" + recordId +
                ", name='" + name + '\'' +
                ", joinWedding='" + joinWedding + '\'' +
                ", numOfFriend='" + numOfFriend + '\'' +
                ", sideOfFriend='" + sideOfFriend + '\'' +
                '}';
    }
}
