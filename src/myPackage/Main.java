package myPackage;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Main extends Application{ @Override
public void start(Stage primaryStage) {

    primaryStage.setTitle("Simple Model-View Data Binding");
  Person person = new Person("Dasha",19);
    HBox root = new HBox(10);

  ViewPerson viewPer = new ViewPerson(person);
    root.getChildren().add(viewPer.getPane());

    root.getChildren().add(new Separator(Orientation.VERTICAL));

    root.getChildren().add(editBlock(person));

    Scene scene = new Scene(root, 900, 300);
    primaryStage.setScene(scene);
    primaryStage.show();
}
  private VBox editBlock(Person person){
    VBox editPane = new VBox(10);
    editPane.setPadding(new Insets(20));

    Label labelTitle = new Label("Enter name \n and age");
    labelTitle.setFont(Font.font(20));

    TextField editName = new TextField();
    editName.setFont(Font.font(20));
    editName.setPrefSize(150, 40);

    Spinner<Integer> editAge = new Spinner<>(0, 100, 0, 1);
    editAge.setPrefSize(100, 40);
    editAge.setStyle("-fx-font-size: 20");

    Button btn = new Button("Edit");
    btn.setFont(Font.font(20));
    btn.setOnAction((ActionEvent event) -> {
      person.setName(editName.getText());
      person.setAge(editAge.getValue());
      if((editAge.getValue()>=0)&&(editAge.getValue()<=11)) person.setStatus("детство");
      if((editAge.getValue()>=12)&&(editAge.getValue()<=19)) person.setStatus("юность");
      if((editAge.getValue()>=20)&&(editAge.getValue()<=35)) person.setStatus("молодость");
      if(editAge.getValue()>=36) person.setStatus("зрелость");

    });

    editPane.getChildren().addAll(labelTitle, editName, editAge, btn);
    return editPane;
  }
  public static void main(String[] args) {
    launch(args);
  }


}

