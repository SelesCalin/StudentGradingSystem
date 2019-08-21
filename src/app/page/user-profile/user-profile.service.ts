import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Profile } from './profile';
import { getUrlScheme } from '@angular/compiler';


@Injectable({
  providedIn: 'root'
})
export class UserProfileService {

  constructor(private http: HttpClient) { }


  

  getProfile(role: number) {
  
    var url=this.getUrlForRole(role);
    console.log(window.localStorage.getItem('token'));
    let headers1: HttpHeaders = new HttpHeaders();
    var headers = new HttpHeaders().set("token", window.localStorage.getItem('token'));
    return this.http.get<Profile>(url, { headers: headers });
  }

  getUrlForRole(role: number){
    var baseUrl = 'http://localhost:8080/'
    switch(role){ 
    
      case 0: {
        baseUrl = baseUrl.concat("admin/profile");
        break;
      }
      case 1: { 
        baseUrl=baseUrl.concat("teacher/profile");
        break;
      }
      
      case 2:{ 
        baseUrl=baseUrl.concat("student/profile");
        break;
      }
  }
  return baseUrl;
}
}
