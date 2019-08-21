import { Component, OnInit } from '@angular/core';
import { RegisterService } from './register.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  private username: string = '';
  private password: string = '';
  private confirmPassword: string = '';
  private adress: string='';
  private email: string='';
  private name: string = '';
  private role: number =0;
  private grupa: number = 0;
  private groupList: number[]=[1,2,3,4,5];


  constructor(private registerService: RegisterService,
    private router: Router) { }

  ngOnInit() {
  }


  printrole(){ 
    console.log(this.grupa);
  }

  onSubmit(){ 
    this.registerService.register(this.username,this.password,this.confirmPassword,this.adress,this.email,this.name,this.role,this.grupa)
    .subscribe(data=>{console.log(data),this.router.navigate(['/login'])},error=>{console.log(error)});
  }
}
