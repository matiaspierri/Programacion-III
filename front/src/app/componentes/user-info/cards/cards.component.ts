import { Component, Input, OnInit } from '@angular/core';
import { Card } from 'src/app/model/Card';
import { CardService } from 'src/app/services/card.service';

@Component({
  selector: 'app-cards',
  templateUrl: './cards.component.html',
  styleUrls: ['./cards.component.css']
})
export class CardsComponent implements OnInit {

  cards!: Card[]; 

  search: string = '';

  constructor(private cardService: CardService) {
  }

  ngOnInit(): void {
    this.cardService.getCardsOfUser().subscribe(
      (data) => {
        this.cards = data
      }
    )
  }

  filterCards() {
    console.log(this.search);
  }

}
