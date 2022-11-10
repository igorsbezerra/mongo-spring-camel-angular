import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { CreateProduct } from "src/app/model/CreateProduct";
import { CreateProductService } from "./create-product.service";

@Component({
  selector: "app-create-product",
  templateUrl: "./create-product.component.html",
  styleUrls: ["./create-product.component.css"],
})
export class CreateProductComponent implements OnInit {
  product: CreateProduct = {
    name: "",
    price: 0,
  };

  constructor(private service: CreateProductService, private router: Router) {}

  ngOnInit(): void {}

  create(): void {
    this.service.create(this.product).subscribe(() => {
      this.router.navigate([""]);
    });
  }
}
