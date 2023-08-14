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
  totalPrice!: number;

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
      },
      complete: () => {
        this.calculateTotalPrice();
      }
    });
  }
  
  public lessQuantity(id: number) {
    const body = { idCart: id, };

    this._cartService.putLessQuantity(body).subscribe({
      next: () => { this.ngOnInit() },
      error: (error) => { console.error(error); }
    });
  }

  public moreQuantity(id: number) {
    const body = { idCart: id, };

    this._cartService.putMoreQuantity(body).subscribe({
      next: () => { this.ngOnInit() },
      error: (error) => { console.error(error); }
    });
  }

  private calculateTotalPrice() {
    this.totalPrice = 0;
    this.cart.forEach((product) => {
      this.totalPrice = Math.floor((this.totalPrice + product.total) * 100) / 100;
    })
  }

  deleteItem(id: number) {
    this._cartService.deleteItem(id).subscribe({
      error: (error) => { console.error(error); },
      complete: () => { this.ngOnInit(); }
    });
  }

  deleteAll() {
    this._cartService.deleteAll().subscribe({
      error: (error) => { console.error(error); },
      complete: () => { this.ngOnInit(); }
    });
  }
}
