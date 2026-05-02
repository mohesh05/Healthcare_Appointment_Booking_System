import { Component } from '@angular/core';import { HttpService } from '../../services/http.service';import { CommonModule } from '@angular/common';
@Component({standalone:true,imports:[CommonModule],template:`<div class='card'><h3>Doctors</h3><div *ngFor='let d of doctors'>{{d.name}} - {{d.specialization}}</div></div>`})
export class DoctorsComponent{doctors:any[]=[];constructor(http:HttpService){http.doctors().subscribe((r:any)=>this.doctors=r as any[]);}}
