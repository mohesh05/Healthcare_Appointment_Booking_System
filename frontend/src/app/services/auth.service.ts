import { Injectable } from '@angular/core'; import { HttpClient } from '@angular/common/http'; import { tap } from 'rxjs';
@Injectable({providedIn:'root'}) export class AuthService{ private base='http://localhost:8080/api/auth'; constructor(private http:HttpClient){}
login(data:any){ return this.http.post<any>(`${this.base}/login`,data).pipe(tap(r=>localStorage.setItem('token',r.token))); }
register(data:any){ return this.http.post(`${this.base}/register`,data); }
token(){ return localStorage.getItem('token'); }}
