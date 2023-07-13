import { Bank } from "./Bank";

export class Card {
    id?: number
    name?: string
    number?: string
    expiryDate?: string
    totalSpent?: number
    bank?: Bank
    
  
    constructor(name: string, number: string,   expiryDate: string, totalSprent: number, bank: Bank) {
      this.name = name;
      this.number = number;
      this.bank = bank;
      this.totalSpent = totalSprent;
      this.expiryDate = expiryDate;
    }

  }
  