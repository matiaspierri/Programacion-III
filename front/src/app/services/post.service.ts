import { Injectable } from '@angular/core';
import { Post } from '../model/Post';
import { ApiService } from './api.service';
import { Observable } from 'rxjs';
import { User } from '../model/User';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  posts: Post[] = []
  
  constructor(private api:ApiService){

  }

  getAllPosts(): Observable<Post[]> {
    return this.api.getAllPosts();
  }

  createPost(imagePath:string, description:string, likeCount:string,user:User) : Observable<Post>  {
    let newPost: Post = new Post(imagePath, description, likeCount, user)
    return this.api.createPost(newPost);
  }

  deletePost(Post: Post): Observable<Post>{
    return this.api.deletePost(Post);
  }

  




}
