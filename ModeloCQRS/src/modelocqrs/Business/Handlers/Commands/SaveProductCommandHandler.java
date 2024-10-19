/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelocqrs.Business.Handlers.Commands;

import modelocqrs.Business.Interfaces.Commands.ISaveProductCommand;
import modelocqrs.Business.Interfaces.Repositories.IProductRepository;
import modelocqrs.Domain.Model.Product;

/**
 *
 * @author Breiner
 */
public class SaveProductCommandHandler implements ISaveProductCommand {
    private IProductRepository productRepository;
    
    public SaveProductCommandHandler(IProductRepository prepository){
        productRepository = prepository;
    }

    @Override
    public int createProduct(Product product) throws Exception {
        
        if (product == null) {
            throw new Exception("El producto no puede ser nulo");
        }
        
        if (product.getName() == null || product.getName().isEmpty()) {
            throw new Exception("El nombre del producto es obligatorio");
        }
        if (product.getPrice() <= 0) {
            throw new Exception("El precio debe ser mayor a cero");
        }
        return productRepository.saveProduct(product);
    }
}
