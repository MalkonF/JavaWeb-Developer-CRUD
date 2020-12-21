import { Product } from '../model/product';
import { Component, OnInit } from '@angular/core';

import { ApiService } from '../service/api.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css'],
})
export class ProductsComponent implements OnInit {
  displayedColumns: string[] = [
    'id',
    'code',
    'description',
    'department',
    'price',
    'status',
    'acao'
  ];
  dataSource: Product[];
  isLoadingResults = false;
  constructor(private api: ApiService) {}

  ngOnInit(): void {
    
    this.api.getProducts().subscribe(
      (res) => {
        this.dataSource = res;
        console.log(this.dataSource);
        this.isLoadingResults = false;
      },
      (err) => {
        console.log(err);
        this.isLoadingResults = false;
      }
    );
  }
}
