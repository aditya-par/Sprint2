import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common'
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddTheaterComponent } from './add-theater/add-theater.component';
import { AllTheaterComponent } from './all-theater/all-theater.component';
import { GetTheaterComponent } from './get-theater/get-theater.component';
import { AddScreenComponent } from './add-screen/add-screen.component';
import { DeleteTheaterComponent } from './delete-theater/delete-theater.component';
import { GetScreenComponent } from './get-screen/get-screen.component';
import { AllScreenComponent } from './all-screen/all-screen.component';
import { DeleteScreenComponent } from './delete-screen/delete-screen.component';


@NgModule({
  declarations: [
    AppComponent,
    AddTheaterComponent,
    AllTheaterComponent,
    GetTheaterComponent,
    AddScreenComponent,
    DeleteTheaterComponent,
    GetScreenComponent,
    AllScreenComponent,
    DeleteScreenComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    CommonModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
