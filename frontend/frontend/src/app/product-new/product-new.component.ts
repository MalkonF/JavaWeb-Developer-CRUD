import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { ApiService } from '../service/api.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-product-new',
  templateUrl: './product-new.component.html',
  styleUrls: ['./product-new.component.css'],
})
export class ProductNewComponent implements OnInit {
  productForm: FormGroup;
  isLoadingResults = false;
  constructor(
    private router: Router,
    private api: ApiService,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit(): void {
    this.productForm = this.formBuilder.group({
      code: [null, Validators.required],
      description: [null, [Validators.required, Validators.minLength(4)]],
      department: [null, [Validators.required]],
      price: [null, Validators.required],
      status: [null, Validators.required],
    });
  }
  addProduto(form: NgForm) {
    this.isLoadingResults = true;
    this.api.addProduct(form).subscribe(
      (res) => {
        //const id = res['_id'];
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
