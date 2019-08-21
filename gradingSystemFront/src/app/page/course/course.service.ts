import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CourseInfoAQ } from './courseInfoAQ';
import { CourseInfo } from '../user-profile/courseInfo';


@Injectable({
  providedIn: 'root'
})
export class CourseService {

  constructor(private http:HttpClient) { }


   getCourse(id: number){ 
      var url=`http://localhost:8080/student/course/${id}`;
      var headers=new HttpHeaders().set("token", window.localStorage.getItem('token'));
      return this.http.get<CourseInfoAQ>(url,{headers:headers});
    }

    deleteCourse(id:number){ 
      var url=`http://localhost:8080/admin/course/${id}`;
      var headers=new HttpHeaders().set("token",window.localStorage.getItem('token'));
      return this.http.delete(url,{headers:headers});
    }

  getAvailableCourses(){ 
    var url='http://localhost:8080/student/course/enroll';
    var headers=new HttpHeaders().set("token",window.localStorage.getItem('token'));
    return this.http.get<CourseInfo[]>(url,{headers:headers});
  }

  enrollStudentTo(enrollmentKey: string, id: number){ 
    var urll='http://localhost:8080/student/course/enroll';
    var headers=new HttpHeaders().set("token", window.localStorage.getItem('token'));
    return this.http.post(urll,{enrollmentKey,id},{headers:headers});

  }


}


