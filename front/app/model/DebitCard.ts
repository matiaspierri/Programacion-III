import { Bank } from "./Bank";
import { Card } from "./Card";

export class DebitCard extends Card {
    pin?: number;
  
    constructor(
      name: string,
      number: string,
      expiryDate: string,
      totalSpent: number,
      bank: Bank,
      pin: number
    ) {
      super(name, number, expiryDate, totalSpent, bank);
      this.pin = pin;
    }
  }