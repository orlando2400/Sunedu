import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Ubigeo } from '../models/ubigeo.model';

const baseUrl = 'http://localhost:8090/rest/util';

@Injectable({
  providedIn: 'root'
})

export class UbigeoService {
  constructor(private http: HttpClient) {}

  listDepartament(): Observable<string[]> {
    return this.http.get<string[]>(baseUrl + '/listDepartament');
  }

  listProvince(paramDep: any): Observable<string[]> {
    return this.http.get<string[]>(baseUrl + '/listProvince/' + paramDep);
  }

  listDistrict(paramDep: any, paramProv: any): Observable<Ubigeo[]> {
    return this.http.get<Ubigeo[]>(baseUrl + '/listDsitrict/' + paramDep + '/' + paramProv);
  }
}
