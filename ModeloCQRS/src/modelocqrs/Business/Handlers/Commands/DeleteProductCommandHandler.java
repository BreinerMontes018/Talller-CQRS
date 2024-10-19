/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelocqrs.Business.Handlers.Commands;

import javax.swing.JOptionPane;
import modelocqrs.Business.Interfaces.Commands.IDeleteProductCommand;
import modelocqrs.Business.Interfaces.Repositories.IProductRepository;
import modelocqrs.Domain.Model.Product;

/**
 *
 * @author Breiner
 */
public class DeleteProductCommandHandler implements IDeleteProductCommand{
    private IProductRepository productRepository;

    public DeleteProductCommandHandler(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void deleteProduct(int productId) throws Exception {
        Product productFound = productRepository.findProductById(productId);

        if (productFound == null) {
            throw new Exception("El producto con ID " + productId + " no existe.");
        }

        // Muestro los detalles del producto antes de eliminar
        int confirm = JOptionPane.showConfirmDialog(null, 
            "¿Está seguro de eliminar el producto?\n" +
            "ID: " + productFound.getId() + "\n" +
            "Nombre: " + productFound.getName() + "\n" +
            "Precio: $" + productFound.getPrice(),
            "Confirmar eliminación",
            JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            productRepository.deleteProduct(productId);
            JOptionPane.showMessageDialog(null, "Producto eliminado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Operación cancelada.");
        }
    }
    }

