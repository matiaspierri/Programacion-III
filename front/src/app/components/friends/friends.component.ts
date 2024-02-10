import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { User } from 'src/app/model/User';
import { UserService } from 'src/app/services/user/user.service';
import { DeleteDialogComponent } from '../delete-dialog/delete-dialog.component';
import { AddFriendDialogComponent } from '../add-friend-dialog/add-friend-dialog.component';

@Component({
  selector: 'app-friends',
  templateUrl: './friends.component.html',
  styleUrls: ['./friends.component.css']
})

export class FriendsComponent implements OnInit {
  displayedColumns: string[] = ['name', 'email', 'delete'];
  dataSource: User[] = [];

  constructor(private userService: UserService,
    public dialog: MatDialog,) { }

  ngOnInit(): void {
    this.userService.getUserFriends().subscribe((response) => {
      this.dataSource = response;
    });
  }

  openDeleteFriendDialog(friend: User) {
    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;

    dialogConfig.data = {
      dialogTitle: "Delete Friend",
      dialogContent:
        "Are you sure you want to delete " + friend.username + " from your friends?",
      confirmButtonText: "Yes",
      cancelButtonText: "No",
    };
    const dialogRef = this.dialog.open(DeleteDialogComponent, dialogConfig);
    dialogRef.afterClosed().subscribe((result) => {
      if (result && friend.id) {
        this.deleteFriend(friend.id);
      }
    });
  }

  deleteFriend(id: Number) {
    this.userService.deleteFriend(id).subscribe(() => {
      this.ngOnInit();
    });
  }

  openAddFriendDialog(errorMessage: string = "", nameUsed: string = "") {
    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;

    dialogConfig.data = {
      dialogTitle: "Add Friend",
      errorMessage: errorMessage,
      confirmButtonText: "Add",
      cancelButtonText: "Cancel",
      nameUsed: nameUsed,
    };

    const dialogRef = this.dialog.open(AddFriendDialogComponent, dialogConfig);
    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        this.userService.addFriend(result.username).subscribe((response) => {
          if (response) {
            this.ngOnInit();
          }
          else {
            this.openAddFriendDialog("User not found. Please try again.", result.username);
          }
        });
      }
    });
  }
}