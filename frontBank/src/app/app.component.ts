import { Component } from '@angular/core';
import { HttpService } from './http-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'frontBank';
  userName: any = 'user';
  constructor(private httpService: HttpService) {}

  ngOnInit() {
    this.httpService.getName().subscribe(
      (response) => {
        this.userName = response[0];
      },
      (error) => {
        console.log(error);
      }
    );
  }
}
