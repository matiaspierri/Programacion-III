import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Bank } from '../model/Bank';
import { ResponseLoginDTO } from '../dto/ResponseLoginDTO';
import { User } from '../model/User';
import { Card } from '../model/Card';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  _url : string = 'http://localhost:8081/api/'

  constructor(private http:HttpClient) { }

  getToken() : string | null {
    return localStorage.getItem('token') || null
  }

  getAuthHeader(): object {
    return {headers: { 'Authorization': 'Bearer ' + this.getToken()} } 
  }

  login(username: string, password: string): Observable<ResponseLoginDTO> {
    return this.http.post<ResponseLoginDTO>(this._url + 'auth/login', {username: username, password: password})
  }

  getAllBanks(): Observable<Bank[]> {
    return this.http.get<Bank[]>(this._url + 'bank', {headers: { 'Authorization': 'Bearer ' + localStorage.getItem('token')} } )
  }

  getBankByName(name: string): Bank | undefined {
    throw new Error('Method not implemented.');
  }

  createBank(newBank: Bank): Observable<Bank> {
    return this.http.post(this._url + 'bank', newBank, this.getAuthHeader())
  }

  deleteBank(bank: Bank): Observable<any> {
    return this.http.delete(this._url + 'bank/' + bank.id, this.getAuthHeader())
  }

  getUserInfo(): Observable<User> {
    return this.http.get<User>(this._url + 'user', this.getAuthHeader())
  }

  getCardsOfUser(): Observable<Card[]> {
    return this.http.get<Card[]>(this._url + "card" ,this.getAuthHeader())
  }

}
