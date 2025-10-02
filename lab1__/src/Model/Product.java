/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author barryzhu
 */
public class Product {
    String name;
    String Description;
    String availNum;
    String price;
    
    public Product() {
    manufactureAddress = new Address();
    shippingAddress = new Address();
}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getAvailNum() {
        return availNum;
    }

    public void setAvailNum(String availNum) {
        this.availNum = availNum;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Address getManufactureAddress() {
        return manufactureAddress;
    }

    public void setManufactureAddress(Address manufactureAddress) {
        this.manufactureAddress = manufactureAddress;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
    Address manufactureAddress;
    Address shippingAddress;
    
    //Not Effective!!
    
   // String manufactureStreetName;
   //  String manufactureUnitNumber;
  //    String manufactureCity;
  //     String manufactureZipCode;
       
       
   // String shippingAddressStreetName;
   //  String shippingAddressUnitNumber;
    //  String shippingAddressCity;
    //   String shippingAddressZipCode;
       
           
       
       
       
    
    
    
    
    
}
