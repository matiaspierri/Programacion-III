import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { ResponseLoginDTO } from '../dto/ResponseLoginDTO';
import { User } from '../model/User';
import { Post } from '../model/Post';


@Injectable({
  providedIn: 'root'
})
export class ApiService {

  _url : string = 'http://localhost:8080/api/'

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


  getUserInfo(): Observable<User> {
    return this.http.get<User>(this._url + 'user', this.getAuthHeader())
  }

  getAllPosts(): Observable<Post[]> {
    return this.http.get<Post[]>(this._url+ 'post/all', {headers: { 'Authorization': 'Bearer ' + localStorage.getItem('token')} })
  }

  createPost(newPost: Post): Observable<Post> {
    return this.http.post<Post>(this._url + 'post/create', newPost,this.getAuthHeader())
  }

  deletePost(post: Post): Observable<any> {
    return this.http.delete(this._url + 'post/' + post.id, this.getAuthHeader())
  }


  
}
