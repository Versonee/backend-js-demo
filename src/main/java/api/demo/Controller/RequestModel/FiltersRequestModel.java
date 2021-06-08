package api.demo.Controller.RequestModel;

import api.demo.Model.Product;
import api.demo.Model.Promotion;
import api.demo.Model.Shop;

public class FiltersRequestModel {
    public int available;
    public float price;
    public Shop shop;
    public Product product;
    public Promotion promotion;
    public String sortBy;
}
