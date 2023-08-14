import { Injectable } from '@angular/core';
import { ApiService } from './api.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  private _endpointCart = '/cart';

  constructor(private _apiService: ApiService) { }

  //GET
  public get(): Observable<any> {
    return this._apiService.get(this._endpointCart);
  }

  //POST
  public postBurger(body: Object): Observable<any> {
    return this._apiService.post(`${this._endpointCart}/add/burger`, body);
  }

  public postDrink(body: Object): Observable<any> {
    return this._apiService.post(`${this._endpointCart}/add/drink`, body);
  }

  //PUT
  public putMoreQuantity(body: Object): Observable<any> {
    return this._apiService.put(`${this._endpointCart}/moreQuantity`, body);
  }

  public putLessQuantity(body: Object): Observable<any> {
    return this._apiService.put(`${this._endpointCart}/lessQuantity`, body);
  }

  //DELETE
  public deleteItem(id: number): Observable<any> {
    return this._apiService.delete(`${this._endpointCart}/${id}`);
  }

  public deleteAll(): Observable<any> {
    return this._apiService.delete(`${this._endpointCart}/deleteAll`);
  }
}
