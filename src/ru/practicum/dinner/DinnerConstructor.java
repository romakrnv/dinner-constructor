package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;


public class DinnerConstructor {

    HashMap<String, ArrayList<String>> dishByType = new HashMap<>();


    Random random = new Random();

    void testDishes(){
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
        dishByType.put("q",drink);
        dishByType.put("w",pervoe);
        dishByType.put("e",vtoroe);
    }

    void addNewDish(String dishType, String dishName){
        if(checkType(dishType)){
            ArrayList<String> dishes = dishByType.get(dishType);
            if(dishes.contains(dishName)){
                System.out.println("Блюдо '" + dishName + "' с типом '" + dishType + "' уже существует.");
            } else {
                dishes.add(dishName);
                dishByType.put(dishType, dishes);
            }
        } else {
            ArrayList<String> dishes = new ArrayList<>();
            dishes.add(dishName);
            dishByType.put(dishType, dishes);
        }

    }

    ArrayList<ArrayList<String>> genirateCombo(int count, ArrayList<String> types){ //[[],[]],[[],[],[]],[[],[]]
        ArrayList<ArrayList<String>> combos = new ArrayList<>();

        while (count > 0){
            ArrayList<String> combo = new ArrayList<>();
            for (String type : types) {
                int bound = random.nextInt(dishByType.get(type).size());
                combo.add(dishByType.get(type).get(bound));
            }
            combos.add(combo);
            count--;
        }
        return combos;
    }




    boolean checkType(String type){
        return dishByType.containsKey(type);
    }
}
