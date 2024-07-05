package com.springcore.col.ci;

import java.util.List;

public class Addr {
    private List<String> addrr;

    public Addr(List<String> addrr) {
        this.addrr = addrr;
    }

    @Override
    public String toString() {
        return "Addr{" +
                "addrr=" + addrr +
                '}';
    }
}
