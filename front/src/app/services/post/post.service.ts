import { Injectable } from '@angular/core';
import { ApiService } from '../api/api.service';
import { Observable } from 'rxjs';
import { Post } from 'src/app/model/Post';

@Injectable({
  providedIn: 'root'
})
export class PostService {
  constructor(private apiService: ApiService) { }
  getPosts(): Observable<Post[]> {
    return this.apiService.getPosts();
  }
  getPostById(id: number): Observable<Post> {
    return this.apiService.getPostById(id);
  }
  getMyPosts(): Observable<Post[]> {
    return this.apiService.getMyPosts();
  }
  addPost(post: Post): Observable<Post> {
    return this.apiService.addPost(post);
  }
  deletePost(id: number): Observable<Post> {
    return this.apiService.deletePost(id);
  }
  editPost(id: number, post: Post): Observable<Post> {
    return this.apiService.editPost(id, post);
  }
}
