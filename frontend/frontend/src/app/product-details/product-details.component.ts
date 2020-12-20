import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from '../model/product';
import { ApiService } from '../service/api.service';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css'],
})
export class ProductDetailsComponent implements OnInit {
  product: Product = {
    code: '',
    description: '',
    department: '',
    price: null,
    status: true,
  };
  isLoadingResults = true;
  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private api: ApiService
  ) {}

  ngOnInit() {
    this.getProduct(this.route.snapshot.params['code']);
  }

  getProduct(code) {
    this.api.getProduct(code).subscribe((data) => {
      this.product = data;
      console.log(this.product);
      this.isLoadingResults = false;
    });
  }

  deleteProduct(code) {
    this.isLoadingResults = true;
    this.api.deleteProduct(code).subscribe(
      (res) => {
        this.isLoadingResults = false;
        this.router.navigate(['/products']);
      },
      (err) => {
        console.log(err);
        this.isLoadingResults = false;
      }
    );
  }
}
