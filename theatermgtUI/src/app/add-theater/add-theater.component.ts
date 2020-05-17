import { Component, OnInit } from '@angular/core';
import { theater } from '../models/theater';
import { theaterResponse } from '../dto/theaterResponse';
import { TheaterServiceService } from '../services/theater-service.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-add-theater',
  templateUrl: './add-theater.component.html',
  styleUrls: ['./add-theater.component.css']
})
export class AddTheaterComponent implements OnInit {

  theaterModel = new theater("","","","");

  theaterresp:theaterResponse=null;
  show:boolean=false;
  __service:TheaterServiceService;

  constructor(__service:TheaterServiceService) {
    this.__service=__service;
   }

  ngOnInit(): void {
  }

onSubmitAddTheater(addTheaterForm:any){
  let details = addTheaterForm.value;
  let theaterName = details.theaterName;
  let theaterCity = details.theaterCity;
  let managerName = details.managerName;
  let managerContact = details.managerContact;

  let theaterobj : theater = new theater(theaterName,theaterCity,managerName,managerContact);
  let result : Observable<theaterResponse> = this.__service.addTheater(theaterobj);
  result.subscribe((response:theaterResponse)=>{
    this.theaterresp=response;
  },
    err =>{
      console.log("Error"+err);
    });

    this.show=true;


//   let theater:theaterResponse = new theaterResponse(101,theaterName,theaterCity,[1,2,3],null,managerName,managerContact);  
//  console.log(this.theater);

//   let result:Observable<theaterResponse> = this.__service.addTheater(this.theater);
//   result.subscribe((theaterResp:theaterResponse) =>{
//     this.theater=theaterResp;
//   },
//     err =>{
//       console.log("Error "+err);
//     });
  
//   this.show=true;

}

}
