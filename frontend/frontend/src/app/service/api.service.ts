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

  /*getProduct(id: number): Observable<Product> {
    const url = `${apiUrl}/${id}`;
    return this.http.get<Product>(url).pipe(
      tap((_) => console.log(`leu o produto id=${id}`)),
      catchError(this.handleError<Product>(`getProduto id=${id}`))
    );
  }*/

  addProduct(product): Observable<Product> {
    return this.http.post<Product>(apiUrl, product, httpOptions).pipe(
      // tslint:disable-next-line:no-shadowed-variable
      tap((product: Product) =>
        console.log(`adicionou o produto com w/ id=${product.code}`)
      ),
      catchError(this.handleError<Product>('addProduto'))
    );
  }

  updateProduct(id, product): Observable<any> {
    const url = `${apiUrl}/${id}`;
    return this.http.put(url, product, httpOptions).pipe(
      tap((_) => console.log(`atualiza o produco com id=${id}`)),
      catchError(this.handleError<any>('updateProduto'))
    );
  }

  deleteProduct(id): Observable<Product> {
    const url = `${apiUrl}/delete/${id}`;

    return this.http.delete<Product>(url, httpOptions).pipe(
      tap((_) => console.log(`remove o produto com id=${id}`)),
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
