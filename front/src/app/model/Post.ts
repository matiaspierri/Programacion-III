import { Image } from "./Image";
import { Comment } from "./Comment";

export class Post {
    id?: number;
    title?: string;
    description?: string;
    images?: Image[];
    comments?: Comment[]

    constructor(id: number, title: string, description: string, images: Image[], comments: Comment[]) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.images = images;
        this.comments = comments;
    }
}
