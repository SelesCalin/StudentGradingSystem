import { Component, OnInit } from '@angular/core';
import {ActivatedRoute,Router} from '@angular/router';
import { UserDetailsUpdate } from './user-details-update';
import { UserUpdateService } from './user-update.service';

@Component({
  selector: 'app-user-update',
  templateUrl: './user-update.component.html',
  styleUrls: ['./user-update.component.css']
})
export class UserUpdateComponent implements OnInit {
  private userId: number;
  private userDetails: UserDetailsUpdate;
  private username: string;
  private adress: string;
  private email: string;
  private grupa: number;
  private role: number;
  private name: string;
  private groupList: number[]=[1,2,3,4,5,6,7,8,9,10];

  constructor(private route: ActivatedRoute,
    private userUpdateService: UserUpdateService,
    private router: Router) {
    this.route.params.subscribe(params=>this.userId=params['id']);
   }

  ngOnInit() {
    this.userUpdateService.getDetails(this.userId).subscribe(data=>{this.username=data.username;this.adress=data.adresa;this.email=data.email; this.grupa=data.grupa; this.role=data.role;
    this.name=data.nume; console.log(data)}, error=>{console.log(error)});
  }

  onSubmit(){ 
    this.userUpdateService.update(this.userId,this.username,this.adress,this.email,this.grupa,this.role,this.name).subscribe(data=>{console.log(data),this.router.navigate(['/profile'])}, error=>{console.log(error)})
  }


}
