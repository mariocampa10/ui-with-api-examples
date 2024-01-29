package api.utils;

import api.models.Pet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PetNameCounter {

    private final List<Pet> pets;

    public PetNameCounter(List<Pet> pets) {
        this.pets = pets;
    }

    public void printPetsWithRepeatedName() {
        Map<String, Integer> nameCountMap = countPetNames();

        String outputMessage = "{";
        int count = 0;

        for (Map.Entry<String, Integer> entry : nameCountMap.entrySet()) {
            if (entry.getValue() > 1) {
                if (count != 0)
                    outputMessage += ", ";
                outputMessage += entry.getKey() + ": " + entry.getValue();
                count++;
            }
        }
        outputMessage += "}";
        System.out.println(outputMessage);
    }

    private Map<String, Integer> countPetNames() {
        Map<String, Integer> nameCountMap = new HashMap<>();

        for (Pet pet : pets) {
            String name = pet.getName();
            nameCountMap.put(name, nameCountMap.getOrDefault(name, 0) + 1);
        }

        return nameCountMap;
    }
}
