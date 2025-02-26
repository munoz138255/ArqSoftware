package com.example.materialdesign;

public class Employee {
    public String objectId;
    public String Name;
    public String Surname;
    public String complete;
    public Employee(String name, String surname){
        Name = name;
        Surname = surname;
    }
    @Override
    public String toString() {

        if(Name == "" && Surname == ""){
            complete = "-"+" "+"-";
        } else if (Surname == "") {
            complete = Name+" "+"-";
        } else if (Name == "") {
            complete = "-"+" "+Surname;
        }else if(Name != "" && Surname != ""){
            complete = Name+" "+Surname;
        }
        return complete;
//toDo
    }
}
