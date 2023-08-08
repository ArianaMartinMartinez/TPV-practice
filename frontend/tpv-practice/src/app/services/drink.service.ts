import { Injectable } from '@angular/core';
import { ApiService } from './api.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DrinkService {

  private _endpointDrink = '/drinks';

  constructor(private _apiService: ApiService) { }

  //GET
  public get(): Observable<any> {
    return this._apiService.get(this._endpointDrink);
  }
}
