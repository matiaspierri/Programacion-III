import { Component, OnInit } from '@angular/core';
import { Post } from '../model/Post';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { PostService } from '../services/post.service';
import { UserService } from "../services/user.service";
import { User } from '../model/User';
import { Role } from "../model/Role";


@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  posts: Post[] = []
  user!: User

  search: string=''

  newPostForm = new FormGroup(
    {
      imagePath: new FormControl(''),
      description: new FormControl(''),
      likeCount: new FormControl(''),
    }
  )

  constructor(private postService:PostService, private userService:UserService){}

  ngOnInit(): void {
    this.postService.getAllPosts().subscribe(
      (data) => {
        console.log(data),
        this.posts = data
      }
    )

    this.userService.getUserInfo().subscribe(
      (data:User) => {
        this.user = data
      }
    )
  }

  onSubmit(): void {
    let imagePath = this.newPostForm.value.imagePath!
    let description = this.newPostForm.value.description!
    let likeCount = this.newPostForm.value.likeCount!


    this.postService.createPost(imagePath,description,likeCount,this.user).subscribe((newPost) => {
      console.log(newPost);
      this.posts.push(newPost)
    })

    this.newPostForm.reset()
  }

  deletePost(post: Post): void {
    this.postService.deletePost(post).subscribe( () => this.posts = this.posts.filter((p) => { return (p.id != post.id)}))
  }

  filterPosts() {
    console.log(this.search);
  }



}
