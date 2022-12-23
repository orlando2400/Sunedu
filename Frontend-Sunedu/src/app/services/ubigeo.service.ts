import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Ubigeo } from '../models/ubigeo.model';

@Injectable({
  providedIn: 'root'
})

export class UbigeoService {
  constructor(private http: HttpClient) {}

  private baseUrl = 'http://localhost:8090/ubigeo';

  listDepartament(): Observable<String[]> {
    return this.http.get<String[]>(`${this.baseUrl}/departmentList`);
  }

 /* listProvince(paramDep: any): Observable<string[]> {
    return this.http.get<string[]>(baseUrl + '/listProvince/' + paramDep);
  }

  listDistrict(paramDep: any, paramProv: any): Observable<Ubigeo[]> {
    return this.http.get<Ubigeo[]>(baseUrl + '/listDsitrict/' + paramDep + '/' + paramProv);
  }*/
}
