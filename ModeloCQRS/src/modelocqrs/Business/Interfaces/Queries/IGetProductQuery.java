/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelocqrs.Business.Interfaces.Queries;

import modelocqrs.Domain.Model.Product;

/**
 *
 * @author Breiner
 */
public interface IGetProductQuery {
    public Product GetProduct(int productId) throws Exception;
    public Product GetProduct(String productName) throws Exception;
}
