/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelocqrs.Business.Interfaces.Repositories;

import java.util.List;
import modelocqrs.Domain.Model.Product;

/**
 *
 * @author Breiner
 */
public interface IProductRepository {
    public Product findProductById(int productId) throws Exception;
    public Product findProductByName(String name) throws Exception;
    public int saveProduct(Product product) throws Exception;
    public void editProduct(Product product) throws Exception;
    public int deleteProduct(int productId) throws Exception;
    public List<Product> getProductAll() throws Exception;
}
