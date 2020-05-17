import { Component, OnInit } from '@angular/core';
import { TheaterServiceService } from '../services/theater-service.service';
import { screenResponse } from '../dto/screenResponse';
import { screen } from '../models/screen';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-get-screen',
  templateUrl: './get-screen.component.html',
  styleUrls: ['./get-screen.component.css']
})
export class GetScreenComponent implements OnInit {

  service:TheaterServiceService;
  screenList:screenResponse[]=[];
  selectedScreenList:Array<screen>=[];

  screen:screenResponse=null;
result:any;
  check:boolean=false;
  errorShow=false;
  
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
            //console.log(this.selectedScreenList);
        });
      });
    }

    getScreen(screenForm:any){
      let screenId = screenForm.value;
      console.log(screenId);
      this.result=this.service.getScreen(screenId);
     this.result.subscribe((screen:screenResponse) =>{
        this.screen=screen;
        this.check=true;
        this.errorShow=false;
    },
      error =>{
        this.errorShow=true;
        this.check=false;
        console.log("Error "+error)
      });

    }

}
