import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class MainScreen extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("IP Address Finder");

        Label urlLabel = new Label("Enter URL:");
        TextField urlTextField = new TextField();
        Button findIpButton = new Button("Find IP");

        findIpButton.setOnAction(e -> {
            String url = urlTextField.getText();
            try {
                InetAddress inetAddress = InetAddress.getByName(url);
                String ip = inetAddress.getHostAddress();
                displayResult(ip);
            } catch (UnknownHostException ex) {
                displayResult("Invalid URL or Unable to find IP address.");
            }
        });

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(urlLabel, urlTextField, findIpButton);

        Scene scene = new Scene(vbox, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void displayResult(String message) {
        Stage dialogStage = new Stage();
        dialogStage.setTitle("IP Address Result");
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        Label label = new Label(message);
        vbox.getChildren().add(label);
        Scene scene = new Scene(vbox, 250, 100);
        dialogStage.setScene(scene);
        dialogStage.show();
    }
}
