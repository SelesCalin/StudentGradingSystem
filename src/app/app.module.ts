import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FlexLayoutModule } from '@angular/flex-layout';
import {
  MatButtonModule,
  MatToolbarModule,
  MatIconModule,
  MatBadgeModule,
  MatTabsModule,
  MatSidenavModule,
  MatListModule,
  MatGridListModule,
  MatFormFieldModule,
  MatInputModule,
  MatSelectModule,
  MatRadioModule,
  MatDatepickerModule,
  MatNativeDateModule,
  MatChipsModule,
  MatTooltipModule,
  MatTableModule,
  MatPaginatorModule,
  MatCardModule,
  MatCheckboxModule
} from '@angular/material';
import { FormsModule , ReactiveFormsModule} from '@angular/forms';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './page/login/login.component';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule }    from '@angular/common/http';
import { RegisterComponent } from './page/register/register.component';
import { UserProfileComponent } from './page/user-profile/user-profile.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    UserProfileComponent,
    HeaderComponent,
    FooterComponent
  ],
  imports: [
    HttpClientModule,
    FlexLayoutModule,
    BrowserModule,
    MatTabsModule,
    MatCardModule,
    MatCheckboxModule,
    BrowserAnimationsModule,
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,   
    CommonModule,
    MatButtonModule,
    MatToolbarModule,
    MatIconModule,
    MatSidenavModule,
    MatBadgeModule,
    MatListModule,
    MatGridListModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatRadioModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatChipsModule,
    MatTooltipModule,
    MatTableModule,
    MatPaginatorModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
