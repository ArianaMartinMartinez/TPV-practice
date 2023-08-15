import { Injectable } from '@angular/core';
import { ApiService } from './api.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BurgerService {

  private _endpointBurger = '/burgers';

  constructor(private _apiService: ApiService) { }

  //GET
  public get(): Observable<any> {
    return this._apiService.get(this._endpointBurger);
  }

  public getById(id: number): Observable<any> {
    return this._apiService.get(`${this._endpointBurger}/${id}`);
  }
}
