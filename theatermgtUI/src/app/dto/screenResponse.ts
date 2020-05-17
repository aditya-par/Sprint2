
export class screenResponse{

    screenId:any;
    theaterId:any;
    screenName:any;
    rows:any;
    columns:any;
    showList:any;
    constructor(screenId,theaterId,screenName,rows,columns,showList){
        this.screenId=screenId;
        this.theaterId=theaterId;
        this.screenName=screenName;
        this.rows=rows;
        this.columns=columns;
        this.showList=showList;
    }
}