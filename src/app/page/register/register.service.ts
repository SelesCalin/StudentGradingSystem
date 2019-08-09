import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  readonly registerUrl='http://localhost:8080/register';

  constructor(private http: HttpClient) {

   }

   register(username: string, password: string, confirmPassword: string, adresa: string, email: string, name:string,role:number,grupa: number): Observable<any>{ 
     return this.http.post(this.registerUrl,{username,password,confirmPassword,name,role,grupa,email,adresa});
   }
}
