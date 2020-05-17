export class screen{

    theaterId:number;
    screenName:string;
    rows:number;
    columns:number;
    
    constructor(theaterId:number,screenName:string, rows:number,columns:number){
        this.theaterId=theaterId;
        this.screenName=screenName;
        this.rows=rows;
        this.columns=columns;
    }
}