import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth/auth.service';
import { UserService } from 'src/app/services/user/user.service';

@Component({
  selector: 'app-user-info',
  templateUrl: './user-info.component.html',
  styleUrls: ['./user-info.component.css']
})
export class UserInfoComponent implements OnInit {
  username!: string;
  email!: string;
  role!: string;
  canEdit: boolean = false;

  constructor(private userService: UserService, private authService: AuthService) { }
  ngOnInit(): void {
    this.userService.getUserInfo().subscribe((data: any) => {
      this.username = data.username;
      this.email = data.email;
      this.role = data.role.name;
    });
  }


  editUserInfo() {
    this.canEdit = !this.canEdit;
  }

  update() {
    this.userService.updateUserInfo(this.username, this.email).subscribe((data: any) => {
      this.username = data.username;
      this.email = data.email;
      this.canEdit = false;

    });
  }
}
