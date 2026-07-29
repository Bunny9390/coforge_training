import { Component } from '@angular/core';

@Component({
  selector: 'app-product',
  standalone: false,
  templateUrl: './product.html',
  styleUrl: './product.css',
})
export class Product {
  ProductName: string;
  Price: number;
  Category: string;
  Brand: string;
  imgPath: string;
  width: number;
  height: number;
  constructor() {
    this.ProductName = "Laptop";
    this.Price = 100000;
    this.Category = "Electronics";
    this.Brand = "Dell";
    this.imgPath = "laptop.jpg";
    this.width = 200;
    this.height = 200;
  }

}
