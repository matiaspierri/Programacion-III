import { Injectable } from '@angular/core';
import { Bank } from '../model/Bank';
import { Observable, of } from 'rxjs';
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class BankService {
  
  

  banks: Bank[] = []

  constructor(private api:ApiService) {
   }

   getAllBanks(): Observable<Bank[]> {
    return this.api.getAllBanks();
   }

   getBankByName(name: string): Bank | undefined {
    return this.api.getBankByName(name);
  }

  createBank(name: string, address: string) : Observable<Bank>  {
    let newBank: Bank = new Bank(name, address)
    return this.api.createBank(newBank);
  }

  deleteBank(bank: Bank): Observable<Bank>{
    return this.api.deleteBank(bank);
  }
}
