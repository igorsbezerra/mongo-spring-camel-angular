import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Product } from "src/app/model/Product";
import { TableService } from "./table.service";

@Component({
  selector: "app-table",
  templateUrl: "./table.component.html",
  styleUrls: ["./table.component.css"],
})
export class TableComponent implements OnInit {
  products: Product[] = [];

  constructor(private service: TableService, private router: Router) {}

  ngOnInit(): void {
    this.getAll();
  }

  getAll(): void {
    this.service.getAll().subscribe((response) => {
      response.forEach((item) => this.products.push(item));
    });
  }

  comeBack(): void {
    this.router.navigate(["create"]);
  }
}
