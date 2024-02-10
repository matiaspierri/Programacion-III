import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ResponseLoginDTO } from 'src/app/dto/ResponseLoginDTO';
import { User } from 'src/app/model/User';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  _url: string = "http://localhost:8080/api/";

  constructor(private http: HttpClient) { }

  getToken(): string | null {
    return localStorage.getItem("token") || null;
  }

  getAuthHeader(): object {
    return { headers: { Authorization: "Bearer " + this.getToken() } };
  }

  login(username: string, password: string): Observable<ResponseLoginDTO> {
    return this.http.post<ResponseLoginDTO>(this._url + "auth/login", {
      username: username,
      password: password,
    });
  }

  register(username: string, password: string, email: string): Observable<ResponseLoginDTO> {
    return this.http.post<ResponseLoginDTO>(this._url + "auth/register", {
      username: username,
      password: password,
      email: email,
    });
  }

  getUserInfo(): Observable<User> {
    return this.http.get<User>(this._url + "user", this.getAuthHeader());
  }

  getUserFriends(): Observable<User[]> {
    return this.http.get<User[]>(this._url + "user/friends", this.getAuthHeader());
  }

  deleteFriend(id: Number): Observable<User> {
    return this.http.delete(this._url + "user/removefriend/" + id, this.getAuthHeader());
  }

  addFriend(username: string): Observable<User> {
    return this.http.post(this._url + "user/addfriend", {}, {
      ...this.getAuthHeader(),
      params: { username: username },
    });
  }
}