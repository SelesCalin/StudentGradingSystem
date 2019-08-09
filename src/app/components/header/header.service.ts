import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HeaderService {
  private isAuthenticated: boolean=false;
  private logoutUrl='http://localhost:8080/logout';
  constructor(private http:HttpClient) { }

  setAuthenticated(isAuthenticated: boolean){ 
    this.isAuthenticated=isAuthenticated;
  }

  getAuthenticated(){ 
    return this.isAuthenticated;
  }

  logout(){ 
    let headers: HttpHeaders=new HttpHeaders();
    headers=headers.append("token",window.localStorage.getItem('token'));
    return this.http.post(this.logoutUrl,{},{headers:headers});
  }
}
