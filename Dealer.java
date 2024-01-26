package com.example.fxpartcw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Dealer {
    private String name;
    private String contactNumber;
    private String location;
    private List<String> itemDetails;

    public Dealer() {
        itemDetails = new ArrayList<>();
    }

    public static void displayRandomDealerDetails() {
    }

    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getLocation() {
        return location;
    }

    public List<String> getItemDetails() {
        return itemDetails;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // Method to read dealers and their item details from the text file.
    public static List<Dealer> readDealersFromFile(String filePath) {
        List<Dealer> dealersList = new ArrayList<>();
        Dealer currentDealer = null;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(", ");
                if (data.length == 3) {
                    if (currentDealer != null) {
                        dealersList.add(currentDealer);
                    }
                    currentDealer = new Dealer();
                    currentDealer.setName(data[0]);
                    currentDealer.setContactNumber(data[1]);
                    currentDealer.setLocation(data[2]);
                } else if (data.length == 5) {
                    currentDealer.getItemDetails().add(line);
                }
            }
            if (currentDealer != null) {
                dealersList.add(currentDealer);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        return dealersList;
    }

    // Method to select a given number of random dealers from the list.
    public static List<Dealer> selectRandomDealers(List<Dealer> dealersList, int numberOfDealers) {
        if (dealersList.size() <= numberOfDealers) {
            return dealersList;
        }

        List<Dealer> randomDealers = new ArrayList<>();
        List<Integer> indexesUsed = new ArrayList<>();
        Random random = new Random();

        while (randomDealers.size() < numberOfDealers) {
            int randomIndex = random.nextInt(dealersList.size());
            if (!indexesUsed.contains(randomIndex)) {
                randomDealers.add(dealersList.get(randomIndex));
                indexesUsed.add(randomIndex);
            }
        }

        return randomDealers;
    }

    // Method to display the details (name, contact number, location) of randomly selected dealers.
    public static void displayDealersDetails(List<Dealer> selectedDealers) {
        for (Dealer d : selectedDealers) {
            System.out.println("Dealer: " + d.getName());
            System.out.println("Contact Number: " + d.getContactNumber());
            System.out.println("Location: " + d.getLocation());
        }
    }

    // Method to display the names of randomly selected dealers and their item details.
    public static ArrayList<HashMap<String, String>> displaySelectedDealersItemDetails(List<Dealer> selectedDealers) {
        for (Dealer d : selectedDealers) {
            System.out.println("Dealer Name: " + d.getName());
            System.out.println("Item Details:");
            for (String itemDetail : d.getItemDetails()) {
                System.out.println(itemDetail);
            }
            System.out.println("====================");
        }
        return null;
    }

}
