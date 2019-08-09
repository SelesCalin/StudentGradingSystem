import { Component, OnInit } from '@angular/core';
import { LoginService} from '../../page/login/login.service';
import { HeaderService } from './header.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  
  constructor(private headerService: HeaderService,
    private router:Router) { }

  ngOnInit() {
  }

  isAuthenticated(){ 
    return this.headerService.getAuthenticated();
  }

  logout(){ 
    this.headerService.logout().subscribe(data=>{ this.router.navigate(['/login']),this.headerService.setAuthenticated(false)},error=>{console.log(error)});
    
  }

}
