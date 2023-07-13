import { Injectable } from '@angular/core';
import { Bank } from '../model/Bank';
import { Card } from '../model/Card';
import { User } from '../model/User';
import { BankService } from './bank.service';
import { Observable } from 'rxjs';
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private apiService: ApiService) {} 

  getUserInfo(): Observable<User> { 
    return this.apiService.getUserInfo();
  }

}
