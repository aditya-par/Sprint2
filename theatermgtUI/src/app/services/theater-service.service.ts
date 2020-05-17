import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable} from 'rxjs';
import { theaterResponse } from '../dto/theaterResponse';
import { theater } from '../models/theater';
import { screen } from '../models/screen';
import { screenResponse } from '../dto/screenResponse';

@Injectable({
  providedIn: 'root'
})

export class TheaterServiceService {

  client:HttpClient;
  baseTheaterUrl="http://localhost:8086/theaters";
  baseScreenUrl="http://localhost:8086/screens";

  constructor(client:HttpClient) {
    this.client=client;

  }

    addTheater(theater:theater):Observable<theaterResponse>{
      let url = this.baseTheaterUrl+"/add";
      let observable : Observable<theaterResponse> = this.client.post<theaterResponse>(url,theater);
      return observable;
    }

    fetchAllTheaters():Observable<theaterResponse[]>{
      let url = this.baseTheaterUrl;
      let observable : Observable<theaterResponse[]>=this.client.get<theaterResponse[]>(url);
      return observable;
    }

    getTheater(theaterId:number):Observable<theaterResponse>{
      let url = this.baseTheaterUrl+"/get/"+theaterId;
      let result:Observable<theaterResponse> = this.client.get<theaterResponse>(url);
      return result;
    }

    deleteTheater(theaterId:number):Observable<boolean>{
      let url = this.baseTheaterUrl+"/delete/"+theaterId;
      let result: Observable<boolean> = this.client.delete<boolean>(url);
      return result;
    }

    addScreen(screen:screen):Observable<screenResponse>{
      let url = this.baseScreenUrl+"/add";
      let observable : Observable<screenResponse> = this.client.post<screenResponse>(url,screen);
      return observable;
    }

    fetchAllScreens():Observable<screenResponse[]>{
      let url = this.baseScreenUrl;
      let observable : Observable<screenResponse[]>=this.client.get<screenResponse[]>(url);
      return observable;
    }

    getScreen(screenId:any):Observable<screenResponse>{
      let url = this.baseScreenUrl+"/get/"+screenId;
      let result:Observable<screenResponse> = this.client.get<screenResponse>(url);
      return result;
    }

    deleteScreen(screenId:number):Observable<boolean>{
      let url = this.baseScreenUrl+"/delete/"+screenId;
      let result: Observable<boolean> = this.client.delete<boolean>(url);
      return result;
    }
}
