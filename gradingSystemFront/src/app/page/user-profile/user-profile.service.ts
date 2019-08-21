import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Profile } from './profile';
import {UserInfo} from './user-info';
import { getUrlScheme } from '@angular/compiler';
import { CourseInfo } from './courseInfo';


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

getAllUsers(){ 
  var url='http://localhost:8080/admin/user/allusers'; 
  var headers= new HttpHeaders().set("token", window.localStorage.getItem('token'));
  return this.http.get<UserInfo[]>(url,{headers:headers});
}

getAllCourses(){ 
  var url= 'http://localhost:8080/admin/course/allcourses';
  var headers= new HttpHeaders().set("token", window.localStorage.getItem('token'));
  return this.http.get<CourseInfo[]>(url,{headers:headers});
}


updateStudentName(content: string){ 
  var url= 'http://localhost:8080/student/profile/name';
  var headers=new HttpHeaders().set("token", window.localStorage.getItem('token'));
  return this.http.post(url,{content},{headers:headers});
}

updateStudentEmail(content: string){ 
  var url= 'http://localhost:8080/student/profile/email';
  var headers=new HttpHeaders().set("token", window.localStorage.getItem('token'));
  return this.http.post(url,content,{headers:headers});
}

}
