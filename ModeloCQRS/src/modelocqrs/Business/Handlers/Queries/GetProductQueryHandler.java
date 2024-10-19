/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelocqrs.Business.Handlers.Queries;

import modelocqrs.Business.Interfaces.Queries.IGetProductQuery;
import modelocqrs.Business.Interfaces.Repositories.IProductRepository;
import modelocqrs.Domain.Model.Product;

/**
 *
 * @author Breiner
 */
public class GetProductQueryHandler implements IGetProductQuery{
    private IProductRepository productRepository;
    
    public GetProductQueryHandler(IProductRepository Repository){
        this.productRepository = Repository;
    }

    @Override
    public Product GetProduct(int productId) throws Exception {
        return productRepository.findProductById(productId);
    }

    @Override
    public Product GetProduct(String productName) throws Exception {
       return productRepository.findProductByName(productName);
    }
    
}
