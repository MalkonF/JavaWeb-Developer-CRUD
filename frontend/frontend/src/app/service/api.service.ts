import { Product } from './../model/product';
import { Injectable } from '@angular/core';
import { Observable, of, throwError } from 'rxjs';
import {
  HttpClient,
  HttpHeaders,
  HttpErrorResponse,
} from '@angular/common/http';
import { catchError, tap, map } from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
};
const apiUrl = 'http://localhost:8080/products';

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  constructor(private http: HttpClient) {}

  getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(apiUrl).pipe(
      tap((products) => console.log('leu os produtos')),
      catchError(this.handleError('getProducts', []))
    );
  }

  getProduct(code: string): Observable<Product> {
    const url = `${apiUrl}/${code}`;
    return this.http.get<Product>(url).pipe(
      tap((_) => console.log(`leu o produto code=${code}`)),
      catchError(this.handleError<Product>(`getProduto code=${code}`))
    );
  }

  addProduct(product): Observable<Product> {
    return this.http.post<Product>(apiUrl, product, httpOptions).pipe(
      tap((product: Product) =>
        console.log(`adicionou o produto com w/ code=${product.code}`)
      ),
      catchError(this.handleError<Product>('addProduto'))
    );
  }

  updateProduct(code, product): Observable<any> {
    const url = `${apiUrl}/${code}`;
    return this.http.put(url, product, httpOptions).pipe(
      tap((_) => console.log(`atualiza o produto com code=${code}`)),
      catchError(this.handleError<any>('updateProduct'))
    );
  }

  deleteProduct(code): Observable<Product> {
    const url = `${apiUrl}/${code}`;

    return this.http.delete<Product>(url, httpOptions).pipe(
      tap((_) => console.log(`remove o produto com code=${code}`)),
      catchError(this.handleError<Product>('deleteProduto'))
    );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);

      return of(result as T);
    };
  }
}
