import { Component, OnInit } from '@angular/core';
import { screen } from '../models/screen';
import { theater } from '../models/theater';
import { TheaterServiceService } from '../services/theater-service.service';
import { theaterResponse } from '../dto/theaterResponse';
import { Observable } from 'rxjs';
import { screenResponse } from '../dto/screenResponse';


@Component({
  selector: 'app-add-screen',
  templateUrl: './add-screen.component.html',
  styleUrls: ['./add-screen.component.css']
})
export class AddScreenComponent implements OnInit {

  screenModel = new screen(0,"",0,0);
  
  selectedTheaterList:Array<theater>=[];

  theaterList:theaterResponse[]=[];
  screenresp:screenResponse=null;
  show:boolean=false;
  service:TheaterServiceService;

  constructor(service:TheaterServiceService) { 
    this.service=service;
  }

  ngOnInit(): void {
    this.service.fetchAllTheaters().subscribe(theaters =>{
        this.theaterList=theaters;
        // console.log(this.theaterList)
      this.theaterList.forEach(theater=>
      {
          // console.log(theater);
          this.selectedTheaterList.push(theater);
          console.log(this.selectedTheaterList);
      });
    });
  }

  addScreen(screenForm:any){
    let details=screenForm.value;
    let theaterId = details.theaterId;
    console.log(theaterId);
    let screenName = details.screenName;
    console.log(screenName);
    let rows = details.rows;
    console.log(rows);
    let columns = details.columns;
    console.log(columns);

    let screenobj : screen = new screen(theaterId,screenName,rows,columns);
    let result : Observable<screenResponse> = this.service.addScreen(screenobj);
    result.subscribe((response : screenResponse)=>{
      this.screenresp=response;
    },
      err =>{
        console.log("Error"+err);
      });

    this.show=true;
  }
}
