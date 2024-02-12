import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { Post } from 'src/app/model/Post';
import { PostService } from 'src/app/services/post/post.service';
import { AddPostDialogComponent } from '../add-post-dialog/add-post-dialog.component';

@Component({
  selector: 'app-my-posts',
  templateUrl: './my-posts.component.html',
  styleUrls: ['./my-posts.component.css']
})
export class MyPostsComponent implements OnInit {
  public posts: Post[] = [];

  constructor(private postService: PostService, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.postService.getMyPosts().subscribe((data) => {
      this.posts = data;
    });
  }

  openAddPostDialog() {
    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;

    dialogConfig.data = {
      dialogTitle: "Add Post",
      dialogContent: "",
      confirmButtonText: "Add",
      cancelButtonText: "Cancel",
    };

    const dialogRef = this.dialog.open(AddPostDialogComponent, dialogConfig);

    dialogRef.afterClosed().subscribe(result => {
      console.log(result);
      if (result) {
        this.postService.addPost(result).subscribe((data) => {
          this.ngOnInit();
        });
      }
    });

  }
}
