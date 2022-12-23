import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddUniversityComponent } from './pages/add-university/add-university.component';
import { UniversityComponent } from './pages/university/university.component';
import { HomeComponent } from './pages/home/home.component';

const routes: Routes = [
  {
    path:'',
    component:HomeComponent
  },
  {
    path:'universidades',
    component:UniversityComponent
  },
  {
    path:'registrar',
    component:AddUniversityComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
