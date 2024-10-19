/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelocqrs.Infrastructure.Repositories;

import java.util.ArrayList;
import java.util.List;
import modelocqrs.Business.Interfaces.Repositories.IProductRepository;
import modelocqrs.Domain.Model.Product;

/**
 *
 * @author Breiner
 */
public class ProductRepository implements IProductRepository {
    private static List<Product> productsBd;

    public ProductRepository() {
        createProductsBd();
    }
    
    private void createProductsBd(){
        if(productsBd == null){
            productsBd = new ArrayList<>();
        }
    }

    @Override
    public Product findProductById(int productId) throws Exception {
        if(productsBd.isEmpty()){
            throw new Exception("El producto "+productId+" no existe");
        }
        Product productFound =null;
        for(Product p : productsBd){
            if(p.getId() == productId){
                productFound = p;
                break;
            }
        }
        if(productFound == null){
            throw new Exception("El producto "+productId+" no existe");
        }
        return productFound;
    }

    @Override
    public Product findProductByName(String name) throws Exception {
        if(productsBd.isEmpty()){
            throw new Exception("El producto "+name+" no existe");
        }
        Product productFound =null;
        for(Product p : productsBd){
            if(p.getName().equalsIgnoreCase(name)){
                productFound = p;
                break;
            }
        }
        if(productFound == null){
            throw new Exception("El producto "+name+" no existe");
        }
        return productFound;
    }

    @Override
    public int saveProduct(Product product) throws Exception {
        
        if(product == null){
            throw new Exception("El producto es requerido");
        }
        try{
            Product productFound = findProductByName(product.getName());
            throw new Exception ("El producto "+product.getName()+" ya existe");
        }catch (Exception error){
            productsBd.add(product);
        }
        
        return productsBd.size();
    }

    @Override
    public void editProduct(Product product) throws Exception {
         if (product == null) {
        throw new Exception("El producto no puede ser nulo.");
    }
    
    // Buscar producto por ID
    Product productFound = findProductById(product.getId());

    if (productFound == null) {
        throw new Exception("El producto con ID " + product.getId() + " no existe.");
    }
    
    // Actualizar producto en la base de datos simulada
    productFound.setName(product.getName());
    productFound.setPrice(product.getPrice());
    }

    @Override
    public int deleteProduct(int productId) throws Exception {
       Product productFound = findProductById(productId);
    if (productFound == null) {
        throw new Exception("El producto con ID " + productId + " no existe.");
    }

    productsBd.remove(productFound); // Eliminar el producto de la lista
    return productsBd.size();
    }

    @Override
    public List<Product> getProductAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
