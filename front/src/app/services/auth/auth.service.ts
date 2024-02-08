import { Injectable } from "@angular/core";
import { BehaviorSubject, EMPTY, Observable, concatMap, of, switchMap } from "rxjs";
import { ResponseLoginDTO } from "./../../dto/ResponseLoginDTO";
import { User } from "./../../model/User";
import { ApiService } from "./../../services/api/api.service";
import { map, mapTo } from 'rxjs/operators';

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
    return this.apiService.login(username, password).pipe(
      concatMap((response) => {
        if (response.token) {
          const token = response.token;
          localStorage.setItem("token", token!);
          this.setLoggedInStatus(true);
          return this.apiService.getUserInfo().pipe(map((data) => {
            this.setUserData(data);
            return { token: token };
          }));
        } else {
          this.setUserData({});
          this.setLoggedInStatus(false);
          return of({ token: "" });
        }
      }))
  }

  logout() {
    localStorage.removeItem("token");
    this.setUserData({});
    this.setLoggedInStatus(false);
  }

  register(username: string, password: string, email: string): Observable<ResponseLoginDTO> {
    return this.apiService.register(username, password, email).pipe(
      concatMap((response) => {
        if (response.token) {
          const token = response.token;
          localStorage.setItem("token", token!);
          this.setLoggedInStatus(true);
          return this.apiService.getUserInfo().pipe(map((data) => {
            this.setUserData(data);
            return { token: token };
          }));
        } else {
          this.setUserData({});
          this.setLoggedInStatus(false);
          return of({ token: "" });
        }
      }))
  }


}
