import { Component, Inject } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-add-friend-dialog',
  templateUrl: './add-friend-dialog.component.html',
  styleUrls: ['./add-friend-dialog.component.css']
})
export class AddFriendDialogComponent {
  newFriendForm!: FormGroup;
  dialogTitle!: string;
  errorMessage!: string;
  confirmButtonText!: string;
  cancelButtonText!: string;
  nameUsed!: "";

  constructor(
    private fb: FormBuilder,
    private dialogRef: MatDialogRef<AddFriendDialogComponent>,
    @Inject(MAT_DIALOG_DATA) data: any,
  ) {
    this.dialogTitle = data.dialogTitle;
    this.errorMessage = data.errorMessage;
    this.confirmButtonText = data.confirmButtonText;
    this.cancelButtonText = data.cancelButtonText;
    this.nameUsed = data.nameUsed;
  }

  ngOnInit(): void {
    this.newFriendForm = this.fb.group(
      {
        username: [this.nameUsed, Validators.required],
      }
    );
  }

  get username(): FormControl {
    return this.newFriendForm.controls["username"] as FormControl;
  }


  save(): void {
    this.dialogRef.close(this.newFriendForm.value);
  }

  close(): void {
    this.dialogRef.close();
  }
}
