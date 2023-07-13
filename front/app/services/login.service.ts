import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { ApiService } from './api.service';
import { ResponseLoginDTO } from '../dto/ResponseLoginDTO';
import { Location } from '@angular/common';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  isLoggedUser = false

  constructor(private apiService: ApiService, private router: Router) { }

  login(email: string, password: string) : Observable<ResponseLoginDTO> {
    let response  = this.apiService.login(email, password)
    response.subscribe(
      (jwt) => {
        console.log(jwt)
        localStorage.setItem('token', jwt.token!)
        this.isLoggedUser = true
        this.router.navigateByUrl("/")
      }
    )
    return response
  }

  isUserLogin(): Observable<boolean> {
    this.isLoggedUser = !!localStorage.getItem("token")
    return of(this.isLoggedUser)
  }

  logout() {
    localStorage.removeItem('token')
    this.isLoggedUser = false
  }
}
