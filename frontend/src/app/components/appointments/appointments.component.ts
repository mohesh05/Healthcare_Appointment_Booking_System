import { Component } from '@angular/core';import { HttpService } from '../../services/http.service';import { CommonModule } from '@angular/common';
@Component({standalone:true,imports:[CommonModule],template:`<div class='card'><h3>My Appointments</h3><pre>{{data|json}}</pre></div>`})
export class AppointmentsComponent{data:any;constructor(http:HttpService){http.myAppointments().subscribe(r=>this.data=r);}}
