import { bootstrapApplication } from '@angular/platform-browser';
import { provideRouter, Routes } from '@angular/router';
import { provideHttpClient, withInterceptors } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { importProvidersFrom, Component, inject } from '@angular/core';
import { AuthService } from './app/services/auth.service';
import { HttpService } from './app/services/http.service';
import { jwtInterceptor } from './app/interceptors/jwt.interceptor';
@Component({selector:'app-root',standalone:true,template:`<h1>Healthcare Booking</h1><nav><a routerLink='/login'>Login</a> | <a routerLink='/registration'>Register</a> | <a routerLink='/doctors'>Doctors</a> | <a routerLink='/appointments'>Appointments</a> | <a routerLink='/doctor'>Doctor</a> | <a routerLink='/admin'>Admin</a></nav><router-outlet/>`,imports:[]}) class AppComponent{}
const Simple=(name:string)=>Component({standalone:true,template:`<div class='card'>${name}</div>`})(class{});
const routes: Routes=[{path:'login',loadComponent:()=>import('./app/components/login/login.component').then(m=>m.LoginComponent)},{path:'registration',loadComponent:()=>import('./app/components/registration/registration.component').then(m=>m.RegistrationComponent)},{path:'doctors',loadComponent:()=>import('./app/components/doctors/doctors.component').then(m=>m.DoctorsComponent)},{path:'appointment',loadComponent:()=>import('./app/components/appointment/appointment.component').then(m=>m.AppointmentComponent)},{path:'appointments',loadComponent:()=>import('./app/components/appointments/appointments.component').then(m=>m.AppointmentsComponent)},{path:'doctor',loadComponent:()=>import('./app/components/doctor/doctor.component').then(m=>m.DoctorComponent)},{path:'admin',loadComponent:()=>import('./app/components/admin/admin.component').then(m=>m.AdminComponent)},{path:'',redirectTo:'login',pathMatch:'full'}];
bootstrapApplication(AppComponent,{providers:[provideRouter(routes),provideHttpClient(withInterceptors([jwtInterceptor])),importProvidersFrom(ReactiveFormsModule),AuthService,HttpService]});
