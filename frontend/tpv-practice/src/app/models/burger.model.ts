import { Ingredient } from "./ingredient.model";

export class Burger {
    id!: number;
    name!: string;
    price!: number;
    photo!: string;
    ingredients!: Ingredient[];
}