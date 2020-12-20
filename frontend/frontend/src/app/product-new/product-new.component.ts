import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { ApiService } from '../service/api.service';

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
      'code': [null, Validators.required],
      'description': [null, [Validators.required, Validators.minLength(4)]],
      'department': [null, [Validators.required]],
     'price': [null, Validators.required],
      'status': [null, Validators.required]
    });
  }
  addProduct(form: NgForm) {
    this.isLoadingResults = true;
    this.api.addProduct(form).subscribe(
      (res) => {
        const code = res['code'];
        this.isLoadingResults = false;
        console.log("debug" + code);
        this.router.navigate(['/product-details', code]);

      },
      (err) => {
        console.log(err);
        this.isLoadingResults = false;
      }
    );
  }
}
