import { Component, OnInit } from '@angular/core';
import { University } from 'src/app/models/university.model';
import { UbigeoService } from 'src/app/services/ubigeo.service';

@Component({
  selector: 'app-add-university',
  templateUrl: './add-university.component.html',
  styleUrls: ['./add-university.component.css']
})
export class AddUniversityComponent implements OnInit {
  //Declaraciones relacionadas a las universidades
  universities : University[] = [];

  //Declaraciones relacionadas al ubigeo
  departaments ?: String[];
  provinces ?: String [];

  //Se crea un objeto para guardar el registro de la universidad
  university: University = {
    idUniversity:0,
    name:'',
    type:'',
    state:'',
    startLicense:'',
    endLicense:'',
    ubigeo:{
      idUbigeo: -1,
      departament:'-1',
      province:'-1',
      district:'-1',
    }
  };

  constructor(private ubigeoService : UbigeoService) {
  }

  ngOnInit(): void {
    console.log(this.listDepartament());
    this.listDepartament();
  }
  private listDepartament():void{
    this.ubigeoService.listDepartament().subscribe(departament => {
      this.departaments = departament;
    });
  }

  listProvince():void{
    this.ubigeoService.listProvince(this.university.ubigeo?.departament).subscribe(province =>{
      this.provinces = province;
    })
  }
  registrar():void{

  }

}
