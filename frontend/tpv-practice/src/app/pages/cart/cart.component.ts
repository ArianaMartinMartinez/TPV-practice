import { Component, OnInit } from '@angular/core';
import { Cart } from 'src/app/models/cart.model';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {
  cart: Cart[] = [];

  constructor(
    private _cartService: CartService,
  ) {}

  ngOnInit(): void {
      this.getCart();
  }

  private getCart(){
    this._cartService.get().subscribe({
      next: (rtn) => {
        this.cart = rtn;
        console.log('Cart', this.cart);
      },
      error: (error) => {
        console.error(error);
      }
    });
  }
}
