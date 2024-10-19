/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelocqrs.Domain.Model;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Breiner
 */
public class Product {
    private int id;
    private String name;
    private double price;
    
    private static AtomicInteger incrementId;

    public Product() {
       id = getIncrementeId();
    }

    public Product(String name, double price) throws Exception {
        if (name == null || name.trim().isEmpty()) {
            throw new Exception("El nombre es requerido");
        }
        if (price <= 0) {
            throw new Exception("El precio debe ser mayor que cero");
        }
        this.name = name;
        this.price = price;
        id = getIncrementeId();
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    private int getIncrementeId(){
        if(incrementId == null){
            incrementId = new AtomicInteger(0);
        }
        
        return incrementId.incrementAndGet();
    }
    
    
    
    
}
