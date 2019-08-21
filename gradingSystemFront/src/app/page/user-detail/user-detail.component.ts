import { Component, OnInit, Input, Inject } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { UserProfileService} from '../user-profile/user-profile.service'


@Component({
  selector: 'app-user-detail',
  templateUrl: './user-detail.component.html',
  styleUrls: ['./user-detail.component.css']
})
export class UserDetailComponent implements OnInit {
  @Input('username') username: string;
  @Input('fullName') fullName: string;
  @Input('roleString') roleString: string;
  @Input('adress') adress: string;
  @Input('grupa') grupa: number;
  @Input('role') role: number;
  @Input("email") email: string;
  constructor(public dialog: MatDialog) { }

  ngOnInit() {
  }

  isStudent(){ 
    return this.role===2;
  } 

  openDialogName(){ 
    const dialogRef= this.dialog.open(DialogName, { 
      width: '250px', 
      data:{name:this.fullName},
    });
    
    dialogRef.afterClosed().subscribe(result=>{ if (result.state) {
    this.fullName=result.updatedName;
    console.log(result);
    }
    console.log("ey");});
    }

    openDialogEmail(){ 
      const dialogRef= this.dialog.open(DialogEmail, { 
        width: '250px', 
        data:{name:this.email},
      });
  
      dialogRef.afterClosed().subscribe(result=>{ if (result===true) {
      this.ngOnInit();
      
      console.log(result);
      }
      console.log("ey");});
      }



}


@Component({ 
  selector:'dialog-name',
  templateUrl:'./dialog/dialog-name.html',
})
export class DialogName{ 
  constructor( public dialogRef: MatDialogRef<DialogName>,
      private userService: UserProfileService,
    @Inject(MAT_DIALOG_DATA) public data: any)
    {
      dialogRef.disableClose = true;
    }


    updateName(updateName: string){ 
      if(updateName.length>4){
      this.userService.updateStudentName(updateName).subscribe(data=>{console.log(data)},error=>{console.log(error)});
      }
    }
  }

  @Component({
    selector:'dialog-email',
    templateUrl:'./dialog/dialog-mail.html',
  })
  export class DialogEmail{ 
    constructor(public dialogRef: MatDialogRef<DialogEmail>, 
      private userService: UserProfileService,
      @Inject(MAT_DIALOG_DATA) public data:any){
        dialogRef.disableClose=true;
      }

      updateEmail(updatedEmail: string){ 
        this.userService.updateStudentEmail(updatedEmail).subscribe(data=>{console.log(data)}, error=>{console.log(error)});
      }

      
  }
