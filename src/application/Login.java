package application;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.sqlite.SQLiteDataSource;

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
	Database db;
	static GridPane root;
	
	
	public Login(Stage stage, Database db) {
		this.stage = stage;
		this.db = db;
		initialize();

	}
	
	private void initialize() {
		try {			
			Connection con = Database.dbconnect();
			if(con != null) {
				System.out.println("Yay!");
			}
			else {
				System.out.println("oH NO...");
			}
			root = new GridPane();

			Scene scene = new Scene(root,400, 300);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setResizable(false);
			stage.setScene(scene);
			stage.show();
			stage.setTitle("Login");
			
			TextField userNameTF = new TextField();
			userNameTF.setPromptText("Username");
			TextField passwordTF = new TextField();
			passwordTF.setPromptText("Password");
			Button submitButton = new Button("Submit");
			
			submitButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent arg0) {
					try {
						Statement statement = con.createStatement();
						String query = "select * from Employee where username = '" + userNameTF.getText() + "' and password = '"+ passwordTF.getText() +"'";
						
						ResultSet resultSet = statement.executeQuery(query);
						
						if(resultSet.next()) {
							if(!resultSet.next()) {
								System.out.println("Got it!");
							}else {
								System.out.println("Multiple rows found");
							}
						}
						else {
							System.out.println("No row found");
						}
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
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

