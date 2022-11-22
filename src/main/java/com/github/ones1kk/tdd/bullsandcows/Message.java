package com.github.ones1kk.tdd.bullsandcows;

public enum Message {

    BOTH("%s Ball, %s Strike"),
    ONLY_BALL("%s Ball"),
    ONLY_STRIKE("%s Strike"),
    NOTHING("Nothing"),
    END("You got all 3 numbers right!\n Game Over");

    private final String value;


    Message(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
