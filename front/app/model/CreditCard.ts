import { Bank } from "./Bank";
import { Card } from "./Card";

export class CreditCard extends Card {
    creditLimit?: number;
    interestRate?: number;
  
    constructor(
      name: string,
      number: string,
      expiryDate: string,
      totalSpent: number,
      bank: Bank,
      creditLimit: number,
      interestRate: number
    ) {
      super(name, number, expiryDate, totalSpent, bank);
      this.creditLimit = creditLimit;
      this.interestRate = interestRate;
    }
  }