package com.shantanu.example.androidstorage;

public class Employee {
    int id;
    String name;
    String address;
    String phone_number;

    public Employee(){   }

    public Employee(int id,String name,String address,String phone_number){
        this.id = id;
        this.name = name;
        this.address=address;
        this.phone_number = phone_number;
    }

    public Employee(String name,String address,String phone_number){
        this.name = name;
        this.address=address;
        this.phone_number=phone_number;
    }

    public int getID(){
        return this.id;
    }

    public void setID(int id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getAddress(){
        return this.address;
    }
    public void setAddress(String address){
        this.address=address;
    }

    public String getPhoneNumber(){
        return this.phone_number;
    }

    public void setPhoneNumber(String phone_number){
        this.phone_number = phone_number;
    }
}
