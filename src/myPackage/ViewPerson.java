package myPackage;

import javafx.beans.binding.Bindings;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class ViewPerson {
    private Person person;
    private GridPane grid;
    Text status;
    Text name;
  //Label age;

    private void createPane(){
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        name = new Text(person.getName());
        name.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        name.textProperty().bind(person.nameStringProperty());

        GridPane.setHalignment(name, HPos.CENTER);
        grid.add(name, 0, 0, 2, 1);


        status = new Text(person.getStatus());
        status.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        status.textProperty().bind(person.statusStringProperty());
        GridPane.setHalignment(name, HPos.CENTER);

   grid.add(status, 1, 2);
//        age = new Label();
//        age.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
//        age.textProperty().bind(person.ageProperty().asString());
//        grid.add(age, 1, 3);


    }
    public  GridPane getPane(){
        return  grid;
    }

    public void setPerson (Person person) {
        this.person = person;
        name.textProperty().bind(this.person.nameStringProperty());
        status.textProperty().bind(this.person.statusStringProperty());
    //   age.textProperty().bind(this.person.ageProperty().asString());

    }
    public ViewPerson(Person person) {
        this.person = person;
        createPane();
    }}