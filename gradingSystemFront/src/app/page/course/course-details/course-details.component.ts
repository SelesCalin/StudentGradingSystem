import { Component, OnInit, Input } from '@angular/core';
import { CourseInfoAQ } from '../courseInfoAQ';
import { ActivatedRoute} from '@angular/router';
import { CourseService } from '../course.service';
import { setDefaultService } from 'selenium-webdriver/chrome';

@Component({
  selector: 'app-course-details',
  templateUrl: './course-details.component.html',
  styleUrls: ['./course-details.component.css']
})
export class CourseDetailsComponent implements OnInit {
  private courseDetails: CourseInfoAQ=new CourseInfoAQ();
  
  constructor(private route:ActivatedRoute,
    private courseService: CourseService) {
      this.route.params.subscribe(params=>this.getCourse(params['id']));
   }

  ngOnInit() {
    
  }


  getCourse(id: number) {
    this.courseService.getCourse(id).subscribe(data => { this.courseDetails=data, console.table(data) }, error => { console.log(error) });
  }

  getDate(millis: number){ 
    var d= new Date(millis).toString();
    console.log(d);
    return d;
  }

  getDateDate(millis:number){
    return new Date(millis);
  }

 

}
