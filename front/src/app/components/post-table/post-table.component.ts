import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { Post } from 'src/app/model/Post';

@Component({
  selector: 'app-post-table',
  templateUrl: './post-table.component.html',
  styleUrls: ['./post-table.component.css']
})
export class PostTableComponent {
  @Input() posts: Post[] = [];
  constructor(
    private router: Router
  ) { }

  navigateToDetails(postId: number) {
    this.router.navigate(['post', postId]);
  }
}
