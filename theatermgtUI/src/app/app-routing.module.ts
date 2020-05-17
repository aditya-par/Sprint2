import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddTheaterComponent } from './add-theater/add-theater.component';
import { AllTheaterComponent } from './all-theater/all-theater.component';
import { GetTheaterComponent } from './get-theater/get-theater.component';
import { DeleteTheaterComponent } from './delete-theater/delete-theater.component';
import { AddScreenComponent } from './add-screen/add-screen.component';
import { AllScreenComponent } from './all-screen/all-screen.component';
import { GetScreenComponent } from './get-screen/get-screen.component';
import { DeleteScreenComponent } from './delete-screen/delete-screen.component';


const routes: Routes = [
  {path:'addTheater', component:AddTheaterComponent},
  {path:'theaters',component:AllTheaterComponent},
  {path:'findTheater',component:GetTheaterComponent},
  {path:'deleteTheater',component:DeleteTheaterComponent},
  {path:'addScreen',component:AddScreenComponent},
  {path:'screens',component:AllScreenComponent},
  {path:'findScreen',component:GetScreenComponent},
  {path:'deleteScreen',component:DeleteScreenComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
