import { Component, OnInit } from '@angular/core';
import { screenResponse } from '../dto/screenResponse';
import { TheaterServiceService } from '../services/theater-service.service';

@Component({
  selector: 'app-all-screen',
  templateUrl: './all-screen.component.html',
  styleUrls: ['./all-screen.component.css']
})
export class AllScreenComponent implements OnInit {

  screens:screenResponse[]=[];
  service:TheaterServiceService;
  constructor(service:TheaterServiceService) { 
    this.service=service;
  }

  ngOnInit(): void {
    this.service.fetchAllScreens().subscribe(screens=>{this.screens=screens
      console.log(this.screens)});
  }


}
