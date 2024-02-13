import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ResponseLoginDTO } from 'src/app/dto/ResponseLoginDTO';
import { Post } from 'src/app/model/Post';
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

  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this._url + "admin/users", this.getAuthHeader());
  }

  deleteUser(id: Number): Observable<User> {
    return this.http.delete(this._url + "admin/deleteuser/" + id, this.getAuthHeader());
  }

  updateUserInfo(username: string, email: string): Observable<User> {
    return this.http.put(this._url + "user/update", { username: username, email: email }, this.getAuthHeader());
  }

  getPosts(): Observable<Post[]> {
    return this.http.get<Post[]>(this._url + "post/public");
  }

  getPostById(id: number): Observable<Post> {
    return this.http.get<Post>(this._url + "post/public/" + id);
  }

  getMyPosts(): Observable<Post[]> {
    return this.http.get<Post[]>(this._url + "post/user", this.getAuthHeader());
  }

  addPost(content: Post): Observable<Post> {
    return this.http.post<Post>(this._url + "post", content, this.getAuthHeader());
  }

  deletePost(id: number): Observable<Post> {
    return this.http.delete<Post>(this._url + "post/" + id, this.getAuthHeader());
  }

  editPost(id: number, post: Post): Observable<Post> {
    return this.http.put<Post>(this._url + "post/" + id, post, this.getAuthHeader());
  }

  addComment(postId: number, text: string): Observable<any> {
    return this.http.post(this._url + "comment/" + postId, { text: text }, this.getAuthHeader());
  }
}
