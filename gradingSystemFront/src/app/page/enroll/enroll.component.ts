import { Component, OnInit } from '@angular/core';
import { CourseInfo } from '../user-profile/courseInfo';
import { CourseService } from '../course/course.service';
import { MatTableDataSource } from '@angular/material';
import { Router } from '@angular/router';
@Component({
  selector: 'app-enroll',
  templateUrl: './enroll.component.html',
  styleUrls: ['./enroll.component.css']
})
export class EnrollComponent implements OnInit {
  private courses: MatTableDataSource<CourseInfo>=new MatTableDataSource();
  displayedColumns: string[] = ['id', 'name', 'teacherUsername', 'description','enroll'];

  constructor(private courseService: CourseService,
    private router: Router) { }

  ngOnInit() {
   this.getAllAvailableCourses();
  }


  getAllAvailableCourses(){ 
    this.courseService.getAvailableCourses().subscribe(data=>{console.table(data);this.courses=new MatTableDataSource(data);}, error=>{console.log(error)});
  }

  enroll(enrollmentKey: string, id: number){ 
    this.courseService.enrollStudentTo(enrollmentKey,id).subscribe(data=>{console.log(data),this.router.navigate(['/profile'])},error=>{console.log(error)});
  }
}
