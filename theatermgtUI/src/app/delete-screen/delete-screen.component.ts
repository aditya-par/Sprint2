import { Component, OnInit } from '@angular/core';
import { TheaterServiceService } from '../services/theater-service.service';
import { screenResponse } from '../dto/screenResponse';
import { screen } from '../models/screen';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-delete-screen',
  templateUrl: './delete-screen.component.html',
  styleUrls: ['./delete-screen.component.css']
})
export class DeleteScreenComponent implements OnInit {

  service:TheaterServiceService;
  screenList:screenResponse[]=[];
  selectedScreenList:Array<screen>=[];

  response:boolean;
  show:boolean=false;
  
  constructor(service:TheaterServiceService) {
    this.service=service;
   }

  ngOnInit(): void {
    this.service.fetchAllScreens().subscribe(screens=>{
      this.screenList=screens;
      console.log(this.screenList);
      this.screenList.forEach(screen=>
        {
            //console.log(theater);
            this.selectedScreenList.push(screen);
            console.log(this.selectedScreenList);
        });
      });
  }

  deleteScreen(deleteForm:any){
    let screenId = deleteForm.value.screenId;
    console.log(screenId);
    let result : Observable<boolean> = this.service.deleteScreen(screenId);
    result.subscribe((ans:boolean)=>{
    this.response=true;
    console.log(ans);
    this.show=true;
  },
  error =>{
    this.response=false;
    this.show=true;
    console.log("Error "+error)
    });
  }

}
