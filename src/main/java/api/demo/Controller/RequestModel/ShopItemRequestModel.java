package api.demo.Controller.RequestModel;

import api.demo.Model.Product;
import api.demo.Model.Promotion;
import api.demo.Model.Shop;

public class ShopItemRequestModel {
    public float price;
    public int available;
    public Shop shop;
    public Product product;
    public Promotion promotion;
}
