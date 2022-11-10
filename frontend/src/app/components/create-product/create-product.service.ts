import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { CreateProduct } from "src/app/model/CreateProduct";
import { Product } from "src/app/model/Product";
import { environment } from "src/environments/environment";

@Injectable({
  providedIn: "root",
})
export class CreateProductService {
  baseUrl = environment.baseUrl;

  constructor(private http: HttpClient) {}

  create(product: CreateProduct): Observable<Product> {
    console.log(product);
    return this.http.post<Product>(this.baseUrl, product);
  }
}
