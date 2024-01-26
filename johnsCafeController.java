package com.example.fxpartcw;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import static com.example.fxpartcw.Dealer.*;
import static com.example.fxpartcw.inventory.addingItemDetailsMap;

public class johnsCafeController {

    @FXML
    private Button addImageButtonInAddItems;

    @FXML
    private ImageView imageViewInAddImageInAdditemdetails;

    @FXML
    private ImageView ImageViewInUpdate;

    @FXML
    private Button addItemImageInUpdate;



    @FXML
    private TextField ContactNumberInDealer1;

    @FXML
    private TextField ContactNumberInDealer2;

    @FXML
    private TextField ContactNumberInDealer3;

    @FXML
    private TextField ContactNumberInDealer4;

    @FXML
    private Button backButtonInRandomDealers;

    @FXML
    private TextField locationInDealer1;

    @FXML
    private TextField locationInDealer2;

    @FXML
    private TextField locationInDealer3;

    @FXML
    private TextField locationInDealer4;

    @FXML
    private TextField nameInDealer1;

    @FXML
    private TextField nameInDealer2;

    @FXML
    private TextField nameInDealer3;

    @FXML
    private TextField nameInDealer4;

    @FXML
    private Button pathToItemDetailsFromDealerDetails;


    @FXML
    private TableView<HashMap<String, String>> viewItemTable;

    @FXML
    private TableColumn<HashMap<String, String>, String> imageViewInView;

    @FXML
    private TableColumn<HashMap<String, String>, String> itemBrandIdInView;

    @FXML
    private TableColumn<Map<String, String>, String> itemCategoryIdInView;

    @FXML
    private TableColumn<Map<String, String>, String> itemCodeIdInView;

    @FXML
    private TableColumn<Map<String, String>, String> itemNameIdInView;

    @FXML
    private TableColumn<Map<String, String>, String> itemPriceIdInView;

    @FXML
    private TableColumn<Map<String, String>, String> itemPurchasedDateIdInView;

    @FXML
    private TableColumn<Map<String, String>, String> itemQuantityIdInView;

    @FXML
    private TableView<HashMap<String, String>> dealerDetailsTable;

    @FXML
    private TableColumn<HashMap<String, String>, String> dealerNameInDisplay;

    @FXML
    private Button displayButton;

    @FXML
    private Button exitButtonInDisplay;
    @FXML
    private TableView<HashMap<String,String>> dealerItemDetailsTable;

    @FXML
    private TableColumn<HashMap<String, String>, String> itemBrandInViewdetails;

    @FXML
    private TableColumn<HashMap<String, String>, String> itemCodeInViewdetails;

    @FXML
    private TableColumn<HashMap<String, String>, String>itemNameInViewdetails;

    @FXML
    private TableColumn<HashMap<String, String>, String> itemPriceInViewdetails;

    @FXML
    private TableColumn<HashMap<String, String>, String> itemQuantityInViewdetails;

    @FXML
    private Button populatebtn;


    @FXML
    private TextField itemAddingTextfield;

    @FXML
    private TextField itemAddingTextfield1;

    @FXML
    private TextField itemAddingTextfield2;

    @FXML
    private TextField itemAddingTextfield3;

    @FXML
    private TextField itemAddingTextfield4;

    @FXML
    private TextField itemAddingTextfield6;

    @FXML
    private DatePicker itemAddingTextfield7;

    @FXML
    private Label itemcodeErrordisplayLabel;

    @FXML
    private AnchorPane mainAncorpane;

    @FXML
    private Button saveItemDetailsInAddItemClick;
    @FXML
    private Button ExitPartdeleteItem;

    @FXML
    private Button deleteButtonInDeleteItems;

    @FXML
    private Label deleteItemlabel5;

    @FXML
    private Label deleteItemlabel7;

    @FXML
    private Button deleteTextField;

    @FXML
    private Button deleteTextField1;

    @FXML
    private TextField deleteTextField4;

    @FXML
    private Label deleteitemlabel2;

    @FXML
    private Label deletelabel1;

    @FXML
    private TextField gettingTheItemCodeInUpdate;

    @FXML
    private TextField itemUpdatingTextfield;

    @FXML
    private TextField itemUpdatingTextfield1;

    @FXML
    private TextField itemUpdatingTextfield2;

    @FXML
    private TextField itemUpdatingTextfield3;

    @FXML
    private TextField itemUpdatingTextfield4;

    @FXML
    private TextField itemUpdatingTextfield5;

    @FXML
    private TextField itemUpdatingTextfield6;

    @FXML
    private Button saveDetailsInUpdate;

    @FXML
    private Button searchInUpdate;
    @FXML
    private DatePicker purchasingDateInUpdate;

    public void onGetStartedButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader dashboardLoader = new FXMLLoader(getClass().getResource("mainpage.fxml"));

        Parent root = dashboardLoader.load();

        Scene dashboardPage = new Scene(root);

        Stage previousStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        previousStage.setScene(dashboardPage);
    }
    public void backButtonInselectingRandomDealersClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader dashboardLoader = new FXMLLoader(getClass().getResource("mainpage.fxml"));

        Parent root = dashboardLoader.load();

        Scene dashboardPage = new Scene(root);

        Stage previousStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        previousStage.setScene(dashboardPage);
    }

    public void onbtnAdditemsButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader dashboardLoader = new FXMLLoader(getClass().getResource("AddItemsfile.fxml"));

        Parent root = dashboardLoader.load();

        Scene dashboardPage = new Scene(root);

        Stage previousStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        previousStage.setScene(dashboardPage);
    }

    public void onbtnDeleteitemsButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader dashboardLoader = new FXMLLoader(getClass().getResource("DeleteItems.fxml"));

        Parent root = dashboardLoader.load();

        Scene dashboardPage = new Scene(root);

        Stage previousStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        previousStage.setScene(dashboardPage);
    }

    public void onbtnUpdateitemsButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader dashboardLoader = new FXMLLoader(getClass().getResource("updateitemdetails.fxml"));

        Parent root = dashboardLoader.load();

        Scene dashboardPage = new Scene(root);

        Stage previousStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        previousStage.setScene(dashboardPage);

    }

    public void onBackButtonInAddItemClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader dashboardLoader = new FXMLLoader(getClass().getResource("mainpage.fxml"));

        Parent root = dashboardLoader.load();

        Scene dashboardPage = new Scene(root);

        Stage previousStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        previousStage.setScene(dashboardPage);
    }

    public void exitButtonDisplayDealer(ActionEvent actionEvent) throws IOException {
        FXMLLoader dashboardLoader = new FXMLLoader(getClass().getResource("mainpage.fxml"));

        Parent root = dashboardLoader.load();

        Scene dashboardPage = new Scene(root);

        Stage previousStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        previousStage.setScene(dashboardPage);
    }
    public void onClickToDealerItemDetails(ActionEvent actionEvent) throws IOException {
        FXMLLoader dashboardLoader = new FXMLLoader(getClass().getResource("dealerItemDetails.fxml"));

        Parent root = dashboardLoader.load();

        Scene dashboardPage = new Scene(root);

        Stage previousStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        previousStage.setScene(dashboardPage);
    }

    public void exitButtonMain(ActionEvent actionEvent) {
        // Exit the application
        Platform.exit();
    }

    public void onViewItemButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader dashboardLoader = new FXMLLoader(getClass().getResource("viewItemFile.fxml"));


        Parent root = dashboardLoader.load();

        Scene dashboardPage = new Scene(root);

        Stage previousStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        previousStage.setScene(dashboardPage);


    }

    public void onBackButtonInViewItemClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader dashboardLoader = new FXMLLoader(getClass().getResource("mainpage.fxml"));

        Parent root = dashboardLoader.load();

        Scene dashboardPage = new Scene(root);

        Stage previousStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        previousStage.setScene(dashboardPage);
    }

    public void onBackButtonInUpdateItemClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader dashboardLoader = new FXMLLoader(getClass().getResource("mainpage.fxml"));

        Parent root = dashboardLoader.load();

        Scene dashboardPage = new Scene(root);

        Stage previousStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        previousStage.setScene(dashboardPage);
    }

    public void exitForMainMenuInDeleteItemClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader dashboardLoader = new FXMLLoader(getClass().getResource("mainpage.fxml"));

        Parent root = dashboardLoader.load();

        Scene dashboardPage = new Scene(root);

        Stage previousStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        previousStage.setScene(dashboardPage);
    }

    public void selectDealersButtonInMainPage(ActionEvent actionEvent) throws IOException {
        FXMLLoader dashboardLoader = new FXMLLoader(getClass().getResource("randomDealers.fxml"));

        Parent root = dashboardLoader.load();

        Scene dashboardPage = new Scene(root);

        Stage previousStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        previousStage.setScene(dashboardPage);
        initializeDealersDetails();
        displayRandomDealerDetails();
    }

    public void saveItemsInMain(ActionEvent actionEvent) throws IOException {
        showAlert("Item Details Saved Successfully");
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private List<Dealer> dealersList;
    private Dealer dealer = new Dealer();

    List<Dealer> selectedDealers =  new ArrayList<>();

    ObservableList<HashMap<String, String>> dataList;


    public void initializeDealersDetails() {
        final String filePath = System.getProperty("user.dir") + "/src/main/resources/com/example/fxpartcw/dealers.txt";
        dealersList = dealer.readDealersFromFile(filePath);
        displayRandomDealerDetails();
    }

    // Method to display the details (name, contact number, location) of a random Dealer.

    private void displayDealerDetails() {
        String filePath = System.getProperty("user.dir") + "/src/main/resources/com/example/fxpartcw/dealers.txt";
        List<Dealer> dealersList = dealer.readDealersFromFile(filePath);

        // Step 1: Select random dealers
        selectedDealers = selectRandomDealers(dealersList, 4);

        Dealer sunil = selectedDealers.get(0);
        nameInDealer1.setText(sunil.getName());
        ContactNumberInDealer1.setText(sunil.getContactNumber());
        locationInDealer1.setText(sunil.getLocation());
        Dealer nimal = selectedDealers.get(1);
        nameInDealer2.setText(nimal.getName());
        ContactNumberInDealer2.setText(nimal.getContactNumber());
        locationInDealer2.setText(nimal.getLocation());
        Dealer ashan = selectedDealers.get(2);
        nameInDealer3.setText(ashan.getName());
        ContactNumberInDealer3.setText(ashan.getContactNumber());
        locationInDealer3.setText(ashan.getLocation());
        Dealer kamal = selectedDealers.get(3);
        nameInDealer4.setText(kamal.getName());
        ContactNumberInDealer4.setText(kamal.getContactNumber());
        locationInDealer4.setText(kamal.getLocation());

        // Assuming dealer.displaySelectedDealersItemDetails(selectedDealers) returns ArrayList<HashMap<String, String>>
        ArrayList<HashMap<String, String>> data = dealer.displaySelectedDealersItemDetails(selectedDealers);

        if (data != null) {
            dataList = FXCollections.observableArrayList(data);
            System.out.println(dataList);
            dealerDetailsTable.setItems(dataList);
        } else {
            // Handle the case when data is null (optional)
            System.out.println("Error: The data list is null.");
        }
    }

    public void displayItemDetails(){

        // Bind the cell value factories to the HashMap keys
        itemCodeInViewdetails.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("itemID")));
        itemNameInViewdetails.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("itemName")));
        itemBrandInViewdetails.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("itemBrand")));
        itemPriceInViewdetails.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("itemPrice")));
        itemQuantityInViewdetails.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("itemQuantity")));


        System.out.println(dataList);

        dealerDetailsTable.setItems(dataList);

    }

    public void displayDetailsButton(){
        displayItemDetails();
    }


    inventory item = new inventory();
    @FXML
    void saveItemDetailsInAddItems(ActionEvent event) {
        // Get the input values from text fields
        String itemCodeText = itemAddingTextfield.getText();
        String itemNameText = itemAddingTextfield3.getText();
        String itemBrandText = itemAddingTextfield4.getText();
        String itemPriceText = itemAddingTextfield2.getText();
        String itemQuantityText = itemAddingTextfield1.getText();
        String itemCategoryText = itemAddingTextfield6.getText();
        String itemPurchasedDateText = String.valueOf(itemAddingTextfield7.getValue());

        // Validate itemCode and itemQuantity
        boolean isItemCodeValid = checkingValidPositiveInteger(itemCodeText);
        boolean isItemQuantityValid = checkingValidPositiveInteger(itemQuantityText);

        // Validate itemPrice
        boolean isItemPriceValid = checkingValidDouble(itemPriceText);

        // Validate itemName, itemBrand, and itemCategory
        boolean areItemDetailsValid = checkingValidString(itemNameText)
                && checkingValidString(itemBrandText)
                && checkingValidString(itemCategoryText);

        if (isItemCodeValid && isItemQuantityValid && isItemPriceValid && areItemDetailsValid) {
            // If all inputs are valid, proceed with saving the item details
            item.setItemCode(Integer.parseInt(itemCodeText));
            item.setItemName(itemNameText);
            item.setItemBrand(itemBrandText);
            item.setItemPrice((int) Double.parseDouble(itemPriceText));
            item.setItemQuantity(Integer.parseInt(itemQuantityText));
            item.setItemCategory(itemCategoryText);
            item.setItemPurchasedDate(itemPurchasedDateText);
            item.addItemsToHashMap();
            item.saveHashMapToTextFile();
        } else {
            // Show alert message and mark invalid fields with red border
            if (!isItemCodeValid) {
                checkingInvalidInput(itemAddingTextfield);
            }
            if (!isItemQuantityValid) {
                checkingInvalidInput(itemAddingTextfield1);
            }
            if (!isItemPriceValid) {
                checkingInvalidInput(itemAddingTextfield2);
            }
            if (!checkingValidString(itemNameText)) {
                checkingInvalidInput(itemAddingTextfield3);
            }
            if (!checkingValidString(itemBrandText)) {
                checkingInvalidInput(itemAddingTextfield4);
            }
            if (!checkingValidString(itemCategoryText)) {
                checkingInvalidInput(itemAddingTextfield6);
            }

            // Display the alert message
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Please check the input");
            alert.setContentText("Some fields have invalid input. Please correct them and try again.");
            alert.showAndWait();
        }
        // Clear the text fields
        itemAddingTextfield.setText("");
        itemAddingTextfield1.setText("");
        itemAddingTextfield2.setText("");
        itemAddingTextfield3.setText("");
        itemAddingTextfield4.setText("");
        itemAddingTextfield6.setText("");
        itemAddingTextfield7.setValue(null);
    }

// Helper methods for input validation

    private boolean checkingValidPositiveInteger(String input) {
        try {
            int value = Integer.parseInt(input);
            return value > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean checkingValidDouble(String input) {
        try {
            double value = Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean checkingValidString(String input) {
        return !input.trim().isEmpty() && input.matches("[a-zA-Z]+") ;
    }

    private void checkingInvalidInput(TextField textField) {
        textField.setStyle("-fx-border-color: red;");
    }


    @FXML
    public void onDeleteButtonInDeleteItemDetails(ActionEvent actionEvent) {
        String itemCodeText = deleteTextField4.getText();

        // Check if the user input is a valid integer
        try {
            int itemCode = Integer.parseInt(itemCodeText);

            // Call the method to delete item details
            boolean deleted = item.deleteItemDetails(String.valueOf(itemCode));

            if (deleted) {
                // Show a success alert if the item was deleted successfully
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Item Deletion");
                alert.setHeaderText(null);
                alert.setContentText("Item deleted successfully.");
                alert.showAndWait();
            } else {
                // Show an alert if the item code was not found in the hashmap
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Alert");
                alert.setHeaderText(null);
                alert.setContentText("Item deleted successfully.");
                alert.showAndWait();
            }
        } catch (NumberFormatException e) {
            // Show an alert for invalid integer input
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please input a valid item code (integer).");
            alert.showAndWait();
            redLineDelete();

            // Set the border of the text field to red

        }
        deleteTextField4.setText("");

    }
    public void redLineDelete(){
        deleteTextField4.setStyle("-fx-border-color: red;");
    }




    private HashMap<Integer, HashMap<String, String>> itemDetailsHashMap;

    @FXML
    public void searchButtonInUpdateClick(ActionEvent actionEvent) {
        item.searchForUpdateDetails(gettingTheItemCodeInUpdate.getText(), itemUpdatingTextfield, itemUpdatingTextfield1,
                itemUpdatingTextfield2, itemUpdatingTextfield6, itemUpdatingTextfield4, itemUpdatingTextfield3, purchasingDateInUpdate);
    }




    @FXML
    public void saveDetailsInUpdateItemClick() {
        item.updateData(gettingTheItemCodeInUpdate.getText(), itemUpdatingTextfield, itemUpdatingTextfield1,
                itemUpdatingTextfield2, itemUpdatingTextfield6, itemUpdatingTextfield4, itemUpdatingTextfield3, purchasingDateInUpdate);

        gettingTheItemCodeInUpdate.setText("");
        itemUpdatingTextfield.setText("");
        itemUpdatingTextfield1.setText("");
        itemUpdatingTextfield2.setText("");
        itemUpdatingTextfield3.setText("");
        itemUpdatingTextfield4.setText("");
        itemUpdatingTextfield6.setText("");
        purchasingDateInUpdate.setValue(null);

    }
    public void initialize(ActionEvent event) {


    }


    public void showItemsButtonClick(){
        populateTableView();
    }
    private void populateTableView() {
        ArrayList<HashMap<String, String>> data = inventory.readData();

        int n = data.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                int itemCode1 = Integer.parseInt(data.get(j).get("itemCode"));
                int itemCode2 = Integer.parseInt(data.get(minIndex).get("itemCode"));
                if (itemCode1 < itemCode2) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                HashMap<String, String> temp = data.get(i);
                data.set(i, data.get(minIndex));
                data.set(minIndex, temp);
            }
        }
        // Bind columns to HashMap keys
        itemBrandIdInView.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("itemBrand")));
        itemCategoryIdInView.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("itemCategory")));
        itemCodeIdInView.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("itemCode")));
        itemNameIdInView.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("itemName")));
        itemPriceIdInView.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("itemPrice")));
        itemPurchasedDateIdInView.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("itemPurchasedDate")));
        itemQuantityIdInView.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("itemQuantity")));
        imageViewInView.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("itemImage")));
        imageViewInView.setCellFactory(column -> new TableCell<>() {
            private final ImageView imageView = new ImageView();

            @Override
            protected void updateItem(String imagePath, boolean empty) {
                super.updateItem(imagePath, empty);

                if (empty || imagePath == null) {
                    setGraphic(null);
                } else {
                    // Load the image and set it in the ImageView
                    Image image = new Image(new File(imagePath).toURI().toString());
                    imageView.setImage(image);
                    imageView.setFitHeight(80); // Set the desired height of the image
                    imageView.setFitWidth(80);  // Set the desired width of the image
                    setGraphic(imageView);
                }
         }});


        // Add data to the table view
        System.out.println(data);

        // Add data to the table view
        ObservableList<HashMap<String, String>> observableDataList = FXCollections.observableArrayList(data);
        viewItemTable.setItems(observableDataList);
    }

    public void backButtonInselectingRandomDealersClick() {
    }


    public void DispalyDealerDetails() {
        displayDealerDetails();
    }



    public void DealerDetailsButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader dashboardLoader = new FXMLLoader(getClass().getResource("dealerItemDetails.fxml"));

        Parent root = dashboardLoader.load();

        Scene dashboardPage = new Scene(root);

        Stage previousStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        previousStage.setScene(dashboardPage);

    }

    public void exitForMainManuButtonClick(ActionEvent actionEvent) throws IOException{
        FXMLLoader dashboardLoader = new FXMLLoader(getClass().getResource("mainpage.fxml"));

        Parent root = dashboardLoader.load();

        Scene dashboardPage = new Scene(root);

        Stage previousStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        previousStage.setScene(dashboardPage);
    }



    public void addImageButtonInAddItemsClick(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));

        // Show open file dialog
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            try {
                // Copy the selected image to a known directory (e.g., the working directory)
                File destination = new File(selectedFile.getName());
                Files.copy(selectedFile.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);

                // Display the image in the ImageView
                Image image = new Image(destination.toURI().toString());
                ImageView imageView;
                imageViewInAddImageInAdditemdetails.setImage(image);


                // Save the image file path in your HashMap
                addingItemDetailsMap.put("itemImage", destination.getAbsolutePath());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void addItemImageInUpdateClick(ActionEvent actionEvent) {
        FileChooser file = new FileChooser();
        file.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));

        // Show open file dialog
        File selectedFile = file.showOpenDialog(null);

        if (selectedFile != null) {
            try {
                // Copy the selected image to a known directory (e.g., the working directory)
                File destination = new File(selectedFile.getName());
                Files.copy(selectedFile.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);

                // Display the image in the ImageView
                Image image = new Image(destination.toURI().toString());
                ImageView imageView;
                ImageViewInUpdate.setImage(image);


                // Save the image file path in your HashMap
                addingItemDetailsMap.put("itemImage", destination.getAbsolutePath());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void onClickPopulateButton(ActionEvent actionEvent) {
    }
}






