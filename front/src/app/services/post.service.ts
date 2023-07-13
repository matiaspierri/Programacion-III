import { Injectable } from '@angular/core';
import { Post } from '../model/Post';
import { ApiService } from './api.service';
import { Observable } from 'rxjs';

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

  createPost(imagePath:string, description:string, likeCount:string) : Observable<Post>  {
    let newPost: Post = new Post(imagePath, description, likeCount)
    return this.api.createPost(newPost);
  }

  deletePost(Post: Post): Observable<Post>{
    return this.api.deletePost(Post);
  }

  




}
