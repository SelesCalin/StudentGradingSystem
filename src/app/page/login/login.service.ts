import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

import { loginuser } from './loginuser';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private loginUrl='http://localhost:8080/login';

  private role: number=-1;
  
  constructor( private http: HttpClient) { }

  login(username: string, password: string):Observable<any> { 

    return this.http.post(this.loginUrl,{username,password});
  }


  setrole(role:number){ 
    this.role=role;
  }

  getrole(){
    return this.role;
  }




}
