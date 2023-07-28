import { User } from "./User";

export class Post {
    id?: number
    imagePath?: string
    description?: string
    likeCount?: string
    user: User



    constructor(imagePath:string, description:string, likeCount:string, user:User) {
        this.imagePath=imagePath;
        this.description=description;
        this.likeCount=likeCount;
        this.user=user;
    }
    
}