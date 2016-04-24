package com.example.project.forrent;

import java.io.Serializable;

/**
 * Created by sehci on 4/4/2016.
 * Modified by colliell on 4/13/2016.
 */
public class Prop implements Serializable {
    private String addr;
    private String link;

    public Prop(String addr, String link) {
        this.addr = addr;
        this.link = link;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
