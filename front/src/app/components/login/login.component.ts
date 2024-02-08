import { Component } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { AuthService } from "src/app/services/auth/auth.service";

@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.css"],
})
export class LoginComponent {
  errorMessage!: string;
  constructor(private authService: AuthService, private router: Router) { }

  formLogin: FormGroup = new FormGroup({
    username: new FormControl("", [Validators.required]),
    password: new FormControl("", [Validators.required]),
  });

  get username(): FormControl {
    return this.formLogin.controls["username"] as FormControl;
  }
  get password(): FormControl {
    return this.formLogin.controls["password"] as FormControl;
  }

  login() {
    if (this.formLogin.valid) {
      this.authService
        .login(this.username.value, this.password.value)
        .subscribe((response) => {
          if (response.token) {
            this.router.navigateByUrl("/");
          } else {
            this.errorMessage = "Invalid username or password. Please try again.";
          }
        });
    }
  }
}
