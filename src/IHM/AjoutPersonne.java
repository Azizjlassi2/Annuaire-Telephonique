import Models.Personne;
import Models.Telephonne;
import Services.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AjoutPersonne extends Application implements EventHandler<ActionEvent> {

    Button ajout;
    Button annuler;

    RadioButton c1;
    RadioButton c2;
    RadioButton c3;

    Label cinLabel;
    Label nomLabel;
    Label prenomLabel;
    Label civiliteLabel;
    Label telephoneLabel;

    TextField cinField;
    TextField nomField;
    TextField prenomField;
    TextField telephoneField;

    VBox v;
    GridPane root;
    ToggleGroup toggleGroup; // Added ToggleGroup

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {

            ajout = new Button("Ajouter");
            ajout.setOnAction(this);
            annuler = new Button("Annuler");
            annuler.setOnAction(this);

            cinLabel = new Label("CIN");
            nomLabel = new Label("NOM");
            prenomLabel = new Label("PRENOM");
            civiliteLabel = new Label("CIVIIITE");
            telephoneLabel = new Label("Telephone");

            cinField = new TextField();
            nomField = new TextField();
            prenomField = new TextField();
            telephoneField = new TextField();

            c1 = new RadioButton("Monsieur");
            c2 = new RadioButton("Madame");
            c3 = new RadioButton("Mademoiselle");
            toggleGroup = new ToggleGroup(); // Initialize ToggleGroup

            c1.setToggleGroup(toggleGroup);
            c2.setToggleGroup(toggleGroup);
            c3.setToggleGroup(toggleGroup);

            v = new VBox(10);
            v.getChildren().add(c1);
            v.getChildren().add(c2);
            v.getChildren().add(c3);

            root = new GridPane();

            root.add(cinLabel, 0, 0);
            root.add(cinField, 1, 0);

            root.add(nomLabel, 0, 1);
            root.add(nomField, 1, 1);

            root.add(prenomLabel, 0, 2);
            root.add(prenomField, 1, 2);

            root.add(telephoneLabel, 0, 3);
            root.add(prenomField, 1, 3);

            root.add(civiliteLabel, 0, 4);
            root.add(v, 1, 4);

            root.add(ajout, 0, 5);
            root.add(annuler, 1, 5);

            Scene scene = new Scene(root, 300, 300);

            // Appliquer le style CSS
            scene.getStylesheets().add(getClass().getResource("css/style.css").toExternalForm());

            primaryStage.setTitle("Ajouter Personne");
            primaryStage.centerOnScreen();

            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {

        }

    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == ajout) {
            System.out.println("Ajouter button clicked");
            RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();
            if (selectedRadioButton != null) {
                try {
                    int cin = 0;
                    if (cinField.getText().length() == 8) {

                        cin = Integer.parseInt(cinField.getText());
                    } else {
                        showError("CIN doit contenir 8 chiffres");
                    }
                    String nom = nomField.getText();
                    String prenom = prenomField.getText();

                    int telephone = 0;
                    if (telephoneField.getText().length() == 8) {

                        telephone = Integer.parseInt(cinField.getText());
                    } else {
                        showError("Telephonne doit contenir 8 chiffres");
                    }

                    String civilite = selectedRadioButton.getText();

                    // Test
                    System.out.println("Ajouter button clicked with data:");
                    System.out.println("CIN: " + cin);
                    System.out.println("NOM: " + nom);
                    System.out.println("PRENOM: " + prenom);
                    System.out.println("TELEPHONE: " + telephone);

                    System.out.println("CIVILITE: " + civilite);

                    try {
                        // Service
                        PersonneService personneService = new PersonneService();
                        TelephoneService telephoneService = new TelephoneService();

                        Personne existe = personneService.selectionnerPersonne(cin);

                        if (existe == null) {

                            Personne personne = new Personne(cin, nom, prenom, civilite);

                            personneService.ajouterPersonne(personne);
                            Telephonne telephonne = new Telephonne(telephone, cin);
                            telephoneService.ajouterTelephone(personne, telephonne);

                            showAlert("Personne ajouté avec succées");
                        } else {
                            showError("Personne existe déja !");
                        }

                    } catch (java.lang.NullPointerException e) {
                        showError("No Connection");
                    }

                } catch (NumberFormatException e) {
                    showError("Please enter a valid integer for CIN.");
                }
            } else {
                showError("Please select a civilite before clicking Ajouter.");

            }
        } else if (event.getSource() == annuler) {
            System.out.println("Annuler button clicked");
            showAlert("A BIENTOT !");
            Platform.exit();
        }

    }

    private void showError(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
