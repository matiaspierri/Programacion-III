import { Component, Input } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { Post } from 'src/app/model/Post';
import { PostService } from 'src/app/services/post/post.service';

@Component({
  selector: 'app-post-table',
  templateUrl: './post-table.component.html',
  styleUrls: ['./post-table.component.css']
})
export class PostTableComponent {
  @Input() posts: Post[] = [];
  @Input() showActions: boolean = false;
  @Input() editPost(post: Post) { }
  @Input() openDeletePostDialog: (id: number, dialog: MatDialog, postService: PostService) => void = (id: number, dialog: MatDialog, postService: PostService) => { };
  @Input() dialog: MatDialog = {} as MatDialog;
  @Input() postService: PostService = {} as PostService;
  @Input() ngOnInit: () => void = () => { };

  constructor(
    private router: Router,
  ) { }

  navigateToDetails(postId: number) {
    this.router.navigate(['post', postId]);
  }

  deletePost(id: number) {
    this.openDeletePostDialog(id, this.dialog, this.postService);
  }
}
