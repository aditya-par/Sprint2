import { Component, OnInit } from '@angular/core';
import { theaterResponse } from '../dto/theaterResponse';
import { TheaterServiceService } from '../services/theater-service.service';


@Component({
  selector: 'app-all-theater',
  templateUrl: './all-theater.component.html',
  styleUrls: ['./all-theater.component.css']
})
export class AllTheaterComponent implements OnInit {

  theaters:theaterResponse[]=[];
  __service:TheaterServiceService;

  constructor(__service:TheaterServiceService) {
    this.__service=__service;
   }
  ngOnInit(): void {
    this.__service.fetchAllTheaters().subscribe(theaters =>{this.theaters=theaters});
  }

}
