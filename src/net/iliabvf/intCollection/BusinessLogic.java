package net.iliabvf.intCollection;

import java.util.Collections;
import java.util.Scanner;

public class BusinessLogic {

    static final String WELCOME_STRING =  "intCollection by Budeanu Vasile. v.1.0";
    static final String INPUT_STRING =  "Enter integer number or (Q - quit, A - add, D - delete, F - find by value, I - find by index, X - max, N - min, M - mid): ";
    static final String INPUT_STRING_A =  "Enter integer number to add: ";
    static final String INPUT_STRING_D =  "Enter index integer number to delete (from 0 to MAX): ";
    static final String ERROR_NUM_DIGITS_STRING =  "Error: Please enter integer number (ex.1).";
    static final String ERROR_INDEX_STRING = "Error: Please provide index from 0 to MAX.";
    static final String ARRAY_STRING = "Array values: ARRAY";
    static final String ADDED_STRING = "Item ADDEDNUM added.";
    static final String REMOVED_STRING = "Item with index REMOVEDINDEX was deleted.";
    static final String NO_ITEMS_STRING = "No items in list.";
    static final String INPUT_STRING_F = "Enter integer number value to find: ";
    static final String NO_ITEMS_FOUND = "No items found";
    static final String ITEMS_FOUND_INDEX = "Item found at index: INDEX";
    static final String INPUT_STRING_I = "Enter index integer number to find (from 0 to MAX): ";
    static final String ITEMS_FOUND_VALUE = "Item found with value: VALUE.";
    static final String MAX_VALUE_STRING = "Max value is MAX.";
    static final String MIN_VALUE_STRING = "Min value is MIN.";
    static final String MID_VALUE_STRING = "Mid value is MID.";

    private IntCollection collection;
    private Scanner scanner;

    public BusinessLogic() {
        this.collection = new IntCollection();
        this.scanner = new Scanner(System.in);
    }

    String userInput(String message){
        System.out.println();
        System.out.print(message);
        try {
            return scanner.nextLine();
        } catch (Exception e)
        {
            return "";
        }
    }

    Integer validateInput(String input, String mode){
        if (mode.toUpperCase().equals("")) {
            if (input.toUpperCase().equals("Q") || input.toUpperCase().equals("A") || input.toUpperCase().equals("D") || input.toUpperCase().equals("F") || input.toUpperCase().equals("I") || input.toUpperCase().equals("X") || input.toUpperCase().equals("N") || input.toUpperCase().equals("M")) {
                return 0;
            }
        }

        if (input.length() == 0) {
            System.out.println(ERROR_NUM_DIGITS_STRING);
            return 0;
        }

        try {
            return Integer.parseInt(input);
        } catch (Exception e){
            System.out.println(ERROR_NUM_DIGITS_STRING);
            return 0;
        }

    }

    void start() {
        System.out.println(WELCOME_STRING);

        String input = "";
        int inputResult = 0;

        // main cycle
        while (true) {
            input = userInput(INPUT_STRING);
            inputResult = validateInput(input, "");

            if (input.toUpperCase().equals("Q")) {
                return;

            } else if (input.toUpperCase().equals("A")) { // Add operation

                while (true) {
                    input = userInput(INPUT_STRING_A);
                    inputResult = validateInput(input, "A");
                    if (inputResult == 0){
                        continue;
                    }

                    collection.add(inputResult);

                    System.out.println(ADDED_STRING.replace("ADDEDNUM", String.valueOf(inputResult)));
                    System.out.println(ARRAY_STRING.replace("ARRAY", collection.getIntList().toString()));
                    break;
                }

            } else if (input.toUpperCase().equals("D")) { // Del operation

                if (collection.getSize() == 0){
                    System.out.println(NO_ITEMS_STRING);
                    continue;
                }

                while (true) {
                    input = userInput(INPUT_STRING_D.replace("MAX", String.valueOf(collection.getSize()-1)));
                    inputResult = validateInput(input, "D");
                    if (inputResult < 0 || inputResult > collection.getSize()-1){
                        System.out.println(ERROR_INDEX_STRING.replace("MAX", String.valueOf(collection.getSize()-1)));
                        continue;
                    }

                    collection.remove(inputResult);

                    System.out.println(REMOVED_STRING.replace("REMOVEDINDEX", String.valueOf(inputResult)));
                    System.out.println(ARRAY_STRING.replace("ARRAY", collection.getIntList().toString()));

                    break;
                }


            } else if (input.toUpperCase().equals("F")) { // Find operation

                if (collection.getSize() == 0){
                    System.out.println(NO_ITEMS_STRING);
                    continue;
                }

                while (true) {
                    input = userInput(INPUT_STRING_F);
                    inputResult = validateInput(input, "F");
                    if (inputResult == 0){
                        continue;
                    }

                    int foundIndex = collection.getIntList().indexOf(new Integer(inputResult));
                    if (foundIndex == -1){
                        System.out.println(NO_ITEMS_FOUND);
                        break;
                    }

                    System.out.println(ITEMS_FOUND_INDEX.replace("INDEX", String.valueOf(foundIndex)));
                    break;

                }


            } else if (input.toUpperCase().equals("I")) { // Find by index

                if (collection.getSize() == 0){
                    System.out.println(NO_ITEMS_STRING);
                    continue;
                }

                while (true) {
                    input = userInput(INPUT_STRING_I.replace("MAX", String.valueOf(collection.getSize()-1)));
                    inputResult = validateInput(input, "I");
                    if (inputResult < 0 || inputResult > collection.getSize()-1){
                        System.out.println(ERROR_INDEX_STRING.replace("MAX", String.valueOf(collection.getSize()-1)));
                        continue;
                    }

                    System.out.println(ITEMS_FOUND_VALUE.replace("VALUE", collection.getIntList().toString()));

                    break;
                }

            } else if (input.toUpperCase().equals("X")) { // Find MAX

                if (collection.getSize() == 0){
                    System.out.println(NO_ITEMS_STRING);
                    continue;
                }

                System.out.println(MAX_VALUE_STRING.replace("MAX", String.valueOf(collection.getMax())));

            } else if (input.toUpperCase().equals("N")) { // Find MIN

                if (collection.getSize() == 0){
                    System.out.println(NO_ITEMS_STRING);
                    continue;
                }

                System.out.println(MIN_VALUE_STRING.replace("MIN", String.valueOf(collection.getMin())));

            } else if (input.toUpperCase().equals("M")) { // Find MID

                if (collection.getSize() == 0){
                    System.out.println(NO_ITEMS_STRING);
                    continue;
                }

                System.out.println(MID_VALUE_STRING.replace("MID", String.valueOf(collection.getMid())));

            } else if (inputResult == 0) {
                continue;

            }

        }
    }
}
