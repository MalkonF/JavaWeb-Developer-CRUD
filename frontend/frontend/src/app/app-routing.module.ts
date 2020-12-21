import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductsComponent } from './products/products.component';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { ProductNewComponent } from './product-new/product-new.component';
import { ProductEditComponent } from './product-edit/product-edit.component';
import { LoginComponent } from './login/login.component';
import { MenuComponent } from './menu/menu.component';

const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent,
    data: { title: 'Login' },
  },
  {
    path: 'menu',
    component: MenuComponent,
    data: { title: 'Menu' },
  },
  {
    path: 'products',
    component: ProductsComponent,
    data: { title: 'Lista de Produtos' },
  },
  {
    path: 'product-details/:id',
    component: ProductDetailsComponent,
    data: { title: 'Detalhe do Produto' },
  },
  {
    path: 'product-new',
    component: ProductNewComponent,
    data: { title: 'Adicionar Produto' },
  },
  {
    path: 'product-edit/:id',
    component: ProductEditComponent,
    data: { title: 'Editar o Produto' },
  },
  { path: '', redirectTo: '/login', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { relativeLinkResolution: 'legacy' })],
  exports: [RouterModule],
})
export class AppRoutingModule {}
