import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ApiService } from '../service/api.service';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css'],
})
export class ProductEditComponent implements OnInit {
  code: String = '';
  productForm: FormGroup;
  description: String = '';
  department: String;
  price: number = null;
  status: Boolean;
  isLoadingResults = false;
  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private api: ApiService,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit(): void {
    this.getProduct(this.route.snapshot.params['code']);
    this.productForm = this.formBuilder.group({
      'code': [null, Validators.required],
      'description': [null, Validators.required],
      'price': [null, Validators.required],
    });
  }

  getProduct(code) {
    this.api.getProduct(code).subscribe((data) => {
      this.code = data.code;
      this.productForm.setValue({
        code: data.code,
        description: data.description,
        price: data.price,
      });
    });
  }

  updateProduct(form: NgForm) {
    this.isLoadingResults = true;
    this.api.updateProduct(this.code, form).subscribe(
      (res) => {
        this.isLoadingResults = false;
        this.router.navigate(['/product-details/' + this.code]);
      },
      (err) => {
        console.log(err);
        this.isLoadingResults = false;
      }
    );
  }
}
