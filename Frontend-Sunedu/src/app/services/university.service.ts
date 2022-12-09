import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { University } from '../models/university.model';

const baseUrl = 'http://localhost:8090/rest/crudDocente';

@Injectable({
  providedIn: 'root'
})
export class UniversityService {

  constructor(private http:HttpClient) { }

  consultUniversity(filtro:string):Observable<any>{
    return this.http.get(baseUrl+"/listUniversityforNombreLike/" + filtro);
  }

  registerUnivesity(u:University):Observable<any>{
    return this.http.post(baseUrl+"/registerUnivesity", u);
  }

  updateUniversity(u:University):Observable<any>{
    return this.http.put(baseUrl+"/updateUniversity", u);
  }


}
