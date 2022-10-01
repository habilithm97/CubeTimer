package com.example.cubetimer.Model;

public class Model {
    String record;
    String scramble;

    public Model(String record, String scramble) {
        this.record = record;
        this.scramble = scramble;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public String getScramble() {
        return scramble;
    }

    public void setScramble(String scramble) {
        this.scramble = scramble;
    }
}
