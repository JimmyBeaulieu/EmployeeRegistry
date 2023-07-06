package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		Login loginPage = new Login(primaryStage);
		loginPage.requestFocus();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
