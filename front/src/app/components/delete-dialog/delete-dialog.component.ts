import { Component, Inject, OnInit } from "@angular/core";
import { MatDialogRef, MAT_DIALOG_DATA } from "@angular/material/dialog";

@Component({
  selector: "app-delete-dialog",
  templateUrl: "./delete-dialog.component.html",
  styleUrls: ["./delete-dialog.component.css"],
})
export class DeleteDialogComponent {
  dialogTitle!: string;
  dialogContent!: string;
  confirmButtonText!: string;
  cancelButtonText!: string;

  constructor(
    private dialogRef: MatDialogRef<DeleteDialogComponent>,
    @Inject(MAT_DIALOG_DATA) data: any
  ) {
    this.dialogTitle = data.dialogTitle;
    this.dialogContent = data.dialogContent;
    this.confirmButtonText = data.confirmButtonText;
    this.cancelButtonText = data.cancelButtonText;
  }

  confirm() {
    this.dialogRef.close(true);
  }
  cancel() {
    this.dialogRef.close(false);
  }
}
