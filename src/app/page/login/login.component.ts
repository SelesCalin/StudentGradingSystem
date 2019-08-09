import { Component, OnInit } from '@angular/core';
import {LoginService} from './login.service';
import { HeaderService } from '../../components/header/header.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  private username: string = '';
  private password: string = '';
  private role: number=-1;
  
  constructor(
    private loginService: LoginService,
    private headerService: HeaderService,
    private router: Router
  ) { }



  ngOnInit() {
  }


  onSubmit() {
    this.loginService.login(this.username, this.password).
    subscribe(data => { console.log(data), this.loginService.setrole(data.role),
     window.localStorage.setItem('token',data.token),this.router.navigate(['/profile']),
     this.headerService.setAuthenticated(true);}, error => { console.log(error) })
  }


  getRole(){ 
    return this.role;
  }

  

  
}
