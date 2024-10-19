/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelocqrs.Business.Handlers.Commands;

import modelocqrs.Business.Interfaces.Commands.IEditProductCommand;
import modelocqrs.Business.Interfaces.Repositories.IProductRepository;
import modelocqrs.Domain.Model.Product;

/**
 *
 * @author Breiner
 */
public class EditProductCommandHandler implements IEditProductCommand{
    private IProductRepository productRepository;

    public EditProductCommandHandler(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void editProduct(Product product) throws Exception {
         if (product == null) {
            throw new Exception("El producto no puede ser nulo.");
        }

        // Buscar el producto por ID
        Product productFound = productRepository.findProductById(product.getId());
        if (productFound == null) {
            throw new Exception("El producto con ID " + product.getId() + " no existe.");
        }

        Product productWithSameName = null;

        try {
            // Intentar encontrar otro producto con el mismo nombre
            productWithSameName = productRepository.findProductByName(product.getName());
        } catch (Exception e) {
            // Si la excepción se lanza, significa que no existe un producto con ese nombre, lo cual está bien
            productWithSameName = null;
        }

        // Verificar que el producto con el nuevo nombre no sea otro
        if (productWithSameName != null && productWithSameName.getId() != product.getId()) {
            throw new Exception("El nombre del producto " + product.getName() + " ya existe.");
        }

        // Actualizar los datos del producto
        productFound.setName(product.getName());
        productFound.setPrice(product.getPrice());

        // Guardar cambios
        productRepository.editProduct(productFound);
    }
}
