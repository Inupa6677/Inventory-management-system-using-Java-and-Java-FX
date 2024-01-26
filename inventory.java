package com.example.fxpartcw;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;



public class inventory {
    static final String finalFilePathway = System.getProperty("user.dir") +
            "/src/main/resources/com/example/fxpartcw/itemDetails.txt";

    private int itemCode;
    private String itemName;
    private String itemBrand;
    private double itemPrice;
    private int itemQuantity;
    private String itemCategory;
    private String itemPurchasedDate;




    public int getItemCode() {
        return itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemBrand() {
        return itemBrand;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public String getItemPurchasedDate() {
        return itemPurchasedDate;
    }

    public void  setItemCode(int itemCode) {this.itemCode = itemCode;}

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemBrand(String itemBrand) {
        this.itemBrand = itemBrand;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public void setItemCategory(String itemCategory){this.itemCategory = itemCategory;}

    public void setItemPurchasedDate(String itemPurchasedDate) {
        this.itemPurchasedDate = itemPurchasedDate;
    }

    // making a hashmap and adding item details to a hashmap
    static HashMap<String,String> addingItemDetailsMap = new HashMap<>();

    public static ArrayList<HashMap<String, String>> readData(){

        String line;
        ArrayList<HashMap<String,String>> arrayListOfTheItemDetailsMap = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filePathway))) {
            while ((line = reader.readLine()) != null){
                HashMap<String,String> hashMap = parseLineToHashMap(line);
                if (hashMap != null){
                    arrayListOfTheItemDetailsMap.add(hashMap);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return arrayListOfTheItemDetailsMap;

    }


    public void addItemsToHashMap(){
        addingItemDetailsMap.put("itemCode" , String.valueOf(itemCode));
        addingItemDetailsMap.put("itemName" , itemName);
        addingItemDetailsMap.put("itemBrand" , itemBrand);
        addingItemDetailsMap.put("itemPrice" , String.valueOf(itemPrice));
        addingItemDetailsMap.put("itemQuantity" , String.valueOf(itemQuantity));
        addingItemDetailsMap.put("itemCategory" , itemCategory);
        addingItemDetailsMap.put("itemPurchasedDate" , String.valueOf(itemPurchasedDate));
        System.out.println(addingItemDetailsMap);

    }

    static String filePathway = finalFilePathway;

    public void saveHashMapToTextFile(){

        //writing the details to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePathway,true))) {
            writer.write(String.valueOf(addingItemDetailsMap));
            writer.newLine();
            writer.close();
            System.out.println("Details saved successfully");
            System.out.println(addingItemDetailsMap.entrySet());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean deleteItemDetails(String itemCode){
        String line;
        ArrayList<HashMap<String,String>> arrayListOfTheItemDetailsMap = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filePathway))) {
            while ((line = reader.readLine()) != null){
                HashMap<String,String> hashMap = parseLineToHashMap(line);
                if (hashMap != null){
                    arrayListOfTheItemDetailsMap.add(hashMap);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(arrayListOfTheItemDetailsMap);
        arrayListOfTheItemDetailsMap.removeIf(itemData -> itemData.get("itemCode").equals(itemCode));
        System.out.println(arrayListOfTheItemDetailsMap);


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePathway))) {
            for (Map<String, String> mapAfterDeleteItemDetails : arrayListOfTheItemDetailsMap){
                writer.write(String.valueOf(mapAfterDeleteItemDetails));
                writer.newLine();
                System.out.println("Data has been written to itemDetails.txt");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    ArrayList<HashMap<String, String>> arrayListOfDeleteAndSaved = new ArrayList<>();
    public void searchForUpdateDetails(String getItemCode, TextField itemCode, TextField itemName, TextField
            itemCategory, TextField itemBrand, TextField itemQuantity, TextField itemPrice, DatePicker itemPurchasedDate) {

        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePathway))) {
            while ((line = reader.readLine()) != null) {
                HashMap<String, String> hashMap = parseLineToHashMap(line);
                if (hashMap != null) {
                    arrayListOfDeleteAndSaved.add(hashMap);
                }
            }
            boolean itemFound = false;
            for (HashMap<String, String> hashMap : arrayListOfDeleteAndSaved) {
                if (hashMap.get("itemCode").equals(getItemCode)) {
                    itemFound = true;
                    itemCode.setPromptText(hashMap.get("itemCode"));
                    itemName.setPromptText(hashMap.get("itemName"));
                    itemBrand.setPromptText(hashMap.get("itemBrand"));
                    itemPrice.setPromptText(hashMap.get("itemPrice"));
                    itemQuantity.setPromptText(hashMap.get("itemQuantity"));
                    itemCategory.setPromptText(hashMap.get("itemCategory"));
                    itemPurchasedDate.setPromptText(hashMap.get("itemPurchasedDate"));
                    break; // No need to search further once the item is found
                }
            }

            if (!getItemCode.matches("\\d+")) { // Check if the input is not a number
                showAlert("Item code should be an integer.");
            } else if (!itemFound) { // Check if the item code is not found in the HashMap
                showAlert("Item code not found.");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Input Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void updateData(String getItemCode, TextField itemCode, TextField itemName, TextField
            itemCategory, TextField itemBrand, TextField itemQuantity, TextField itemPrice, DatePicker itemPurchasedDate) {
        String line;

        arrayListOfDeleteAndSaved.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePathway))) {
            while ((line = reader.readLine()) != null) {
                HashMap<String, String> hashMap = parseLineToHashMap(line);
                if (hashMap != null) {
                    arrayListOfDeleteAndSaved.add(hashMap);
                }
            }
            for (HashMap<String, String> hashMap : arrayListOfDeleteAndSaved) {

                if (hashMap.get("itemCode").equals(getItemCode)) {

                    // Validate itemCode
                    try {
                        int code = Integer.parseInt(itemCode.getText());
                        hashMap.put("itemCode", String.valueOf(code));
                        itemCode.setStyle("");
                    } catch (NumberFormatException e) {
                        // Display an alert for invalid itemCode
                        showAlert("Invalid itemCode! Please enter a valid integer value.");
                        itemCode.setStyle("-fx-border-color: red;");
                        return;
                    }

                    // Validate itemName, itemCategory, and itemBrand
                    if (!itemName.getText().matches("[A-Za-z]+")) {
                        // Display an alert for invalid itemName
                        showAlert("Invalid itemName! Please enter letters in English alphabet only.");
                        itemName.setStyle("-fx-border-color: red;");
                        return;
                    }
                    hashMap.put("itemName", itemName.getText());

                    if (!itemCategory.getText().matches("[A-Za-z]+")) {
                        // Display an alert for invalid itemCategory
                        showAlert("Invalid itemCategory! Please enter letters in English alphabet only.");
                        itemCategory.setStyle("-fx-border-color: red;");
                        return;
                    }
                    hashMap.put("itemCategory", itemCategory.getText());

                    if (!itemBrand.getText().matches("[A-Za-z]+")) {
                        // Display an alert for invalid itemBrand
                        showAlert("Invalid itemBrand! Please enter letters in English alphabet only.");
                        itemBrand.setStyle("-fx-border-color: red;");
                        return;
                    }
                    hashMap.put("itemBrand", itemBrand.getText());

                    // Validate itemPrice
                    try {
                        double price = Double.parseDouble(itemPrice.getText());
                        hashMap.put("itemPrice", String.valueOf(price));
                        itemCode.setStyle("");
                    } catch (NumberFormatException e) {
                        // Display an alert for invalid itemPrice
                        showAlert("Invalid itemPrice! Please enter a valid number.");
                        itemPrice.setStyle("-fx-border-color: red;");
                        return;
                    }

                    // Validate itemQuantity
                    try {
                        int quantity = Integer.parseInt(itemQuantity.getText());
                        hashMap.put("itemQuantity", String.valueOf(quantity));
                        itemCode.setStyle("");
                    } catch (NumberFormatException e) {
                        // Display an alert for invalid itemQuantity
                        showAlert("Invalid itemQuantity! Please enter a valid integer value.");
                        itemQuantity.setStyle("-fx-border-color: red;");
                        return;
                    }

                    // Validate itemPurchasedDate (assuming itemPurchasedDate is of type LocalDate)
                    if (itemPurchasedDate.getValue() == null) {
                        // Display an alert for missing itemPurchasedDate
                        showAlert("Missing itemPurchasedDate! Please select a date.");
                        return;
                    }
                    hashMap.put("itemPurchasedDate", String.valueOf(itemPurchasedDate.getValue()));

                    System.out.println(hashMap);
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePathway))) {
            for (Map<String, String> mapAfterDeleteItemDetails : arrayListOfDeleteAndSaved) {
                writer.write(String.valueOf(mapAfterDeleteItemDetails));
                writer.newLine();
                System.out.println("Data has been written to itemDetails.txt");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static HashMap<String, String> parseLineToHashMap(String line) {
        HashMap<String,String> hashMap = new HashMap<>();
        line = line.replaceAll("[{}]", "");
        String[] keyValuePairs = line.split(", ");
        for (String keyValuePair : keyValuePairs){
            String[] keyValue = keyValuePair.split("=");
            if (keyValue.length == 2) {
                String key = keyValue[0].trim();
                String value = keyValue[1].trim();
                hashMap.put(key,value);
            } else {
                System.out.println("Invalid line format: " + line);
                return null;
            }

        }
        return hashMap;
    }


}





