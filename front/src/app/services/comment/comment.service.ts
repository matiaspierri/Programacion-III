import { Injectable } from '@angular/core';
import { ApiService } from '../api/api.service';

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  constructor(private apiService: ApiService) { }

  addComment(postId: number, comment: string) {
    return this.apiService.addComment(postId, comment);
  }
}
