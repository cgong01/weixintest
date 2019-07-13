package com.test.weixin.model;


public class Guest {

    private int recordId;

    private String name;

    private String joinWedding;

    private int numOfFriend;

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

    public int getNumOfFriend() {
        return numOfFriend;
    }

    public void setNumOfFriend(int numOfFriend) {
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
                ", numOfFriend=" + numOfFriend +
                ", sideOfFriend='" + sideOfFriend + '\'' +
                '}';
    }
}
