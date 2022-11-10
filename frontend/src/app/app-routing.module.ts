import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { CreateProductComponent } from "./components/create-product/create-product.component";
import { TableComponent } from "./components/table/table.component";

const routes: Routes = [
  {
    path: "",
    component: TableComponent,
  },
  {
    path: "create",
    component: CreateProductComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
