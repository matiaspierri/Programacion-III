import { Component, OnInit } from '@angular/core';
import { Post } from '../model/Post';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { PostService } from '../services/post.service';


@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  posts: Post[] = [];

  newPostForm = new FormGroup(
    {
      imagePath: new FormControl(''),
      description: new FormControl(''),
      likeCount: new FormControl(''),
    }
  )

  constructor(private postService:PostService){}

  ngOnInit(): void {
    this.postService.getAllPosts().subscribe(
      (data) => {
        console.log(data),
        this.posts = data
      }
    )
  }

  onSubmit(): void {
    let imagePath = this.newPostForm.value.imagePath!
    let description = this.newPostForm.value.description!
    let likeCount = this.newPostForm.value.likeCount!
    this.postService.createPost(imagePath,description,likeCount).subscribe((newPost) => {
      console.log(newPost);
      this.posts.push(newPost)
    })

    this.newPostForm.reset()
  }

  deletePost(post: Post): void {
    this.postService.deletePost(post).subscribe( () => this.posts = this.posts.filter((p) => { return (p.id != post.id)}))
  }



}
