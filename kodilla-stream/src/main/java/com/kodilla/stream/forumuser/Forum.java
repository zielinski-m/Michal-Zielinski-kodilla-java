package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {

    private final List<ForumUser> theUserList = new ArrayList<>();

    public Forum() {
        theUserList.add(new ForumUser(101,"User01", 'M', LocalDate.of(1990,2,11),10));
        theUserList.add(new ForumUser(102,"User02", 'F', LocalDate.of(1999,12,28),0));
        theUserList.add(new ForumUser(103,"User03", 'F', LocalDate.of(2000,4,16),2));
        theUserList.add(new ForumUser(104,"User04", 'M', LocalDate.of(1997,1,25),14));
        theUserList.add(new ForumUser(105,"User05", 'M', LocalDate.of(1987,7,31),38));
        theUserList.add(new ForumUser(106,"User06", 'M', LocalDate.of(2007,5,14),1));
        theUserList.add(new ForumUser(107,"User07", 'F', LocalDate.of(2003,9,5),0));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(theUserList);
    }
}
