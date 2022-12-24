import { Ubigeo } from "./ubigeo.model";

export class University{
    idUniversity?:number;
    name?:String;
    type?:String;
    state?:String;
    startLicense?:String;
    endLicense?:String;
    ubigeo ?: Ubigeo;
}
