import { Component, OnInit } from '@angular/core';

import { User } from 'src/app/model/User';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { UserService } from '../../services/user.service';

import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-user-info',
  templateUrl: './user-info.component.html',
  styleUrls: ['./user-info.component.css']
})
export class UserInfoComponent implements OnInit {

  user!: User

  newCardForm = new FormGroup({
   
  })
  

  constructor(private userService:UserService, private loginService: LoginService) {
    
  }

  ngOnInit(): void {
    this.userService.getUserInfo().subscribe(
      (data: User) => {
        this.user = data
      }
    )
  }

  onSubmit() : void {
    
  }


}
