import { Component, OnInit } from '@angular/core';
import { Ubigeo } from 'src/app/models/ubigeo.model';
import { UbigeoService } from 'src/app/services/ubigeo.service';

@Component({
  selector: 'app-add-university',
  templateUrl: './add-university.component.html',
  styleUrls: ['./add-university.component.css']
})
export class AddUniversityComponent implements OnInit {

  ubigeos ?: Ubigeo[]
  departaments ?: String[];
  constructor(private ubigeoService : UbigeoService) { }

  ngOnInit(): void {
    console.log(this.listDepartament());
    this.listDepartament();
  }
  private listDepartament():void{
    this.ubigeoService.listDepartament().subscribe(departament => {
      this.departaments = departament;
    });
  }
  registrar():void{

  }

}
