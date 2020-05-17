import { Component, OnInit } from '@angular/core';
import { TheaterServiceService } from '../services/theater-service.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-delete-theater',
  templateUrl: './delete-theater.component.html',
  styleUrls: ['./delete-theater.component.css']
})
export class DeleteTheaterComponent implements OnInit {

  service:TheaterServiceService;
  show:boolean=false;
  response:string="";

  constructor(service:TheaterServiceService) {
    this.service=service;
   }

  ngOnInit(): void {
  }

  deleteTheater(deleteForm:any){
    let theaterId = deleteForm.value;
    console.log(theaterId);
    let result : Observable<String> = this.service.deleteTheater(theaterId);
    result.subscribe((ans:String)=>{
    this.response="Deleted successfully";
    console.log(ans);
    this.show=true;
  },
  error =>{
    this.response="Invalid Id"
    this.show=true;
    console.log("Error "+error)
    });

}
}