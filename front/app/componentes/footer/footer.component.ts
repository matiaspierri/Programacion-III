import { Component } from '@angular/core';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent {

  contador:number;

  constructor() {
    this.contador = 0;
  }

  clickBoton() {
    this.contador++;
  }
}
