package com.service.date.dateservice.commons;

public enum RandomOperation {

    ADD(0), SUBTRACT(1);

    private int value;

    RandomOperation(int value) {
        this.value = value;
    }

    private static RandomOperation fromValue(int value) {
        switch (value) {
            case 0 : return ADD;
            case 1 : return SUBTRACT;
        }
        return null;
    }

    public static RandomOperation getRandomOperation() {
        int value = (int) (Math.random() * 10) % 2;
        return fromValue(value);
    }
}
