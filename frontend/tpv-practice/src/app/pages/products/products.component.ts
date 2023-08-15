import { Component, OnInit } from '@angular/core';
import { Burger } from 'src/app/models/burger.model';
import { Drink } from 'src/app/models/drink.model';
import { BurgerService } from 'src/app/services/burger.service';
import { CartService } from 'src/app/services/cart.service';
import { DrinkService } from 'src/app/services/drink.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit {
  burgers: Burger[] = [];
  drinks: Drink[] = [];

  private _size: String = "S";

  constructor(
    private _burgerService: BurgerService,
    private _drinkService: DrinkService,
    private _cartService: CartService,
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

  setSize(size: String) {
    this._size = size;
  }

  addBurgerToCart(id: number) {
    this._burgerService.getById(id).subscribe({
      next: (rtn) => {
        if(this._size === 'M') {
          const body = {
            quantity: 1,
            size: this._size,
            price: Math.floor((rtn.price * 1.1) * 100) / 100,
            ivaPrice: Math.floor((rtn.price * 1.1 * 1.21) * 100) / 100,
            idBurger: rtn.id,
          }
          this._cartService.postBurger(body).subscribe({
            next: (rtn) => {
              console.log(rtn);
            },
            error: (error) => {
              console.error(error);
            }
          });

        } else if(this._size === 'L'){
          const body = {
            quantity: 1,
            size: this._size,
            price: Math.floor((rtn.price * 1.2) * 100) / 100,
            ivaPrice: Math.floor((rtn.price * 1.2 * 1.21) * 100) / 100,
            idBurger: rtn.id,
          }
          this._cartService.postBurger(body).subscribe({
            next: (rtn) => {
              console.log(rtn);
            },
            error: (error) => {
              console.error(error);
            }
          });

        } else {
          const body = {
            quantity: 1,
            size: this._size,
            price: rtn.price,
            ivaPrice: Math.floor((rtn.price * 1.21) * 100) / 100,
            idBurger: rtn.id,
          }
          this._cartService.postBurger(body).subscribe({
            next: (rtn) => {
              console.log(rtn);
            },
            error: (error) => {
              console.error(error);
            }
          });
        }

      },
      error: (error) => {
        console.error(error);
      }
    });
  }

  addDrinkToCart(id: number) {
    this._drinkService.getById(id).subscribe({
      next: (rtn) => {
        if(this._size === 'M') {
          const body = {
            quantity: 1,
            size: this._size,
            price: Math.floor((rtn.price * 1.1) * 100) / 100,
            ivaPrice: Math.floor((rtn.price * 1.1 * 1.21) * 100) / 100,
            idDrink: rtn.id,
          }
          this._cartService.postDrink(body).subscribe({
            next: (rtn) => {
              console.log(rtn);
            },
            error: (error) => {
              console.error(error);
            }
          });

        } else if(this._size === 'L'){
          const body = {
            quantity: 1,
            size: this._size,
            price: Math.floor((rtn.price * 1.2) * 100) / 100,
            ivaPrice: Math.floor((rtn.price * 1.2 * 1.21) * 100) / 100,
            idDrink: rtn.id,
          }
          this._cartService.postDrink(body).subscribe({
            next: (rtn) => {
              console.log(rtn);
            },
            error: (error) => {
              console.error(error);
            }
          });

        } else {
          const body = {
            quantity: 1,
            size: this._size,
            price: rtn.price,
            ivaPrice: Math.floor((rtn.price * 1.21) * 100) / 100,
            idDrink: rtn.id,
          }
          this._cartService.postDrink(body).subscribe({
            next: (rtn) => {
              console.log(rtn);
            },
            error: (error) => {
              console.error(error);
            }
          });
        }
      },
      error: (error) => {
        console.error(error);
      }
    });
  }
}
