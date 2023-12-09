import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
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

    TextField cinField;
    TextField nomField;
    TextField prenomField;

    VBox v;
    GridPane root;
    ToggleGroup toggleGroup; // Added ToggleGroup

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

            cinField = new TextField();
            nomField = new TextField();
            prenomField = new TextField();

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

            root.add(civiliteLabel, 0, 3);
            root.add(v, 1, 3);

            root.add(ajout, 0, 4);
            root.add(annuler, 1, 4);

            Scene scene = new Scene(root, 200, 200);

            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {

        }

    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == ajout) {
            System.out.println("Ajouter button clicked");
            // Add your logic for handling "Ajouter" button click here
        } else if (event.getSource() == annuler) {
            System.out.println("Annuler button clicked");
            // Add your logic for handling "Annuler" button click here
        }

    }

}