import { Component, OnInit, Injectable, Inject } from '@angular/core';
import { UserProfileService } from './user-profile.service';
import { LoginService } from '../login/login.service';
import { CourseNameId } from './course-name-id';
import { MatIconRegistry } from '@angular/material/icon';

import { DomSanitizer } from '@angular/platform-browser';
import { UserInfo } from './user-info';
import { CourseInfo } from './courseInfo';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { CourseService } from '../course/course.service';
import { CourseInfoAQ } from '../course/courseInfoAQ';
import { Router} from '@angular/router';
import { MatTableDataSource } from '@angular/material';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  displayedColumns: string[] = ['id', 'username', 'nume', 'email', 'adress','update','delete'];
  displayedColumns2: string[] = ['id', 'name', 'teacherUsername', 'description', 'enrollmentKey','update','delete'];
  private searchText: string;
  private username: string = '';
  private role: number = -1;
  private grupa: number = 0;
  private roleString: string = '';
  private courses: CourseNameId[];
  private fullName: string = '';
  private email: string = '';
  private adress: string = '';

  private userInfos: MatTableDataSource<UserInfo>=new MatTableDataSource();
  private courseInfo:  MatTableDataSource<CourseInfo>=new MatTableDataSource();

  private courseAQ: CourseInfoAQ;


  constructor(private userProfileService: UserProfileService,
    private loginService: LoginService,
    private courseService: CourseService,
    private sanitizer: DomSanitizer,
    private iconRegistry: MatIconRegistry,
    public dialog: MatDialog,
    private router: Router) {

    this.role = this.loginService.getrole();
    iconRegistry.addSvgIcon('user', sanitizer.bypassSecurityTrustResourceUrl('assets/user.svg'));
    iconRegistry.addSvgIcon('update', sanitizer.bypassSecurityTrustResourceUrl('assets/update.svg'));
    iconRegistry.addSvgIcon('add', sanitizer.bypassSecurityTrustResourceUrl('assets/add.svg'));
  }

  ngOnInit() {
    this.userProfileService.getProfile(this.role)
      .subscribe(data => { console.table(data), this.username = data.username, this.roleToString(this.role), this.email = data.email, this.adress = data.adresa, this.fullName = data.nume, this.grupa = data.grupa, this.courses = data.courses }, error => { console.log(error) })
  }

  roleToString(role: number) {
    switch (role) {
      case 0: { this.roleString = 'Admin'; this.getAllUsers(); this.getAllCourses(); break; }
      case 1: { this.roleString = 'Teacher'; break; }
      case 2: { this.roleString = 'Student'; break; }
    }
  }

  isStudent() {
    return this.role === 2;
  }


  getAllUsers() {
    this.userProfileService.getAllUsers().subscribe(data => { this.userInfos = new MatTableDataSource(data); console.table(data) }, error => { console.log(error) });
  }

  getRole() {
    return this.role;
  }

  getAllCourses() {
    this.userProfileService.getAllCourses().subscribe(data => { this.courseInfo = new MatTableDataSource(data); }, error => { console.log(error) });
  }

  getCourse(course:CourseNameId){ 
    this.router.navigate(['/course',course.id]);
  }

  deleteCourse(id: number){ 
    this.courseService.deleteCourse(id).subscribe(data=>{console.log(data);this.getAllCourses()}, error=>{console.log(error)});
  }

  public doFilter = (value: string) => {
    this.userInfos.filterPredicate= (data: UserInfo, filter:string) => data.username.trim().toLocaleLowerCase().includes(filter);
    this.userInfos.filter = value.trim().toLocaleLowerCase();
  }
  public doFilterCourse = (value: string) => {
    this.courseInfo.filterPredicate= (data: CourseInfo, filter:string) => data.name.trim().toLocaleLowerCase().includes(filter);
    this.courseInfo.filter = value.trim().toLocaleLowerCase();
  }

  updateUser(id: number){ 
    this.router.navigate(['/updateUser',id]);
  }

  enroll(){ 
    this.router.navigate(['/enroll']);
  }
}








