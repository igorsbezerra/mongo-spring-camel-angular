import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { HttpClientModule } from "@angular/common/http";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { TableComponent } from "./components/table/table.component";
import { CreateProductComponent } from "./components/create-product/create-product.component";
import { FormsModule } from "@angular/forms";

@NgModule({
  declarations: [AppComponent, TableComponent, CreateProductComponent],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
