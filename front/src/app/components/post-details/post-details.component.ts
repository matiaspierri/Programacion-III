import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Post } from 'src/app/model/Post';
import { AuthService } from 'src/app/services/auth/auth.service';
import { CommentService } from 'src/app/services/comment/comment.service';
import { PostService } from 'src/app/services/post/post.service';

@Component({
  selector: 'app-post-details',
  templateUrl: './post-details.component.html',
  styleUrls: ['./post-details.component.css']
})
export class PostDetailsComponent {
  selectedPost!: Post;
  commentText: any;
  isLoggedIn: Boolean = false;

  constructor(private route: ActivatedRoute, private postService: PostService, private commentService: CommentService, private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
    this.authService.isLoggedIn$.subscribe((isLoggedIn) => {
      this.isLoggedIn = isLoggedIn;
    });
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.postService.getPostById(id).subscribe(
      (post) => {
        if (post) {
          this.selectedPost = post;
        }
        else {
          this.router.navigate(['/404']);
        }
      }
    );
  }

  addComment() {
    if (this.selectedPost.id) {
      this.commentService.addComment(this.selectedPost.id, this.commentText).subscribe(
        (comment) => {
          if (comment) {
            this.ngOnInit();
            this.commentText = '';
          }
        }
      );
    }
  }

}
