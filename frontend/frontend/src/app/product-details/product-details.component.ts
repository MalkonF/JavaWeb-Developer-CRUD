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
    id: '',
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
    this.getProduct(this.route.snapshot.params['id']);
    console.log();
  }

  getProduct(id) {
    this.api.getProduct(id).subscribe((data) => {
      console.log(id);
      this.product = data;
      console.log(this.product);
      this.isLoadingResults = false;
    });
  }

  deleteProduct(id) {
    this.isLoadingResults = true;
    this.api.deleteProduct(id).subscribe(
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
