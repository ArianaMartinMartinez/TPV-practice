import { Component, OnInit } from '@angular/core';
import { Burger } from 'src/app/models/burger.model';
import { Drink } from 'src/app/models/drink.model';
import { BurgerService } from 'src/app/services/burger.service';
import { DrinkService } from 'src/app/services/drink.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit {
  burgers: Burger[] = [];
  drinks: Drink[] = [];

  constructor(
    private _burgerService: BurgerService,
    private _drinkService: DrinkService,
  ) {}

  ngOnInit(): void {
      this.getBurgers();
      this.getDrinks();
  }

  private getBurgers() {
    this._burgerService.get().subscribe({
      next: (rtn) => {
        this.burgers = rtn;
        console.log('Burgers', this.burgers)
      },
      error: (error) => {
        console.error(error);
      }
    })
  }

  private getDrinks() {
    this._drinkService.get().subscribe({
      next: (rtn) => {
        this.drinks = rtn;
        console.log('Drinks', this.drinks)
      },
      error: (error) => {
        console.error(error);
      }
    })
  }
}
