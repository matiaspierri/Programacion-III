import { Injectable } from '@angular/core';
import { ApiService } from './api.service';
import { Card } from '../model/Card';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CardService {

  constructor(private apiService:ApiService) { 

  }

  getCardsOfUser(): Observable<Card[]> {
    return this.apiService.getCardsOfUser();
  }


}
