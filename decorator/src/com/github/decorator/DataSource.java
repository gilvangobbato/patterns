package com.github.decorator;

public interface DataSource {

    void writeData(String data);

    String readData();
}
