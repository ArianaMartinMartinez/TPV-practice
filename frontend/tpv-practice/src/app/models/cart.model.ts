import { Burger } from "./burger.model";
import { Drink } from "./drink.model";

export class Cart {
    id!: number;
    quantity!: number;
    size!: string;
    price!: number;
    ivaPrice!: number;
    total!: number;
    burger!: Burger;
    drink!: Drink;
}