import { Component, OnInit, Injectable } from '@angular/core';
import { UserProfileService} from './user-profile.service';
import { LoginService} from '../login/login.service';
import { CourseNameId } from './course-name-id';
import { MatIconRegistry} from '@angular/material/icon';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  private username: string = '';
  private role: number=-1;
  private grupa: number= 0;
  private roleString: string='';
  private courses: CourseNameId[] ;
  private fullName: string='';
  private email: string='';

  constructor(private userProfileService: UserProfileService,
    private loginService: LoginService,
    private sanitizer: DomSanitizer,
    private iconRegistry: MatIconRegistry) {

      this.role=this.loginService.getrole();
      iconRegistry.addSvgIcon('user',sanitizer.bypassSecurityTrustResourceUrl('assets/user.svg'));
     }

  ngOnInit() {
    
    this.userProfileService.getProfile(this.role)
    .subscribe(data=>{console.table(data),this.username =data.username,this.roleToString(this.role),this.email=data.email,this.fullName=data.nume, this.grupa=data.grupa, this.courses=data.courses},error=>{console.log(error)})
  }

  roleToString(role:number){ 
    switch(role){ 
      case 0: {this.roleString='Admin';break;}
      case 1: {this.roleString='Teacher';break;}
      case 2: {this.roleString='Student';break;}
    }
    }

  }


