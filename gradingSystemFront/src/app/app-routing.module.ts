import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './page/login/login.component';
import { RegisterComponent} from './page/register/register.component';
import { UserProfileComponent} from './page/user-profile/user-profile.component';
import { CourseDetailsComponent } from './page/course/course-details/course-details.component';
import { UserUpdateComponent} from './page/user-update/user-update.component';
import { EnrollComponent } from './page/enroll/enroll.component';

const routes: Routes = [
  {path:'', redirectTo:'/login', pathMatch:'full'}, 
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent},
  { path: 'profile', component: UserProfileComponent},
  {path:'course/:id', component: CourseDetailsComponent},
  {path:'updateUser/:id',component: UserUpdateComponent},
  {path: 'enroll',component:EnrollComponent}
 
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
