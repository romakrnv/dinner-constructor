package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;

public class DinnerConstructor {

    HashMap<String, ArrayList<String>> dishesByType = new HashMap<>();
    Random random = new Random();

    void addTestDishes() {
        ArrayList<String> drink = new ArrayList<>();
        drink.add("сок");
        drink.add("чай");
        drink.add("морс");
        ArrayList<String> pervoe = new ArrayList<>();
        pervoe.add("борщ");
        pervoe.add("солянка");
        pervoe.add("супчик");
        ArrayList<String> vtoroe = new ArrayList<>();
        vtoroe.add("рис");
        vtoroe.add("плов");
        vtoroe.add("курица");
        dishesByType.put("q", drink);
        dishesByType.put("w", pervoe);
        dishesByType.put("e", vtoroe);
    }

    void addNewDish(String dishType, String dishName) {
        if(dishType.isEmpty() || dishName.isEmpty()){
            System.out.println("Ошибка, введена пустая строка.");
        } else {
            if (checkType(dishType)) {
                ArrayList<String> dishes = dishesByType.get(dishType);
                if (dishes.contains(dishName)) {
                    System.out.println("Блюдо '" + dishName + "' с типом '" + dishType + "' уже существует.");
                } else {
                    dishes.add(dishName);
                    dishesByType.put(dishType, dishes);
                }
            } else {
                ArrayList<String> dishes = new ArrayList<>();
                dishes.add(dishName);
                dishesByType.put(dishType, dishes);
            }
        }
    }

    ArrayList<ArrayList<String>> generateCombo(int count, ArrayList<String> types) {
        ArrayList<ArrayList<String>> combos = new ArrayList<>();

        while (count > 0) {
            ArrayList<String> combo = new ArrayList<>();
            for (String type : types) {
                int bound = random.nextInt(dishesByType.get(type).size());
                combo.add(dishesByType.get(type).get(bound));
            }
            combos.add(combo);
            count--;
        }
        return combos;
    }

    boolean checkType(String type) {
        return dishesByType.containsKey(type);
    }
}
