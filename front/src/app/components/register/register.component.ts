import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  errorMessage!: string;
  constructor(private authService: AuthService, private router: Router) { }

  formRegister: FormGroup = new FormGroup({
    username: new FormControl("", [Validators.required]),
    password: new FormControl("", [Validators.required]),
    email: new FormControl("", [Validators.required, Validators.email]),
  });

  get username(): FormControl {
    return this.formRegister.controls["username"] as FormControl;
  }
  get password(): FormControl {
    return this.formRegister.controls["password"] as FormControl;
  }
  get email(): FormControl {
    return this.formRegister.controls["email"] as FormControl;
  }

  register() {
    if (this.formRegister.valid) {
      this.authService
        .register(this.username.value, this.password.value, this.email.value)
        .subscribe((response) => {
          if (response.token) {
            this.router.navigateByUrl("/");
          } else {
            this.errorMessage = "Invalid username or password. Please try again.";
          }
        })
    }
  }
}
