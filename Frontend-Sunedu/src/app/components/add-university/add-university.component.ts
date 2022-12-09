import {AfterViewInit, Component, ViewChild} from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import Swal from 'sweetalert2';
import { Ubigeo } from 'src/app/models/ubigeo.model';
import { University } from 'src/app/models/university.model';
import { UbigeoService } from 'src/app/services/ubigeo.service';
import { UniversityService } from 'src/app/services/university.service';

@Component({
  selector: 'app-add-university',
  templateUrl: './add-university.component.html',
  styleUrls: ['./add-university.component.css'],
})
export class AddUniversityComponent implements AfterViewInit {



      //Para la Grilla
      universities: University [] = [];
      filtro: string ="";

      //Para el ubigeo
      departaments: string[] = [];;
      provinces: string[] = [];;
      districts: Ubigeo[] = [];;


    //Json para registrar o actualizar
    university: University = {
      idUniversity:0,
      name:"",
      type:"",
      state:"",
      startLicense:"",
      endLicense:"",
      ubigeo:{
        idUbigeo: -1,
        departament:"-1",
        province:"-1",
        district:"-1",
      }
    };
    constructor(private universityService:UniversityService, private ubigeoService:UbigeoService) {
      this.ubigeoService.listDepartament().subscribe(
          response => this.departaments = response
      );
    }

    cargaProvincia(){
      this.ubigeoService.listProvince(this.university.ubigeo?.departament).subscribe(
        response =>  this.provinces= response
      );
      this.university.ubigeo!.province= "-1";
      this.districts = [];
      this.university.ubigeo!.idUbigeo = -1;
    }

    cargaDistrito(){
    this.ubigeoService.listDistrict(this.university.ubigeo?.departament, this.university.ubigeo?.province).subscribe(
      response =>  this.districts= response
    );
    this.university.ubigeo!.idUbigeo = -1;
    }

    ngOnInit(): void {
    }

    consulta(){
        this.universityService.consultUniversity(this.filtro==""?"todos":this.filtro).subscribe(
          x => this.universities = x
        );
    }

    registra(){
        this.universityService.registerUnivesity(this.university).subscribe(
            x => {
                Swal.fire('Mensaje',x.mensaje,'info');
                document.getElementById("btn_reg_limpiar")?.click();
            }
        );
    }

    busca(obj:University){
      console.log("obj.nombre>>> " + obj.name );
      this.university = obj;

      this.ubigeoService.listProvince(this.university.ubigeo!.departament).subscribe(
          x =>  this.provinces= x
      );

      this.ubigeoService.listDistrict(this.university.ubigeo!.departament, this.university.ubigeo!.province).subscribe(
          x =>  this.districts= x
      );
    }

    actualiza(){
    this.universityService.updateUniversity(this.university).subscribe(
        x => {
            Swal.fire('Mensaje',x.mensaje,'info')
            document.getElementById("btn_act_limpiar")?.click();
        }
    );
    }

    actualizaEstado(obj:University){
    obj.state = obj.state == "1" ? "0" : "1";
    this.universityService.updateUniversity(obj).subscribe();
    }

 dataSource = new MatTableDataSource<University>();

  @ViewChild(MatPaginator) paginator:any= MatPaginator;

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }
}
