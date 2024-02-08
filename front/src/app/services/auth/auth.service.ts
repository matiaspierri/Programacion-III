import { Injectable } from "@angular/core";
import { BehaviorSubject, Observable, of } from "rxjs";
import { ResponseLoginDTO } from "./../../dto/ResponseLoginDTO";
import { User } from "./../../model/User";
import { ApiService } from "./../../services/api/api.service";

@Injectable({
  providedIn: "root",
})
export class AuthService {
  private isLoggedInSubject: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);
  public isLoggedIn$: Observable<boolean> = this.isLoggedInSubject.asObservable();
  public userDataSubject: BehaviorSubject<User> = new BehaviorSubject<User>({});
  public userData$: Observable<User> = this.userDataSubject.asObservable();

  constructor(private apiService: ApiService) { }

  public setLoggedInStatus(isLoggedIn: boolean): void {
    this.isLoggedInSubject.next(isLoggedIn);
  }

  public setUserData(userData: User): void {
    this.userDataSubject.next(userData);
  }

  public checkTokenAndSetAuthStatus(): void {
    if (!!localStorage.getItem("token")) {
      this.apiService.getUserInfo().subscribe(
        (data) => {
          this.setLoggedInStatus(true);
          this.setUserData(data);
        },
        (error) => {
          localStorage.removeItem("token");
          this.setLoggedInStatus(false);
          this.setUserData({});
        }
      );
    } else {
      this.setLoggedInStatus(false);
      this.setUserData({});
    }
  }

  public getUserInfo(): Observable<User> {
    return this.apiService.getUserInfo();
  }

  login(username: string, password: string): Observable<ResponseLoginDTO> {
    let response = this.apiService.login(username, password);
    response.subscribe((jwt) => {
      if (jwt.token) {
        localStorage.setItem("token", jwt.token!);
        this.setLoggedInStatus(true);
        this.apiService.getUserInfo().subscribe((data) => {
          this.setUserData(data);
        });
      } else {
        this.setUserData({});
        this.setLoggedInStatus(false);
      }
    });
    return response;
  }

  logout() {
    localStorage.removeItem("token");
    this.setUserData({});
    this.setLoggedInStatus(false);
  }
}
