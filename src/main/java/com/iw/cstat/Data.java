package com.iw.cstat;

public interface Data {
    int id();
    Attributes attributes();
    Relationships relationships();
    Links links();
    String type();
}
