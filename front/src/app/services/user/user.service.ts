import { Injectable } from '@angular/core';
import { ApiService } from '../api/api.service';
import { Observable } from 'rxjs';
import { User } from 'src/app/model/User';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private apiService: ApiService) { }

  getUserInfo(): Observable<User> {
    return this.apiService.getUserInfo();
  }

  getUserFriends(): Observable<User[]> {
    return this.apiService.getUserFriends();
  }

  deleteFriend(id: Number): Observable<User> {
    return this.apiService.deleteFriend(id);
  }

  addFriend(username: string): Observable<User> {
    return this.apiService.addFriend(username);
  }
  getUsers(): Observable<User[]> {
    return this.apiService.getUsers();
  }
  deleteUser(id: Number): Observable<User> {
    return this.apiService.deleteUser(id);
  }
}
