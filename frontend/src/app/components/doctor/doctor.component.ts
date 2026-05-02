import { Component } from '@angular/core';import { CommonModule } from '@angular/common';import { HttpService } from '../../services/http.service';
@Component({standalone:true,imports:[CommonModule],template:`<div class='card'><h3>Doctor Dashboard</h3><pre>{{data|json}}</pre></div>`})
export class DoctorComponent{data:any;constructor(http:HttpService){http.doctorAppointments().subscribe(r=>this.data=r);}}
