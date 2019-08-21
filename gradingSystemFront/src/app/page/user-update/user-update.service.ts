import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UserDetailsUpdate } from './user-details-update';

@Injectable({
  providedIn: 'root'
})
export class UserUpdateService {

  constructor(private http: HttpClient) { }


  getDetails(id:number){ 
    var url=`http://localhost:8080/admin/user/${id}`;
    var headers= new HttpHeaders().set("token",window.localStorage.getItem('token'));
    return this.http.get<UserDetailsUpdate>(url,{headers:headers});
  }

  update(id:number,username:string,adresa:string,email:string,grupa:number,role:number,nume:string){ 
    var url=`http://localhost:8080/admin/user/${id}`;
    var headers=new HttpHeaders().set("token",window.localStorage.getItem('token'));
    return this.http.post(url,{username,nume,email,adresa,grupa,role},{headers:headers});
  }
}
