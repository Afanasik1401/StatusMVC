package myPackage;
import javafx.beans.property.*;

public class Person {
    private StringProperty name;

    public StringProperty nameStringProperty() {
        if (name == null) {
            name = new SimpleStringProperty();
        }
        return name;
    }
    public final void setName(String value) {
        nameStringProperty().set(value);
    }
    public final String getName() {
        return nameStringProperty().get();
    }


    private IntegerProperty age;
    public IntegerProperty ageProperty() {
        if (age == null) {
            age = new SimpleIntegerProperty();
        }
        return age;
    }

    public final void setAge(Integer value) {
        ageProperty().set(value);
    }

    public final Integer getAge() {
        return ageProperty().get();
    }

    public Person(String name, int age){
        setName(name);
        setAge(age);
        if((age>=0)&&(age<=11)) setStatus("детство");
        if((age>=12)&&(age<=19)) setStatus("юность");
        if((age>=20)&&(age<=35)) setStatus("молодость");
        if(age>=36) setStatus("зрелость");
    }
    private StringProperty status;
    public StringProperty statusStringProperty() {
        if (status == null) {
            status = new SimpleStringProperty();
        }
        return status;
    }
    public final void setStatus(String value) {
        statusStringProperty().set(value);
    }
    public final String getStatus() {
        return statusStringProperty().get();
    }
    }