/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import model.Person;
import model.PersonListWrapper;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import static main.Main.stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author user
 */
public class FXMLDocumentController implements Initializable {
    ////////////////////////////////////////////////////////////

    @FXML
    private TextField field1;
    @FXML
    private TextField field2;
    @FXML
    private TextField field3;
    @FXML
    private TextField field4;
    @FXML
    private TextField field5;

    @FXML
    private CheckBox field6;
    @FXML
    private CheckBox field7;

    @FXML
    private ComboBox field8;
    @FXML
    private ComboBox field9;
    @FXML
    private ComboBox field10;

    @FXML
    private TextField field11;
    @FXML
    private TextField field12;
    @FXML
    private TextField field13;
    @FXML
    private TextField field14;

    @FXML
    private CheckBox field15;
    @FXML
    private CheckBox field16;
    @FXML
    private CheckBox field17;
    @FXML
    private CheckBox field18;

    @FXML
    private TextField field19;
    @FXML
    private TextField field20;

    @FXML
    private ComboBox field21;
    @FXML
    private ComboBox field22;
    @FXML
    private ComboBox field23;

    @FXML
    private TextField field24;

    @FXML
    private ComboBox field25;
    @FXML
    private ComboBox field26;
    @FXML
    private ComboBox field27;

    @FXML
    private CheckBox field28;
    @FXML
    private CheckBox field29;
    @FXML
    private CheckBox field30;
    @FXML
    private CheckBox field31;
    @FXML
    private CheckBox field32;
    @FXML
    private CheckBox field33;
    @FXML
    private CheckBox field34;
    @FXML
    private CheckBox field35;
    @FXML
    private CheckBox field36;
    @FXML
    private CheckBox field37;

    @FXML
    private TextField field38;

    @FXML
    private CheckBox field39;

    @FXML
    private TextField field40;

    @FXML
    private CheckBox field41;

    @FXML
    private TextField field42;

    @FXML
    private CheckBox field43;
    @FXML
    private CheckBox field44;
    @FXML
    private CheckBox field45;
    @FXML
    private CheckBox field46;
    @FXML
    private CheckBox field47;
    @FXML
    private CheckBox field48;

    @FXML
    private TextField field49;
    @FXML
    private TextField field50;
    @FXML
    private TextField field51;
    @FXML
    private TextField field52;
    @FXML
    private TextField field53;
    @FXML
    private TextField field54;
    @FXML
    private TextField field55;

    @FXML
    private TextField field56;
    @FXML
    private TextField field57;
    @FXML
    private TextField field58;
    @FXML
    private TextField field59;
    @FXML
    private TextField field60;
    @FXML
    private TextField field61;
    @FXML
    private TextField field62;
    @FXML
    private TextField field63;
    @FXML
    private TextField field64;
    @FXML
    private TextField field65;
    @FXML
    private TextField field66;
    @FXML
    private TextField field67;
    @FXML
    private TextField field68;
    @FXML
    private TextField field69;
    @FXML
    private TextField field70;
    @FXML
    private TextField field71;
    @FXML
    private TextField field72;
    @FXML
    private TextField field73;
    @FXML
    private TextField field74;
    @FXML
    private TextField field75;
    @FXML
    private TextField field76;
    @FXML
    private TextField field77;

    @FXML
    private CheckBox field78;

    @FXML
    private CheckBox field79;
    @FXML
    private CheckBox field80;
    @FXML
    private CheckBox field81;
    @FXML
    private CheckBox field82;
    @FXML
    private CheckBox field83;
    @FXML
    private CheckBox field84;
    @FXML
    private CheckBox field85;
    @FXML
    private CheckBox field86;
    @FXML
    private CheckBox field87;
    @FXML
    private CheckBox field88;
    @FXML
    private CheckBox field89;
    @FXML
    private CheckBox field90;
    @FXML
    private CheckBox field91;
    @FXML
    private CheckBox field92;
    @FXML
    private CheckBox field93;
    @FXML
    private CheckBox field94;
    @FXML
    private CheckBox field95;
    @FXML
    private CheckBox field96;
    @FXML
    private CheckBox field97;

    @FXML
    private TextField field98;

    @FXML
    private CheckBox field99;
    @FXML
    private CheckBox field100;
    @FXML
    private CheckBox field101;
    @FXML
    private CheckBox field102;
    @FXML
    private CheckBox field103;

    @FXML
    private TextField field104;
    @FXML
    private CheckBox field105;
    @FXML
    private TextField field106;

    @FXML
    private ComboBox field107;
    @FXML
    private ComboBox field108;
    @FXML
    private ComboBox field109;

    @FXML
    private TextField field110;

    @FXML
    private ComboBox field111;
    @FXML
    private ComboBox field112;
    @FXML
    private ComboBox field113;

    @FXML
    private TextField field114;

    @FXML
    private ComboBox field115;
    @FXML
    private ComboBox field116;
    @FXML
    private ComboBox field117;

    @FXML
    private TextField field118;

    @FXML
    private ComboBox field119;
    @FXML
    private ComboBox field120;
    @FXML
    private ComboBox field121;

    @FXML
    private TextField field122;

    @FXML
    private ComboBox field123;
    @FXML
    private ComboBox field124;
    @FXML
    private ComboBox field125;

    @FXML
    private TextField field126;
    @FXML
    private TextField field127;
    @FXML
    private TextField field128;

    @FXML
    private TextField field129;
    @FXML
    private TextField field130;
    @FXML
    private TextField field131;
    @FXML
    private TextField field132;
    @FXML
    private TextField field133;

    @FXML
    private CheckBox field134;
    @FXML
    private CheckBox field135;
    @FXML
    private CheckBox field136;
    @FXML
    private CheckBox field137;
    @FXML
    private CheckBox field138;
    @FXML
    private CheckBox field139;
    @FXML
    private CheckBox field140;
    @FXML
    private CheckBox field141;
    @FXML
    private CheckBox field142;
    @FXML
    private CheckBox field143;
    @FXML
    private CheckBox field144;
    @FXML
    private TextArea field145; //3.6
    @FXML
    private TextArea field146; //3.7
    @FXML
    private TextField field147; //fio1
    @FXML
    private TextField field148; //fio2
    @FXML
    private TextField field149; //fio3
    @FXML
    private TextField field150; //pol
    @FXML
    private TextField field151; //pol
    @FXML
    private TextField field152; //pol
    //date birtday
    @FXML
    private ComboBox field153;
    @FXML
    private ComboBox field154;
    @FXML
    private ComboBox field155;
    @FXML
    private ComboBox field156;
    @FXML
    private ComboBox field157;
    @FXML
    private ComboBox field158;
    @FXML
    private ComboBox field159;
    @FXML
    private ComboBox field160;
    @FXML
    private ComboBox field161;
    @FXML
    private TextField field162; //5.1
    @FXML
    private TextField field163; //5.2
    @FXML
    private TextField field164; //5.3
    @FXML
    private TextField field165; //5.4
    @FXML
    private CheckBox field166; //1.22a
    @FXML
    private CheckBox field167; //1.22b
    @FXML
    private CheckBox field168; //1.22c
    @FXML
    private TextField field169; //1.22d
    @FXML
    private ComboBox field170;//2.4
    @FXML
    private ComboBox field171;//2.4
    @FXML
    private ComboBox field172;//2.4
    @FXML
    private CheckBox field173; //1.22c
    @FXML
    private TextField field174; //1.22d
////////////////////////////////////////////////////////////

    @FXML
    AnchorPane root;

    //private ResourceBundle bundle;
    @FXML
    private ImageView boxImage;

    @FXML
    private ObservableList<Person> personData = FXCollections
            .observableArrayList();

    @FXML
    private MenuBar menuBar;

    @FXML
    private void changeLocale(ActionEvent event) throws IOException {
        Scene scene = root.getScene();
    }

    /**
     * Saves the file to the person file that is currently open. If there is no
     * open file, the "save as" dialog is shown.
     */
    @FXML
    private void handleSave() {
        File personFile = getPersonFilePath();
        if (personFile != null) {
            savePersonDataToFile(personFile);
        } else {
            handleSaveAs();
        }
    }

    /**
     * Saves the file to the person file that is currently open. If there is no
     * open file, the "save as" dialog is shown.
     */
    @FXML
    private void handlePDF() {
        if (personData != null) {
            ItextPDF pdf = new ItextPDF();
            //pdf.deleteFile("show.pdf");
            dataToDTO();
            Person person = personData.get(0);
            java.util.Date date= new java.util.Date();
            String fileName = String.valueOf(date.getTime());
            fileName = fileName+".pdf";
            pdf.createPdf(fileName, person);
            openPDF(fileName);
        }
    }

    public File getPersonFilePath() {
        Preferences prefs = Preferences.userNodeForPackage(Main.class);
        String filePath = prefs.get("filePath", null);
        if (filePath != null) {
            return new File(filePath);
        } else {
            return null;
        }
    }

    public void savePersonDataToFile(File file) {
        dataToDTO();
        try {
            JAXBContext context = JAXBContext
                    .newInstance(PersonListWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Wrapping our person data.
            PersonListWrapper wrapper = new PersonListWrapper();
            wrapper.setPersons(personData);

            // Marshalling and saving XML to the file.
            m.marshal(wrapper, file);

            // Save the file path to the registry.
            setPersonFilePath(file);
        } catch (Exception e) { // catches ANY exception
			/*Dialogs.create().title("Error")
             .masthead("Could not save data to file:\n" + file.getPath())
             .showException(e);*/
        }
    }

    public void dataToDTO(){
        Person person = new Person(field1.getText(), field2.getText(), field3.getText(),
                field4.getText(), field5.getText(),
                (field6.isSelected() ? field6.getText() : ""),
                (field7.isSelected() ? field7.getText() : ""),
                (field8.getValue() != null ? field8.getValue().toString() : ""),
                (field9.getValue() != null ? field9.getValue().toString() : ""),
                (field10.getValue() != null ? field10.getValue().toString() : ""),
                field11.getText(), field12.getText(), field13.getText(), field14.getText(),
                (field15.isSelected() ? field15.getText() : ""),
                (field16.isSelected() ? field16.getText() : ""),
                (field17.isSelected() ? field17.getText() : ""),
                (field18.isSelected() ? field18.getText() : ""),
                field19.getText(), field20.getText(),
                (field21.getValue() != null ? field21.getValue().toString() : ""),
                (field22.getValue() != null ? field22.getValue().toString() : ""),
                (field23.getValue() != null ? field23.getValue().toString() : ""),
                field24.getText(),
                (field25.getValue() != null ? field25.getValue().toString() : ""),
                (field26.getValue() != null ? field26.getValue().toString() : ""),
                (field27.getValue() != null ? field27.getValue().toString() : ""),
                (field28.isSelected() ? field28.getText() : ""),
                (field29.isSelected() ? field29.getText() : ""),
                (field30.isSelected() ? field30.getText() : ""),
                (field31.isSelected() ? field31.getText() : ""),
                (field32.isSelected() ? field32.getText() : ""),
                (field33.isSelected() ? field33.getText() : ""),
                (field34.isSelected() ? field34.getText() : ""),
                (field35.isSelected() ? field35.getText() : ""),
                (field36.isSelected() ? field36.getText() : ""),
                (field37.isSelected() ? field37.getText() : ""),
                field38.getText(),
                (field39.isSelected() ? field39.getText() : ""),
                field40.getText(),
                (field41.isSelected() ? field41.getText() : ""),
                field42.getText(),
                (field43.isSelected() ? field43.getText() : ""),
                (field44.isSelected() ? field44.getText() : ""),
                (field45.isSelected() ? field45.getText() : ""),
                (field46.isSelected() ? field46.getText() : ""),
                (field47.isSelected() ? field47.getText() : ""),
                (field48.isSelected() ? field48.getText() : ""),
                field49.getText(), field50.getText(),
                field51.getText(), field52.getText(), field53.getText(), field54.getText(), field55.getText(),
                field56.getText(), field57.getText(), field58.getText(), field59.getText(), field60.getText(),
                field61.getText(), field62.getText(), field63.getText(), field64.getText(), field65.getText(),
                field66.getText(), field67.getText(), field68.getText(), field69.getText(), field70.getText(),
                field71.getText(), field72.getText(), field73.getText(), field74.getText(), field75.getText(),
                field76.getText(), field77.getText(),
                (field78.isSelected() ? field78.getText() : ""),
                (field79.isSelected() ? field79.getText() : ""),
                (field80.isSelected() ? field80.getText() : ""),
                (field81.isSelected() ? field81.getText() : ""),
                (field82.isSelected() ? field82.getText() : ""),
                (field83.isSelected() ? field83.getText() : ""),
                (field84.isSelected() ? field84.getText() : ""),
                (field85.isSelected() ? field85.getText() : ""),
                (field86.isSelected() ? field86.getText() : ""),
                (field87.isSelected() ? field87.getText() : ""),
                (field88.isSelected() ? field88.getText() : ""),
                (field89.isSelected() ? field89.getText() : ""),
                (field90.isSelected() ? field90.getText() : ""),
                (field91.isSelected() ? field91.getText() : ""),
                (field92.isSelected() ? field92.getText() : ""),
                (field93.isSelected() ? field93.getText() : ""),
                (field94.isSelected() ? field94.getText() : ""),
                (field95.isSelected() ? field95.getText() : ""),
                (field96.isSelected() ? field96.getText() : ""),
                (field97.isSelected() ? field97.getText() : ""),
                field98.getText(),
                (field99.isSelected() ? field99.getText() : ""),
                (field100.isSelected() ? field100.getText() : ""),
                (field101.isSelected() ? field101.getText() : ""),
                (field102.isSelected() ? field102.getText() : ""),
                (field103.isSelected() ? field103.getText() : ""),
                field104.getText(), 
                (field105.isSelected() ? field105.getText() : ""),
                field106.getText(),
                (field107.getValue() != null ? field107.getValue().toString() : ""),
                (field108.getValue() != null ? field108.getValue().toString() : ""),
                (field109.getValue() != null ? field109.getValue().toString() : ""),
                field110.getText(),
                (field111.getValue() != null ? field111.getValue().toString() : ""),
                (field112.getValue() != null ? field112.getValue().toString() : ""),
                (field113.getValue() != null ? field113.getValue().toString() : ""),
                field114.getText(),
                (field115.getValue() != null ? field115.getValue().toString() : ""),
                (field116.getValue() != null ? field116.getValue().toString() : ""),
                (field117.getValue() != null ? field117.getValue().toString() : ""),
                field118.getText(),
                (field119.getValue() != null ? field119.getValue().toString() : ""),
                (field120.getValue() != null ? field120.getValue().toString() : ""),
                (field121.getValue() != null ? field121.getValue().toString() : ""),
                field122.getText(),
                (field123.getValue() != null ? field123.getValue().toString() : ""),
                (field124.getValue() != null ? field124.getValue().toString() : ""),
                (field125.getValue() != null ? field125.getValue().toString() : ""),
                field126.getText(), field127.getText(), field128.getText(), field129.getText(), field130.getText(),
                field131.getText(), field132.getText(), field133.getText(),
                (field134.isSelected() ? field134.getText() : ""),
                (field135.isSelected() ? field135.getText() : ""),
                (field136.isSelected() ? field136.getText() : ""),
                (field137.isSelected() ? field137.getText() : ""),
                (field138.isSelected() ? field138.getText() : ""),
                (field139.isSelected() ? field139.getText() : ""),
                (field140.isSelected() ? field140.getText() : ""),
                (field141.isSelected() ? field141.getText() : ""),
                (field142.isSelected() ? field142.getText() : ""),
                (field143.isSelected() ? field143.getText() : ""),
                (field144.isSelected() ? field144.getText() : ""),
                field145.getText(),
                field146.getText(),
                field147.getText(),
                field148.getText(),
                field149.getText(),
                field150.getText(),
                field151.getText(),
                field152.getText(),
                
                (field153.getValue() != null ? field153.getValue().toString() : ""),
                (field154.getValue() != null ? field154.getValue().toString() : ""),
                (field155.getValue() != null ? field155.getValue().toString() : ""),
                
                (field156.getValue() != null ? field156.getValue().toString() : ""),
                (field157.getValue() != null ? field157.getValue().toString() : ""),
                (field158.getValue() != null ? field158.getValue().toString() : ""),
                
                (field159.getValue() != null ? field159.getValue().toString() : ""),
                (field160.getValue() != null ? field160.getValue().toString() : ""),
                (field161.getValue() != null ? field161.getValue().toString() : ""),
                
                
                field162.getText(),
                field163.getText(),
                field164.getText(),
                field165.getText(),
                (field166.isSelected() ? field166.getText() : ""),
                (field167.isSelected() ? field167.getText() : ""),
                (field168.isSelected() ? field168.getText() : ""),
                field169.getText(),
                
                (field170.getValue() != null ? field170.getValue().toString() : ""),
                (field171.getValue() != null ? field171.getValue().toString() : ""),
                (field172.getValue() != null ? field172.getValue().toString() : ""),
                (field173.isSelected() ? field168.getText() : ""),
                field174.getText()
        );

        personData.clear();
        personData.add(person);
    }
    /**
     * Sets the file path of the currently loaded file. The path is persisted in
     * the OS specific registry.
     *
     * @param file the file or null to remove the path
     */
    public void setPersonFilePath(File file) {
        Preferences prefs = Preferences.userNodeForPackage(Main.class);
        if (file != null) {
            prefs.put("filePath", file.getPath());

            // Update the stage title.
            stage.setTitle("AddressApp - " + file.getName());
        } else {
            prefs.remove("filePath");

            // Update the stage title.
            stage.setTitle("AddressApp");
        }
    }

    /**
     * Opens a FileChooser to let the user select a file to save to.
     */
    @FXML
    private void handleSaveAs() {
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

		// Show save file dialog
        //Stage stage = (Stage) root.getScene().getWindow();
        File file = fileChooser.showSaveDialog(stage);

        if (file != null) {
            // Make sure it has the correct extension
            if (!file.getPath().endsWith(".xml")) {
                file = new File(file.getPath() + ".xml");
            }
            savePersonDataToFile(file);
        }
    }

    /**
     * Handle action related to "About" menu item.
     *
     * @param event Event on "About" menu item.
     */
    @FXML
    private void handleImageClickAction(final ActionEvent event) {

        //provideAboutFunctionality();
    }

    @FXML
    private void handleRussian(final ActionEvent event) throws IOException {
      
        Main.setLocale(new Locale("zh", "CN")); // change to english
        //JavaFXApplication4.stage.close();
        Main reload = new Main();
        reload.reload();
    }

    @FXML
    private void handleChinese(final ActionEvent event) throws IOException {
        /* System.out.println("You clicked me handleChinese!");
         loadView(Locale.GERMANY);
         */

        /*MenuItem menuItem = (MenuItem) event.getSource();
         Scene scene = menuItem.getParentPopup().getScene();

         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
         fxmlLoader.setResources(ResourceBundle.getBundle("bundles.lang", Locale.ENGLISH));
        
         Parent root = fxmlLoader.load();
        
         scene.setRoot(root);*/
        Main.setLocale(new Locale("de", "DE")); // change to english
        Main reload = new Main();
        reload.reload();
    }

    /**
     * Handle action related to input (in this case specifically only responds
     * to keyboard event CTRL-A).
     *
     * @param event Input event.
     */
    @FXML
    private void handleKeyInput(final InputEvent event) {
        if (event instanceof KeyEvent) {
            final KeyEvent keyEvent = (KeyEvent) event;
            if (keyEvent.isControlDown() && keyEvent.getCode() == KeyCode.A) {
                provideAboutFunctionality();
            }
        }
    }

    /**
     * Perform functionality associated with "About" menu selection or CTRL-A.
     */
    private void provideAboutFunctionality() {

    }

    private void loadView(Locale locale) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setResources(ResourceBundle.getBundle("bundles.lang", locale));
            Parent pane1 = (Parent) fxmlLoader.load(this.getClass().getResource("FXMLDocument.fxml").openStream());
            // replace the content
            Stage stage = (Stage) root.getScene().getWindow();
            if (stage == null) {
                System.out.print("dfdfdfd");
            } else {
//javafx.scene.layout.AnchorPane cannot be cast to javafx.scene.layout.BorderPane
                AnchorPane content = (AnchorPane) ((VBox) stage.getScene().getRoot()).getChildren().get(1);
                content.getChildren().clear();
            }
            //content.getChildren().add(pane);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Creates an empty address book.
     */
    @FXML
    private void handleNew() {
        personData.clear();
        DTOtoData();
        setPersonFilePath(null);
    }

    /**
     * Opens a FileChooser to let the user select an address book to load.
     */
    @FXML
    private void handleOpen() {
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show save file dialog
        File file = fileChooser.showOpenDialog(stage);

        if (file != null) {
            loadPersonDataFromFile(file);
        }
    }

    /**
     * Loads person data from the specified file. The current person data will
     * be replaced.
     *
     * @param file
     */
    public void loadPersonDataFromFile(File file) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(PersonListWrapper.class);
            Unmarshaller um = context.createUnmarshaller();

            // Reading XML from the file and unmarshalling.
            PersonListWrapper wrapper = (PersonListWrapper) um.unmarshal(file);
personData.clear();
            personData.addAll(wrapper.getPersons());
            DTOtoData();
            // Save the file path to the registry.
            setPersonFilePath(file);

        } catch (Exception e) { // catches ANY exception

        }
    }

    private void DTOtoData(){
        
            for (Person item : personData) {
                field1.setText(item.getField1());
                field2.setText(item.getField2());
                field3.setText(item.getField3());
                field4.setText(item.getField4());
                field5.setText(item.getField5());
                field6.setSelected((item.getField6().equals("") ? false : true));
                field7.setSelected((item.getField7().equals("") ? false : true));
                field8.setValue(item.getField8());
                field9.setValue(item.getField9());
                field10.setValue(item.getField10());
                field11.setText(item.getField11());
                field12.setText(item.getField12());
                field13.setText(item.getField13());
                field14.setText(item.getField14());
                field15.setSelected((item.getField15().equals("") ? false : true));
                field16.setSelected((item.getField16().equals("") ? false : true));
                field17.setSelected((item.getField17().equals("") ? false : true));
                field18.setSelected((item.getField18().equals("") ? false : true));
                field19.setText(item.getField19());
                field20.setText(item.getField20());
                field21.setValue(item.getField21());
                field22.setValue(item.getField22());
                field23.setValue(item.getField23());
                field24.setText(item.getField24());
                field25.setValue(item.getField25());
                field26.setValue(item.getField26());
                field27.setValue(item.getField27());
                field28.setSelected((item.getField28().equals("") ? false : true));
                field29.setSelected((item.getField29().equals("") ? false : true));
                field30.setSelected((item.getField30().equals("") ? false : true));
                field31.setSelected((item.getField31().equals("") ? false : true));
                field32.setSelected((item.getField32().equals("") ? false : true));
                field33.setSelected((item.getField33().equals("") ? false : true));
                field34.setSelected((item.getField34().equals("") ? false : true));
                field35.setSelected((item.getField35().equals("") ? false : true));
                field36.setSelected((item.getField36().equals("") ? false : true));
                field37.setSelected((item.getField37().equals("") ? false : true));
                field38.setText(item.getField38());
                field39.setSelected((item.getField39().equals("") ? false : true));
                field40.setText(item.getField40());
                field41.setSelected((item.getField41().equals("") ? false : true));
                field42.setText(item.getField42());
                field43.setSelected((item.getField43().equals("") ? false : true));
                field44.setSelected((item.getField44().equals("") ? false : true));
                field45.setSelected((item.getField45().equals("") ? false : true));
                field46.setSelected((item.getField46().equals("") ? false : true));
                field47.setSelected((item.getField47().equals("") ? false : true));
                field48.setSelected((item.getField48().equals("") ? false : true));
                field49.setText(item.getField49());
                field50.setText(item.getField50());
                field51.setText(item.getField51());
                field52.setText(item.getField52());
                field53.setText(item.getField53());
                field54.setText(item.getField54());
                field55.setText(item.getField55());

                field56.setText(item.getField56());
                field57.setText(item.getField57());
                field58.setText(item.getField58());
                field59.setText(item.getField59());
                field60.setText(item.getField60());
                field61.setText(item.getField61());
                field62.setText(item.getField62());
                field63.setText(item.getField63());
                field64.setText(item.getField64());
                field65.setText(item.getField65());
                field66.setText(item.getField66());
                field67.setText(item.getField67());
                field68.setText(item.getField68());
                field69.setText(item.getField69());
                field70.setText(item.getField70());
                field71.setText(item.getField71());
                field72.setText(item.getField72());
                field73.setText(item.getField73());
                field74.setText(item.getField74());
                field75.setText(item.getField75());
                field76.setText(item.getField76());
                field77.setText(item.getField77());
                field78.setSelected((item.getField78().equals("") ? false : true));
                field79.setSelected((item.getField79().equals("") ? false : true));
                field80.setSelected((item.getField80().equals("") ? false : true));
                field81.setSelected((item.getField81().equals("") ? false : true));
                field82.setSelected((item.getField82().equals("") ? false : true));
                field83.setSelected((item.getField83().equals("") ? false : true));
                field84.setSelected((item.getField84().equals("") ? false : true));
                field85.setSelected((item.getField85().equals("") ? false : true));
                field86.setSelected((item.getField86().equals("") ? false : true));
                field87.setSelected((item.getField87().equals("") ? false : true));
                field88.setSelected((item.getField88().equals("") ? false : true));
                field89.setSelected((item.getField89().equals("") ? false : true));
                field90.setSelected((item.getField90().equals("") ? false : true));
                field91.setSelected((item.getField91().equals("") ? false : true));
                field92.setSelected((item.getField92().equals("") ? false : true));
                field93.setSelected((item.getField93().equals("") ? false : true));
                field94.setSelected((item.getField94().equals("") ? false : true));
                field95.setSelected((item.getField95().equals("") ? false : true));
                field96.setSelected((item.getField96().equals("") ? false : true));
                field97.setSelected((item.getField97().equals("") ? false : true));
                field98.setText(item.getField98());
                field99.setSelected((item.getField99().equals("") ? false : true));
                field100.setSelected((item.getField100().equals("") ? false : true));
                field101.setSelected((item.getField101().equals("") ? false : true));
                field102.setSelected((item.getField102().equals("") ? false : true));
                field103.setSelected((item.getField103().equals("") ? false : true));
                field104.setText(item.getField104());
                field105.setSelected((item.getField105().equals("") ? false : true));
                field106.setText(item.getField106());

                field107.setValue(item.getField107());
                field108.setValue(item.getField108());
                field109.setValue(item.getField109());

                field110.setText(item.getField110());

                field111.setValue(item.getField111());
                field112.setValue(item.getField112());
                field113.setValue(item.getField113());

                field114.setText(item.getField114());

                field115.setValue(item.getField115());
                field116.setValue(item.getField116());
                field117.setValue(item.getField117());

                field118.setText(item.getField118());

                field119.setValue(item.getField119());
                field120.setValue(item.getField120());
                field121.setValue(item.getField121());

                field122.setText(item.getField122());

                field123.setValue(item.getField123());
                field124.setValue(item.getField124());
                field125.setValue(item.getField125());

                field126.setText(item.getField126());
                field127.setText(item.getField127());
                field128.setText(item.getField128());
                field129.setText(item.getField129());
                field130.setText(item.getField130());
                field131.setText(item.getField131());
                field132.setText(item.getField132());
                field133.setText(item.getField133());

                field134.setSelected((item.getField134().equals("") ? false : true));
                field135.setSelected((item.getField135().equals("") ? false : true));
                field136.setSelected((item.getField136().equals("") ? false : true));
                field137.setSelected((item.getField137().equals("") ? false : true));
                field138.setSelected((item.getField138().equals("") ? false : true));
                field139.setSelected((item.getField139().equals("") ? false : true));
                field140.setSelected((item.getField140().equals("") ? false : true));
                field141.setSelected((item.getField141().equals("") ? false : true));
                field142.setSelected((item.getField142().equals("") ? false : true));
                field143.setSelected((item.getField143().equals("") ? false : true));
                field144.setSelected((item.getField144().equals("") ? false : true));
                
                field145.setText(item.getField145());
                field146.setText(item.getField146());
                field147.setText(item.getField147());
                field148.setText(item.getField148());
                field149.setText(item.getField149());
                field150.setText(item.getField150());
                field151.setText(item.getField151());
                field152.setText(item.getField152());
                
                field153.setValue(item.getField153());
                field154.setValue(item.getField154());
                field155.setValue(item.getField155());
                
                field156.setValue(item.getField156());
                field157.setValue(item.getField157());
                field158.setValue(item.getField158());
                field159.setValue(item.getField159());
                field160.setValue(item.getField160());
                field161.setValue(item.getField161());
                field162.setText(item.getField162());
                field163.setText(item.getField163());
                field164.setText(item.getField164());
                field165.setText(item.getField165());
                field166.setSelected((item.getField166().equals("") ? false : true));
                field167.setSelected((item.getField167().equals("") ? false : true));
                field168.setSelected((item.getField168().equals("") ? false : true));
                field169.setText(item.getField169());
                field170.setValue(item.getField170());
                field171.setValue(item.getField171());
                field172.setValue(item.getField172());
                
                field173.setSelected((item.getField173().equals("") ? false : true));
                field174.setText(item.getField174());

            }
    }
    /**
     * Closes the application.
     */
    @FXML
    private void handleExit() {
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //bundle = resources;
        menuBar.setFocusTraversable(true);
        //lblTextByController.setText(bundle.getString("lastname"));
        boxImage.setOnMouseClicked((event) -> {//Lambda Expression define method which has event parameter.
            openBrowse();
        });
        initComboBox();
    }

    private void initComboBox() {
        //days
        List<Integer> dayGDList = new ArrayList<Integer>();
        for (int d = 1; d <= 31; d++) {
            dayGDList.add(d);
        }
        field8.getItems().addAll(dayGDList);
        field21.getItems().addAll(dayGDList);
        field25.getItems().addAll(dayGDList);
        field107.getItems().addAll(dayGDList);
        field111.getItems().addAll(dayGDList);
        field115.getItems().addAll(dayGDList);
        field119.getItems().addAll(dayGDList);
        field123.getItems().addAll(dayGDList);
        field153.getItems().addAll(dayGDList);
        field156.getItems().addAll(dayGDList);
        field159.getItems().addAll(dayGDList);
        field170.getItems().addAll(dayGDList);
        //month
        //String[] monthStrings = (new DateFormatSymbols()).getMonths();
        List<Integer> monthStrings = new ArrayList<Integer>();
        for (int d = 1; d <= 12; d++) {
            monthStrings.add(d);
        }
        field9.getItems().addAll(monthStrings);
        field22.getItems().addAll(monthStrings);
        field26.getItems().addAll(monthStrings);
        field108.getItems().addAll(monthStrings);
        field112.getItems().addAll(monthStrings);
        field116.getItems().addAll(monthStrings);
        field120.getItems().addAll(monthStrings);
        field124.getItems().addAll(monthStrings);
        field154.getItems().addAll(monthStrings);
        field157.getItems().addAll(monthStrings);
        field160.getItems().addAll(monthStrings);
        field171.getItems().addAll(monthStrings);
        //year
        List<Integer> yearBList = new ArrayList<Integer>();
        int year = Calendar.getInstance().get(Calendar.YEAR);
        for (int d = year; d >= 1900; d--) {
            yearBList.add(d);
        }
        field10.getItems().addAll(yearBList);
        field23.getItems().addAll(yearBList);
        field27.getItems().addAll(yearBList);

        field109.getItems().addAll(yearBList);
        field113.getItems().addAll(yearBList);
        field117.getItems().addAll(yearBList);
        field121.getItems().addAll(yearBList);
        field125.getItems().addAll(yearBList);
        field155.getItems().addAll(yearBList);
        field158.getItems().addAll(yearBList);
        field161.getItems().addAll(yearBList);
        field172.getItems().addAll(yearBList);
        //

    }

    private void openBrowse() {
        try {
            URI u = new URI("http://www.developer.am");
            java.awt.Desktop.getDesktop().browse(u);
        } catch (Exception ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void openPDF(String filename) {
        try {

            if ((new File(filename)).exists()) {

                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler " + filename);
                p.waitFor();

            } else {

                //System.out.println("File is not exists");

            }

            //System.out.println("Done");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
