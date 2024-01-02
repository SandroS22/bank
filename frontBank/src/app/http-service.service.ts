import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class HttpService {
  private url = 'http://localhost:8080/api/register';

  constructor(private http: HttpClient) {}

  getName(): Observable<any> {
    return this.http.get(this.url);
  }
}
