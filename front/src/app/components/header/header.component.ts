import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { AuthService } from "src/app/services/auth/auth.service";

@Component({
  selector: "app-header",
  templateUrl: "./header.component.html",
  styleUrls: ["./header.component.css"],
})
export class HeaderComponent implements OnInit {
  isLoggedIn: Boolean = false;
  username: String = "";
  userRole!: String | undefined;

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit() {
    this.authService.checkTokenAndSetAuthStatus();
    this.authService.isLoggedIn$.subscribe((isLoggedIn) => {
      this.isLoggedIn = isLoggedIn;
    });
    this.authService.userData$.subscribe((userData) => {
      this.username = userData.username!;
      this.userRole = userData.role?.name;
    });
  }

  logout() {
    this.router.navigate(["/"]);
    this.authService.logout();
  }
}
