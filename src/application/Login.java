package application;

import java.io.FileInputStream;

import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Login extends javafx.scene.Node{
	Stage stage;
	static GridPane root;

	public Login(Stage stage) {
		this.stage = stage;
		
		initialize();

	}
	
	private void initialize() {
		try {			
			root = new GridPane();

			Scene scene = new Scene(root,400, 300);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setResizable(false);
			stage.setScene(scene);
			stage.show();
			stage.setTitle("Login");
			
			TextField userNameTF = new TextField("Username");
			TextField passwordTF = new TextField("Password");
			Button submitButton = new Button("Submit");
			
			submitButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent arg0) {

					
				}
				
			});
			
			ImageView image = new ImageView(new Image(new FileInputStream("img/logo.png")));
			image.setFitWidth(300);
			image.setFitHeight(150);
			root.add(image,0,0);
			root.addRow(1, new Label("Username: "), userNameTF);
			root.addRow(2, new Label("Password: "), passwordTF);
			root.addRow(3, submitButton);
			GridPane.setHalignment(submitButton, HPos.CENTER);
			GridPane.setHalignment(image, HPos.CENTER);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
