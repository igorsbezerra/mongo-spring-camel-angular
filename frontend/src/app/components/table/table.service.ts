import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { Product } from "src/app/model/Product";

@Injectable({
  providedIn: "root",
})
export class TableService {
  baseUrl = environment.baseUrl;

  constructor(private http: HttpClient) {}

  getAll(): Observable<Product[]> {
    return this.http.get<Product[]>(this.baseUrl);
  }
}
