import Models.Personne;
import Models.Telephonne;
import Services.PersonneService;
import Services.TelephoneService;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SupprimerPersonne extends Application implements EventHandler<ActionEvent> {

    Button supprimer;
    Button annuler;

    Label cinLabel;

    TextField cinField;

    GridPane root;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {

            supprimer = new Button("supprimer");
            supprimer.setOnAction(this);
            annuler = new Button("Annuler");
            annuler.setOnAction(this);

            cinLabel = new Label("CIN");

            cinField = new TextField();

            root = new GridPane();

            root.add(cinLabel, 0, 1);
            root.add(cinField, 2, 1);

            root.add(supprimer, 0, 2);
            root.add(annuler, 2, 2);

            Scene scene = new Scene(root, 300, 300);

            // Appliquer le style CSS
            scene.getStylesheets().add(getClass().getResource("css/style.css").toExternalForm());

            primaryStage.setTitle("supprimer Personne");
            primaryStage.centerOnScreen();

            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {

        }

    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == supprimer) {
            System.out.println("supprimer button clicked");

            try {
                int cin = 0;
                if (cinField.getText().length() == 8) {

                    cin = Integer.parseInt(cinField.getText());
                } else {
                    showError("CIN doit contenir 8 chiffre");
                }

                // Test
                System.out.println("supprimer button clicked with data:");
                System.out.println("CIN: " + cin);

                try {
                    PersonneService personneService = new PersonneService();
                    TelephoneService telephoneService = new TelephoneService();

                    Personne personne = personneService.selectionnerPersonne(cin);

                    if (personne == null) {
                        showError("Personne n'existe pas");

                    } else {

                        personneService.supprimerPersonne(personne);
                        telephoneService.supprimerTelephone(cin);
                        showAlert("Personne supprimé avec succées");

                    }

                } catch (java.lang.NullPointerException e) {
                    showError("No Connection");
                }

            } catch (NumberFormatException e) {
                showError("Please enter a valid integer for CIN.");
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
