import { Component, Inject } from '@angular/core';
import { AbstractControl, FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { Post } from 'src/app/model/Post';

@Component({
  selector: 'app-add-post-dialog',
  templateUrl: './add-post-dialog.component.html',
  styleUrls: ['./add-post-dialog.component.css']
})
export class AddPostDialogComponent {
  newPostForm!: FormGroup;
  dialogTitle!: string;
  dialogContent!: Post;
  confirmButtonText!: string;
  cancelButtonText!: string;

  constructor(
    private fb: FormBuilder,
    private dialogRef: MatDialogRef<AddPostDialogComponent>,
    @Inject(MAT_DIALOG_DATA) data: any,
  ) {
    this.dialogTitle = data.dialogTitle;
    this.dialogContent = data.dialogContent;
    this.confirmButtonText = data.confirmButtonText;
    this.cancelButtonText = data.cancelButtonText;
  }

  ngOnInit(): void {
    this.newPostForm = this.fb.group(
      {
        title: [this.dialogContent.title, [Validators.required]],
        content: [this.dialogContent.content, [Validators.required]],
        images: this.fb.array(
          this.dialogContent.images ? this.dialogContent.images.map((image: any) => this.fb.group({
            title: [image.title, [Validators.required]],
            url: [image.url, [Validators.required]],
          })) : []
        ),
      }
    );
  }

  get title(): FormControl {
    return this.newPostForm.controls["title"] as FormControl;
  }
  get content(): FormControl {
    return this.newPostForm.controls["content"] as FormControl;
  }
  get images(): FormArray {
    return this.newPostForm.controls["images"] as FormArray;
  }

  imageTitle(image: AbstractControl): FormControl {
    return image.get('title') as FormControl;
  }

  imageUrl(image: AbstractControl): FormControl {
    return image.get('url') as FormControl;
  }


  save(): void {
    this.dialogRef.close(this.newPostForm.value);
  }

  close(): void {
    this.dialogRef.close();
  }

  addImage() {
    this.images.push(this.createImageFormGroup());
  }

  removeImage() {
    this.images.removeAt(this.images.length - 1);
  }

  private createImageFormGroup(): FormGroup {
    return this.fb.group({
      title: ["", Validators.required],
      url: ["", Validators.required]
    })
  }
}
