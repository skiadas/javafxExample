package com.example.javafx1;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        model.xProperty().addListener((ob, oldV, newV) -> {
            System.out.printf("Change: %s to %s%n", oldV, newV);
        });
        model.setX(20);
        model.setX(30);
    }
}
