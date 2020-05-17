import { Component, OnInit } from '@angular/core';
import { theaterResponse } from '../dto/theaterResponse';
import { TheaterServiceService } from '../services/theater-service.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-get-theater',
  templateUrl: './get-theater.component.html',
  styleUrls: ['./get-theater.component.css']
})
export class GetTheaterComponent implements OnInit {

  theater:theaterResponse=null;

  theaters:Array<theaterResponse>=[];
  __service:TheaterServiceService;
  check:boolean=false;
  errorShow=false;
  
  constructor(__service:TheaterServiceService) {
    this.__service=__service;
   }

  ngOnInit(): void {
  }

  getTheater(getTheaterForm:any){

    let theaterId = getTheaterForm.value.theaterId;
    let response:Observable<theaterResponse>=this.__service.getTheater(theaterId);
    response.subscribe((theater:theaterResponse) =>{
      this.theater=theater;
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
