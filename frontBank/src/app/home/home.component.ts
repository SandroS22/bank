import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent {
  saldo: number = 0.00;

  deposit() {
    this.saldo += 1.51;
  }
}
