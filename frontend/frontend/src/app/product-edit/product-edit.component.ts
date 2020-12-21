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
  id: string = '';
  code: String = '';
  productForm: FormGroup;
  description: String = '';
  department: String;
  price: number = null;
  status: boolean = true;

  isLoadingResults = false;
  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private api: ApiService,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit(): void {
    this.getProduct(this.route.snapshot.params['id']);
    this.productForm = this.formBuilder.group({
      id: '',
      code: [null, Validators.required],
      description: [null, Validators.required],
      price: [null, Validators.required],
      status: [null, Validators.required],
    });
  }

  getProduct(id) {
    this.api.getProduct(id).subscribe((data) => {
      this.id = data.id;
      this.productForm.setValue({
        id: data.id,
        code: data.code,
        description: data.description,
        price: data.price,
        status: data.status,
      });
    });
  }

  updateProduct(form: NgForm) {
    this.isLoadingResults = true;
    this.api.updateProduct(this.id, form).subscribe(
      (res) => {
        this.isLoadingResults = false;
        this.router.navigate(['/product-details/' + this.id]);
      },
      (err) => {
        console.log(err);
        this.isLoadingResults = false;
      }
    );
  }
}
