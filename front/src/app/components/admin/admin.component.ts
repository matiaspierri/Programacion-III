import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { User } from 'src/app/model/User';
import { UserService } from 'src/app/services/user/user.service';
import { DeleteDialogComponent } from '../delete-dialog/delete-dialog.component';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  displayedColumns: string[] = ['name', 'email', 'role', 'delete'];
  dataSource: User[] = [];

  constructor(private userService: UserService, public dialog: MatDialog) { }

  ngOnInit(): void {
    this.userService.getUsers().subscribe((response) => {
      this.dataSource = response.filter((user) => user.role?.name !== "ADMIN");
    })
  }

  deleteUser(id: Number) {
    this.userService.deleteUser(id).subscribe(() => {
      this.ngOnInit();
    });
  }

  openDeleteUserDialog(user: User) {
    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;

    dialogConfig.data = {
      dialogTitle: "Delete user",
      dialogContent:
        "Are you sure you want to delete " + user.username + " from your site",
      confirmButtonText: "Yes",
      cancelButtonText: "No",
    };
    const dialogRef = this.dialog.open(DeleteDialogComponent, dialogConfig);
    dialogRef.afterClosed().subscribe((result) => {
      if (result && user.id) {
        this.deleteUser(user.id);
      }
    });
  }

}
