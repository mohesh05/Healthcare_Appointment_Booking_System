import { Component } from '@angular/core';import { CommonModule } from '@angular/common';import { HttpService } from '../../services/http.service';
@Component({standalone:true,imports:[CommonModule],template:`<div class='card'><h3>Admin Dashboard</h3><h4>Users</h4><pre>{{users|json}}</pre><h4>Appointments</h4><pre>{{appts|json}}</pre></div>`})
export class AdminComponent{users:any;appts:any;constructor(http:HttpService){http.adminUsers().subscribe(r=>this.users=r);http.adminAppointments().subscribe(r=>this.appts=r);}}
