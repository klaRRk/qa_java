package com.example;

import java.util.List;

public class Lion {

    boolean hasMane;
    Predator predator; // Добавлена переменная predator типа Predator для инъекции зависимости

    // Изменен конструктор: добавлен параметр predator для инъекции зависимости
    public Lion(String sex, Predator predator) throws Exception {
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }

        // Добавлена инициализация переменной predator
        this.predator = predator;
    }

    // Метод getKittens() теперь использует predator вместо feline
    public int getKittens() {
        return predator.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    // Метод getFood() теперь вызывает eatMeat() у predator вместо getFood() у feline
    public List<String> getFood() throws Exception {
        return predator.eatMeat();
    }
}