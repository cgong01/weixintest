package com.test.weixin.dao;

import java.util.Map;

public interface AbstractDao {

    public void close();

    public void setName();

    public void setJoin();

    public void setFriendSide();

    public void setNumFriends();

    public Map<String, String> getInfo(int uid);

}
