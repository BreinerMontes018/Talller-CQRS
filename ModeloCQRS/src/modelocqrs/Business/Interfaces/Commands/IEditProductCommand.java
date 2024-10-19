/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelocqrs.Business.Interfaces.Commands;

import modelocqrs.Domain.Model.Product;

/**
 *
 * @author Breiner
 */
public interface IEditProductCommand {
    void editProduct(Product product) throws Exception;
}
